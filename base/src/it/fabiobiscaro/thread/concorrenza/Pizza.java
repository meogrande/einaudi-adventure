package it.fabiobiscaro.thread.concorrenza;

class Pizza {
	public static void main(String[] args) {
		pizzaiolo p = new pizzaiolo();
		Cliente c = new Cliente(p, 5000);
		c.setPriority(Thread.MAX_PRIORITY);
		c.start();
		synchronized (p) {
			p.cuoco();
			System.out.println("(proprietario): mangia!");
		} // fine synchronized
	}// fine main
}// fine classe

class pizzaiolo {// monitor
	private int tempo=3000;

	synchronized void cottura(int quanto) {
		tempo = quanto;
		System.out.println("(pizzaiolo): è pronta fra: " + tempo / 1000 + "    secondi");
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	} // fine synchronized

	synchronized void cuoco() {
		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		notifyAll();
		System.out.println("(pizzaiolo): è pronta!");
	} // fine synchronized
} // fine classe pizzaiolo

class Cliente extends Thread {
	pizzaiolo s;
	int attesa;

	Cliente(pizzaiolo s, int attesa) {
		this.s = s;
		this.attesa = attesa;
	} // fine costruttore

	public void run() {
		s.cottura(attesa);
		System.out.println("(cliente):gnam gnam....");
	}// fine run
}// fine classe cliente