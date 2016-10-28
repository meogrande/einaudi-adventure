package it.fabiobiscaro.thread.cabinaelettorale;

public class Elettore implements Runnable {
/**
 * La classe elettore gestisce una persona che chiede di andare a votare
 */
	
	Seggio s; // Il seggio dove l'elettore va a votare
	String nome;
	
	public Elettore(Seggio s, String nome) {
		this.s = s;
		this.nome  = nome;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			int pos = s.vota(nome);
			System.out.println(nome + " vota nella posizione " + pos);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(nome + " finisce di votare nella posizione " + pos);
			s.terminaVoto(pos);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}

}
