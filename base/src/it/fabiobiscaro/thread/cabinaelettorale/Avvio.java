package it.fabiobiscaro.thread.cabinaelettorale;

public class Avvio {

	public static void main(String[] args) {
		Seggio s = new Seggio(2);
		Elettore e1 = new Elettore(s, "fabio");
		Elettore e2 = new Elettore(s, "giulio");
		Elettore e3 = new Elettore(s, "claudio");
		Elettore e4 = new Elettore(s, "anna");
		
		Thread t1 = new Thread(e1);
		Thread t2 = new Thread(e2);
		Thread t3 = new Thread(e3);
		Thread t4 = new Thread(e4);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

}
