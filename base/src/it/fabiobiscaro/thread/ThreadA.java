package it.fabiobiscaro.thread;

public class ThreadA {
		
	public static class ThreadB extends Thread {
		int total;
		@Override
		public void run() {
			// TODO Auto-generated method stub
			//super.run();
			synchronized (this) {
				for(int i=0; i<10; i++) {
					total += i;
					System.out.println("Totale parziale: " + total);
				}
				notify();
			}
		}
	}
	
	public static void main(String[] args) {		
		ThreadB a = new ThreadB();
		a.start();
		synchronized (a) {
			try { 
				System.out.println("Attesa...");
				//a.wait();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			System.out.println("Total is: " + a.total);
		}
		
	}
}
