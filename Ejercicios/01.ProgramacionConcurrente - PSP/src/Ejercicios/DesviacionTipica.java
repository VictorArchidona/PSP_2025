package Ejercicios;

public class DesviacionTipica  extends Thread {
    private int[] valores;

    public DesviacionTipica(int[] valores) {
        this.valores = valores;
    }

    /**
     * Pre: ---
     * Post: el metodo run() contiene el codigo a ejecutar por
     * 		parte del hilo.
     */
    public void run() {
        /*
         *  Calcular la media
         */
        int numero = 0;
        for(int i = 0; i < valores.length; i++){

            valores[i] = numero++;
        }

        int media = numero / 100;
        /*
         * Calculo de la desviacion tipica
         */

        double suma = 0.0;
        for (double num : valores) {
            suma += Math.pow(num - media, 2);
        }
        double varianza = suma / valores.length; // si quieres "muestral" usa (datos.length - 1)
        double desviacionTipica = Math.sqrt(varianza);

        System.out.println("Varianza: " + varianza);
        System.out.println("Desviación típica: " + desviacionTipica);
    }
}
