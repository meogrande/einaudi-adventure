package it.fabiobiscaro.thread.contocorrente;

public class Avvio {
	public static void main(String[] args) {
		// Istanzio il conto
		Conto conto = new Conto();
		// Creo i tre thread passando il conto conto creato come parametro
		Cliente c1 = new Cliente(conto);
		Cliente c2 = new Cliente(conto);
		Cliente c3 = new Cliente(conto);
		// Avvio i tre thread
		Thread t1 = new Thread(c1);
		Thread t2 = new Thread(c2);
		Thread t3 = new Thread(c3);
		// System.out.format("%.3f%n", 3.123345);     // -->  "3.142"
		t1.start();
		t2.start();
		t3.start();
	}
}
