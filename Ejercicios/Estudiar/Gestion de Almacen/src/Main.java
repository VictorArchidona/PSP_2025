//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        AlmacenSincronizado as = new AlmacenSincronizado(new java.util.ArrayList<Pieza>());

        Thread[] operarios = new Thread[3];

        Thread[] transportistas = new Thread[5];

        for(int i = 0; i < operarios.length; i++){

            operarios[i] = new Thread(new Operario(i, as));
            operarios[i].start();

        }

        for(int i = 0; i < transportistas.length; i++){

            transportistas[i] = new Thread(new Transportista(i, as));
            transportistas[i].start();

        }

        for (int i = 0; i < transportistas.length; i++){

            try {
                transportistas[i].join();
            } catch (InterruptedException e) {
                System.out.println("Error al hacer el join en la clase Main");
            }
        }

        for (int i = 0; i < operarios.length; i++){

            try {
                operarios[i].join();
            } catch (InterruptedException e) {
                System.out.println("Error al hacer el join en la clase Main");
            }
        }
    }
}