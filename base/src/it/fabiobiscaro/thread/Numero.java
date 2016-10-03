package it.fabiobiscaro.thread;

/**
 * Created by fabio on 18/01/2016.
 */
public class Numero implements Runnable {
    int numero;
    
    public static Object o = new Object();
    public static int valore = 100;
    
    public Numero(int numero) {
        this.numero = numero;
    }
    @Override
    public void run() {
        while (true){
        	synchronized (o) {
        		valore += numero;
                System.out.println(valore);
			}
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
            Thread.yield();
        }
    }
}
