package it.fabiobiscaro.thread.dottore;

public class Distributore {
	int numeroAttesa;
	int numeroServito;
	
	public Distributore() {
		numeroAttesa = 1;
		numeroServito = 1;
	}
	
	// paziente che ritira il numero
	public synchronized int ritiraNumero() {
		numeroAttesa++;
		notifyAll();
		return numeroAttesa;
	}
	
	// paziente che attende il suo numero
	public synchronized void attendiNumero(int numero) {
		while(numeroServito!=numero) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}
	
	// dottore che imposta il numero iniziale
	public void impostaInizio(int numero) {
		numeroAttesa = numero;
		numeroServito = numero;
	}
	
	/*
	 * Il dottore controlla se c'è un paziente in lista 
	 */
	public synchronized int esistePaziente() {
		while (numeroAttesa==numeroServito) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		numeroServito++;
		notifyAll();
		return numeroServito;
	}
	// dottore avvisa chi sta facendo
}
