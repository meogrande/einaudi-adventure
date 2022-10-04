package it.fabiobiscaro.thread.lettorescrittore;
/*
 * Implementare un programma in Java dove alcuni Thread 
 * scrivano all’interno di un ArrayList una certa informazione. 
 * Il numero massimo di scritture è pari a 10, stampare a video 
 * un messaggio per gli scrittori.
 * Allo stesso tempo altri Thread voglio leggere e stampare a video 
 * tutto il contenuto dell’array.
 * Garantire usando i semafori la mutua esclusione della risorsa condivisa.
 */

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Buffer {
	private ArrayList<String> frasi;
	public static Semaphore semaphore;
	private static Buffer buffer;

	private Buffer() {
		semaphore = new Semaphore(1); // Un accesso solo al semaforo
		frasi = new ArrayList<String>();
		// frasi.add("prova");
	}

	public static Buffer createBuffer() {
		if (buffer == null) {
			buffer = new Buffer();
		}
		return buffer;
	}

	public ArrayList<String> getFrasi() {
		try {
			semaphore.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<String> f1 = (ArrayList<String>) frasi.clone();
		semaphore.release();
		return f1;
	}

	@Override
	public String toString() {
		try {
			semaphore.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String s = frasi.toString();
		semaphore.release();
		// TODO Auto-generated method stub
		return s;
	}

	public void addValue(String value) {
		if (frasi.size() < 10) {
			try {
				semaphore.acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			frasi.add(value);
			semaphore.release();
		}
	}
}
