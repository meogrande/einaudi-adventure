package it.fabiobiscaro.thread;

public class ThreadStart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Racchetta r1 = new Racchetta("ping");
		Racchetta r2 = new Racchetta("pong");
		Racchetta r3 = new Racchetta("pang");
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		Thread t3 = new Thread(r3);
		t1.start();
		t2.start();
		t3.start();*/
		Numero r1 = new Numero(2);
		Numero r2 = new Numero(10);
		
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		t1.start();
		t2.start();
		
	}
}
