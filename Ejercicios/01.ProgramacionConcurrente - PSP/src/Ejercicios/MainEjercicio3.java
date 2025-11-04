package Ejercicios;
import java.util.Random;

public class MainEjercicio3 {
    /**
     * Nombre: Victor Manuel Archidona
     * Version: 1.0.0
     * Pre: ---
     * Post: crea 10
     * procesos, de manera que cada uno de ellos se “duerma” un tiempo aleatorio entre 100
     * y 300 milisegundos, y escriba el mensaje correspondiente (“Soy 1”, “Soy 2”, … “Soy 10)
     * un número aleatorio de veces, entre 5 y 15..
     */
    public static void main(String[] args) {
        /*
         * Creación del vector
         */
        int[] vector = new int[40];
        Random random = new Random();
        /*
         * Añadir numeros al vector creado anteriormente
         */

        for (int i = 0; i < vector.length; i++) {
            vector[i] = random.nextInt(40);
        }

        /*
         * Creacion de hilos
         */
        MinMax min_Max = new MinMax(vector);
        Media media = new Media(vector);
        DesviacionTipica desviacion_tpc = new DesviacionTipica(vector);

        /*
         * Inicializar los hilos
         */
        min_Max.start();
        media.start();
        desviacion_tpc.start();
        /*
         * Esperamos a que terminen los hilos
         */
        try {

            media.join();
            desviacion_tpc.join();
            min_Max.join();

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Fin");

    }
}