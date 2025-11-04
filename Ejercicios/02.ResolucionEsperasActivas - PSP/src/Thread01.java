public class Thread01 extends Thread {
    private float[][] matriz;
    private float[] vector;
    private float[] resultados;
    private int inicio, fin;

    public Thread01(float[][] matriz, float[] vector, float[] resultados, int inicio, int fin) {

        this.matriz = matriz;
        this.vector = vector;
        this.resultados = resultados;
        this.inicio = inicio;
        this.fin = fin;
    }



    /**
     * Pre: ---
     * Post: el metodo run() contiene el codigo a ejecutar por
     * 		parte del hilo.
     */
    @Override
    public void run() {
        /**
         * Calculo de multiplicar el vector por el modulo
         */
        for(int i = inicio; i < fin; i++){

            float resultado = 0;
            for(int j = 0; j < vector.length; j++){

                resultado += matriz[i][j] * vector[j];

            }
            resultados[i] = resultado;
        }

    }
}
