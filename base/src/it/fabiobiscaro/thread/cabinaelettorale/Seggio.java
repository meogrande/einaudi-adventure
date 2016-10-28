package it.fabiobiscaro.thread.cabinaelettorale;

/**
 * La classe seggio gestisce le cabine elettorali Ha 3 cabine elettorali
 * 
 * @author fabio
 *
 */
public class Seggio {
	boolean cabine[];
	int n = 0;

	// n sono le postazioni del seggio
	public Seggio(int n) {
		cabine = new boolean[n];
		for (int i = 0; i < n; i++) {
			cabine[i] = false;
		}
		this.n = n;
	}

	/**
	 * Riserva una posizione per votare se ci sono posizioni libere
	 */
	public synchronized int vota(String nome) {
		// Cerca una posizione libera
		int i = n;
		while (i == n) {
			for (i = 0; i < n; i++) {
				System.out.println(nome + " prova la cabina " + i);
				if (cabine[i] == false) {
					break;
				}
			}
			// Attende che si liberi
			if (i == n) {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		// Se trova una posizione attende un po' e poi la libera
		// la occupa
		cabine[i] = true;
		
		return i;
	}
	
	public synchronized void terminaVoto(int n) {
		
		cabine[n] = false;
		notifyAll();
	}
}
