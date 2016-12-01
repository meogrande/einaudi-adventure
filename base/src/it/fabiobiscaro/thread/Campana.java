package it.fabiobiscaro.thread;

public class Campana implements Runnable {
	String suono;
	int volte;
	static Object lock = new Object();
	
	public Campana(String suono,int volte) {
		this.suono= suono;
		this.volte = volte;
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i=0; i<volte; i++) {
			
			synchronized(lock) {
				System.out.println(i + " " + this.suono);
			}			
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
