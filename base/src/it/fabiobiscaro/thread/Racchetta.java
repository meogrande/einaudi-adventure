package it.fabiobiscaro.thread;

/**
 * Created by fabio on 18/01/2016.
 */
public class Racchetta implements Runnable {
    String pallina;
    public Racchetta(String pallina) {
        this.pallina = pallina;
    }
    @Override
    public void run() {
        while (true){
            System.out.println(pallina);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
            Thread.yield();
        }
    }
}
