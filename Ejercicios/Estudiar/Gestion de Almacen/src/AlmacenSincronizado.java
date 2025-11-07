import java.util.concurrent.Semaphore;

public class AlmacenSincronizado {


    private Semaphore semaforo;


    public AlmacenSincronizado(){


        this.semaforo = new Semaphore(1);
    }
}
