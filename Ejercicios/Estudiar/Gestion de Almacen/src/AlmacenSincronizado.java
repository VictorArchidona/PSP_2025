import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class AlmacenSincronizado {

    private Semaphore huecosVacios;
    private Semaphore mutex;
    private Semaphore hayPiezas;
    private ArrayList<Pieza> piezas;

    public AlmacenSincronizado(ArrayList<Pieza> piezas) {

        this.piezas = piezas;
        this.huecosVacios = new  Semaphore(12);
        this.hayPiezas = new   Semaphore(0);
        this.mutex = new Semaphore(1);
    }

    public ArrayList<Pieza> getPiezas() {
        return piezas;
    }

    public void push(Pieza pieza) throws InterruptedException {

        hayPiezas.acquire();
        mutex.acquire();
        piezas.add(pieza);
        mutex.release();
        hayPiezas.release();
    }

    public Pieza pop() throws InterruptedException {

        hayPiezas.acquire();
        mutex.acquire();
        Pieza resultado = piezas.getLast();
        piezas.removeLast();
        mutex.release();
        huecosVacios.release();

        return resultado;
    }
}
