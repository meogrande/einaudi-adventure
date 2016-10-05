package it.fabiobiscaro.thread.concorrenza;

public class Parco {
	public static void main(String[] args) {
		Parcheggio park = new Parcheggio(5);
		for (int i = 1; i <= 10; i++) {
			Macchina c = new Macchina("Auto " + i, park);
		}
	} // fine main
} // fine classe

class Parcheggio { // monitor
	public int posti;

	public Parcheggio(int posti) {
		this.posti = posti;
	}

	public synchronized void entra() { // entra nel parcheggio
		while (posti == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} // fine while
		posti--;
	} // fine synchronized

	public synchronized void esce() { // esce dal parcheggio
		posti++;
		notifyAll();
	} // fine synchronized
} // fine classe parcheggio

class Macchina extends Thread {
	private Parcheggio park;

	public Macchina(String nome, Parcheggio p) { // costruttore
		super(nome);
		this.park = p;
		start();
	}

	public void run() {
		while (true) {
			try {
				sleep((int) (Math.random() * 20000)); // guida prima del
														// parcheggio
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (park) {
				park.entra();
				System.out.println(getName() + ": è entrata liberi:" + park.posti);
			} // fine synchronized
			try {
				sleep((int) (Math.random() * 10000)); // tempo di parcheggio
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (park) {
				park.esce();
				System.out.println(getName() + ": è uscita liberi:" + park.posti);
			} // fine synchronized
		} // fine while
	} // fine run
} // fine classe macchina