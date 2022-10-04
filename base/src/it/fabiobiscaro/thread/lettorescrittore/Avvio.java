package it.fabiobiscaro.thread.lettorescrittore;

public class Avvio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Lettore l = new Lettore();
		Thread tl = new Thread(l);
		tl.start();
		
		Scrittore s = new Scrittore("uno");
		Thread ts = new Thread(s);
		ts.start();
		
		
		Scrittore s2 = new Scrittore("due");
		Thread ts2 = new Thread(s2);
		ts2.start();
	}

}
