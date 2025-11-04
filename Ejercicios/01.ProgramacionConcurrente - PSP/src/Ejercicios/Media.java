package Ejercicios;

public class Media extends Thread {
    private int[] valores;

    public Media(int[] valores) {
        this.valores = valores;
    }

    /**
     * Pre: ---
     * Post: el metodo run() contiene el codigo a ejecutar por
     * 		parte del hilo.
     */
    public void run() {

        int numero = 0;
        for(int i = 0; i < valores.length; i++){

            numero += valores[i];
        }

        double media = (double) numero / valores.length;
        System.out.println("El media de los numeros es: " + media);
    }
}
