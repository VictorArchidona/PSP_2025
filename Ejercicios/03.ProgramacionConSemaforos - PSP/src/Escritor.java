import java.util.Queue;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Escritor extends Thread{

    /**
     * Variables
     */

    private ColaConcurrente queue;

    /**
     * Constructor
     * @param queue
     */

    public Escritor(ColaConcurrente queue) {

        this.queue = queue;

    }

    /**
     * Acción a realizar por el hilo escritor
     */

    public void run() {

        /**
         * Meter mensajes en la cola
         */
        Random rand = new Random();

        for (int i = 0; i < 8; i++) {
            int aleatorio = rand.nextInt(100) + 1;
            String texto = "Numero: " + aleatorio;
            Node nodo = new Node(texto);

            try {
                queue.push(nodo);
                System.out.println("Escritor " + this.getName() + " escribió: " + texto);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
