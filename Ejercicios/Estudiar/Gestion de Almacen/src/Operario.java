import java.util.ArrayList;

public class Operario implements Runnable {

    private int id;

    public Operario(int id) {

        this.id = id;
    }

    //El hilo lo que hace es meter la pieza creada en el run y meterlo dentro de la pila en AlmacenSincronizado
    @Override
    public void run() {

        for(int i = 0; i < 14; i++){

            String nombre = "Pieza "+i;

            Pieza pieza = new Pieza(i, nombre);

            AlmacenSincronizado as = new AlmacenSincronizado(new ArrayList<>());

            try {
                as.push(pieza);

            } catch (InterruptedException e) {

                System.out.println("Error al hacer el push en la clase Operario");

            }

        }

    }
}
