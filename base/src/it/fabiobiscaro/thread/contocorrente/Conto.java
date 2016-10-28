package it.fabiobiscaro.thread.contocorrente;

public class Conto {
	private double soldi;
	
	public Conto() {
		soldi=1000;
	}
	
	public synchronized void aggiungi(double quanto) {
		soldi += quanto;
		notify();
	}
	
	public synchronized void togli(double quanto) {
		while (soldi < quanto) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} // fine while
		soldi -= quanto;
	}
	
	public double estratto() {
		return soldi;
	}
}
