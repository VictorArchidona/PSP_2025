public class Transportista implements Runnable{

    private int id;
    private AlmacenSincronizado almacen;

    public Transportista(int id, AlmacenSincronizado almacen) {

        this.id = id;
        this.almacen = almacen;
    }

    @Override
    public void run() {

        for(int i = 0; i < 9; i++){

            try {
                Pieza pieza = almacen.pop();
                System.out.println("Transportista " + id + " consumió: " + pieza.getNombre());

            } catch (InterruptedException e) {

                System.out.println("Error al hacer el pop en la clase Transportista");

            }

        }

    }

}
