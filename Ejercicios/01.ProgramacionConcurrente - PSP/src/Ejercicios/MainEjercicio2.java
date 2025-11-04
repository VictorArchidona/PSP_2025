package Ejercicios;
import java.util.Random;
public class MainEjercicio2 {
    /**
     *
     * Nombre: Víctor Manuel Archidona Gil
     * Version: 1.0.0
     * Pre: ---
     * Post: crea 10
     * procesos, de manera que cada uno de ellos se “duerma” un tiempo aleatorio entre 100
     * y 300 milisegundos, y escriba el mensaje correspondiente (“Soy 1”, “Soy 2”, … “Soy 10)
     * un número aleatorio de veces, entre 5 y 15..
     */
    public static void main(String[] args) {
        /*
         * Creación de los hilos
         */
        ThreadEjercicio2[] t = new ThreadEjercicio2[10];
        int contadorHilo = 0;
        for(int i = 0; i < 10; i++) {

            int retardo =   (int)Math.floor(Math.random()*201)+100;
            int veces = (int)Math.floor(Math.random()*16);
            String mensajeInicio = "Soy ";
            int numero = (int)Math.floor(Math.random()*16+5);

            String mensajeFinal = mensajeInicio+numero;

            t[contadorHilo] = new ThreadEjercicio2(mensajeFinal, retardo, veces);
            /*
             * Inicialización de los hilos
             */
            t[contadorHilo].start();
            contadorHilo++;
        }

        /*
         * Esperamos a que terminen los hilos
         */
        try {

            t[contadorHilo].join();

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Fin");
    }
}