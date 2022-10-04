package it.fabiobiscaro.thread.lettorescrittore;

import java.util.concurrent.TimeUnit;

public class Scrittore implements Runnable {
	Buffer buffer;
	String frase;
	
	public Scrittore(String frase) {
		buffer = Buffer.createBuffer();
		this.frase = frase;
	}

	@Override
	public void run() {
		// Aggiunge un valore nel buffer
		while (true) {
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			buffer.addValue(frase);
		}
	}
}
