package it.fabiobiscaro.imagescroll;

import org.eclipse.swt.widgets.Display;

public class ProvaThread extends Thread {
	private Prova prova;
	
	public ProvaThread(Prova prova) {
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i=0; i<10; i++) {			
			System.out.println("Prova");
			try {
				System.out.println("Thread " + i + " " + Thread.activeCount());
				Thread.sleep(1000); // 1000 milliseconds is one
									// second.
			} catch (InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
		}
	}
}
