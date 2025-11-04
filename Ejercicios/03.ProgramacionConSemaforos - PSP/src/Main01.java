import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Main01 {

    /**
     * Nombre: Victor Manuel Archidona
     * Version: 1.0.0
     * El objetivo de este ejercicio es programar un sistema concurrente formado por:
     * ● 4 procesos escritores: Cada escritor inserta 8 mensajes de texto en la cola.
     * ● 5 procesos lectores: Cada lector saca 6 mensajes de la cola. Después de extraer
     * su contenido muestra por la salida estándar su identificador de proceso y el texto
     * obtenido.
     */
    public static void main(String[] args) throws InterruptedException {

        /**
         * Inicializar las variables del programa
         */


        Thread[] hilos_escritores = new Thread[4];
        Thread[] hilos_lectores = new Thread[5];

        ColaConcurrente queue = new ColaConcurrente();

        /**
         * Añadir hilos a los vectores
         */

        for(int i = 0; i < 4; i++){

            hilos_escritores[i] = new Escritor(queue);
            hilos_escritores[i].start();

        }

        for (int i = 0; i < 5; i++) {
            /**
             * Los lectores leen los mensajes y los borran de la cola
             */

            hilos_lectores[i] = new Lector(queue);
            hilos_lectores[i].start();
        }

        for (Thread t : hilos_escritores) t.join();
        for (Thread t : hilos_lectores) t.join();

        System.out.println("Hilos terminados");
    }
}