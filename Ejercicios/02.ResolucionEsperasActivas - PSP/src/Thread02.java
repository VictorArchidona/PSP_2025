import java.util.concurrent.Semaphore;

public class Thread02 extends Thread {
    private int id;
    private float[][] matriz;
    private float[] vector;
    private float[] resultados;
    private int inicio, fin;
    private TiempoCompartido tC;
    private int id_Mas_Lento;
    private Semaphore s;

    public Thread02(int id, float[][] matriz, float[] vector, float[] resultados, int inicio, int fin, int id_Mas_Lento,  Semaphore s, TiempoCompartido tC) {

        this.id = id;
        this.matriz = matriz;
        this.vector = vector;
        this.resultados = resultados;
        this.inicio = inicio;
        this.fin = fin;
        this.id_Mas_Lento = id_Mas_Lento;
        this.s = s;
        this.tC = tC;
    }

    public int getId_Mas_Lento() {
        return id_Mas_Lento;
    }

    public TiempoCompartido gettC() {
        return tC;
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

        long tiempo_Inicial = System.nanoTime();
        long fin = System.nanoTime();
        long duracion = fin - tiempo_Inicial;

        synchronized (tC) {

            if (duracion > tC.tMax) {
                tC.tMax = Math.toIntExact(duracion);
                tC.id_Mas_Lento = id;
            }
        }
    }
}
