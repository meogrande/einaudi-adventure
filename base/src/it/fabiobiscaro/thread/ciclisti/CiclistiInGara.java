package it.fabiobiscaro.thread.ciclisti;

public class CiclistiInGara implements Runnable {
	Ciclista ciclista;
	GaraCiclistica campo;
	int velocita;
	Thread t;
	int conta;
	int posizione;
	
	public CiclistiInGara(Ciclista c, GaraCiclistica g) {
		ciclista=c;
		campo=g;
		conta=0;velocita=2;t = new Thread(this);
		t.start();
		posizione=0;
	}
	
	@Override
	public void run() {
		int dimImmagine=79;
		int dimPista=960;
		//while((ciclista.))
		while((ciclista.getCoordx()+dimImmagine)<dimPista) {
			if ((conta%10)==0)
				velocita=(int)(Math.random()*4+1);
			ciclista.setCoordx(ciclista.getCoordx()+velocita);
			conta++;
			try {Thread.sleep(75);}
			catch (Exception e) {}
			campo.repaint();
		}
		
		posizione=campo.getPosizione();
		campo.controllaArrivi();
	}
	
}
