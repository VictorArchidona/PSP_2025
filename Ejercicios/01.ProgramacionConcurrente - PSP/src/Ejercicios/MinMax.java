package Ejercicios;

public class MinMax  extends Thread {
    private int[] valores;
    private int menor;
    private int mayor;

    public MinMax(int[] valores) {
        this.valores = valores;
    }

    /**
     * Pre: ---
     * Post: el metodo run() contiene el codigo a ejecutar por
     * 		parte del hilo.
     */
    public void run() {

         mayor = valores[0];
         menor = valores[0];

        for (int i : valores) {
            if (i > mayor) {
                mayor = i;
            }
            if ( i < menor) {
                menor = i;
            }
        }


        System.out.println("El numero mayor es: " + mayor);
        System.out.println("El numero menor es: " + menor);
    }
}
