import java.util.concurrent.Semaphore;

public class Lector extends Thread {

    /**
     * Variables
     */
    private ColaConcurrente queue;

    // Constructor
    public Lector(ColaConcurrente queue) {

        this.queue = queue;
    }

    @Override
    public void run() {

        for (int i = 0; i < 6; i++) {

            try{
                Node nodo = queue.pop();
                System.out.println("Lector: " + i + " = " + nodo.getContent());

            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
