import java.util.ArrayList;

public class Operario implements Runnable {

    private int id;
    private AlmacenSincronizado almacen;

    public Operario(int id, AlmacenSincronizado almacen) {

        this.id = id;
        this.almacen = almacen;
    }

    //El hilo lo que hace es meter la pieza creada en el run y meterlo dentro de la pila en AlmacenSincronizado
    @Override
    public void run() {

        for(int i = 0; i < 14; i++){

            String nombre = "Pieza "+i;

            Pieza pieza = new Pieza(i, nombre);

            try {
                almacen.push(pieza);
                System.out.println("Operario " + id + " produjo: " + nombre);

            } catch (InterruptedException e) {

                System.out.println("Error al hacer el push en la clase Operario");

            }

        }

    }
}
