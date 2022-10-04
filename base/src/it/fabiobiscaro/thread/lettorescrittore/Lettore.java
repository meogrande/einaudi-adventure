package it.fabiobiscaro.thread.lettorescrittore;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Lettore implements Runnable {
	Buffer buffer;
	
	public Lettore() {
		buffer = Buffer.createBuffer();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		// Ogni 5 secondi stampa ciao
		while (true) {
			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String frasi = buffer.toString();
			System.out.println("Contento del buffer:" + frasi);

		}
	}
}
