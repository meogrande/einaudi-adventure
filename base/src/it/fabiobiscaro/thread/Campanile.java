package it.fabiobiscaro.thread;

public class Campanile {
	public static void main(String[] args) {
		Campana c1 = new Campana("ciao",33);
		Campana c2 = new Campana("fabio",33);
		Thread t1 = new Thread(c1);
		Thread t2 = new Thread(c2);
		t1.start();
		t2.start();
	}
}
