import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * Nombre: Victor Manuel Archidona
 * Version: 1.0.0
 * Pre: ---
 * Post: El ejercicio pide calcular el módulo del vector resultante de multiplicar una matriz por un
 * vector. Para ello, 16 procesos distintos llevan a cabo el cálculo del producto de la matriz
 * por el vector: cada proceso se implementará mediante un thread y realizará el producto
 * parcial de 32 filas. Una vez que todos han acabado, un proceso informador calcula
 * su módulo, el tiempo que tarda en terminar y el id del hilo y lo muestra por la salida estándar.
 */


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main02 {
    public static void main(String[] args) {

        /**
         * Declaración de variables
         */

        int nTickets = 2;

        Semaphore s = new Semaphore(nTickets);
        TiempoCompartido tiempo_Compartido = new TiempoCompartido();

        Random rand = new Random();
        int num = 511;

        /**
         * Crear la matriz, el vector, los resultados (de 512) y los threads
         */

        float[][] matriz = new float[num][num];
        float[] vector = new float[num];

        float[] resultados = new float[num];

        Thread[] threads = new Thread[16];

        /**
         * Llena el vector y la matriz de numeros aleatorios del 0-100
         */

        for(int i = 0; i < num; i++){

            matriz[i][i] = rand.nextFloat(101);
            vector[i] = Math.abs(rand.nextFloat(101));
        }

        /**
         * Creacion de hilos y añadirlos al array de threads
         */

        Thread02 tarea = null;

        for(int i = 0; i < 16; i++){
            int inicio = i * 32;
            int fin = Math.min(inicio + 32, matriz.length);
            tarea = new Thread02(i, matriz, vector, resultados, inicio, fin,1, s, tiempo_Compartido);
            threads[i] = tarea;
            tarea.start();
        }

        /*
         * Inicializar los hilos
         */

        for (int i = 0; i < 16; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        /**
         * Mostrar resultados
         */

        for(int i = 0; i < 16; i++){
            float numero = resultados[i];
            System.out.println(i + ": " + numero);
        }
        System.out.println("Le ha costado al mas lento: "+ tarea.gettC().tMax);
        System.out.println("ID del mas lento: "+tarea.getId_Mas_Lento());
        System.out.println("Fin");
    }
}