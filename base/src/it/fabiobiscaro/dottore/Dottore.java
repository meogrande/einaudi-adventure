package it.fabiobiscaro.dottore;

public class Dottore implements Runnable {

	Distributore d;
	
	public Dottore(Distributore d) {
		this.d = d;
	}
	
	@Override
	public void run() {
		// d.impostaInizio(numero);
		// TODO Auto-generated method stub
		while(true) {
			System.out.println("Dottore " + Thread.currentThread().getId() +  ": attendo paziente ");
			int p = d.esistePaziente();
			System.out.println("Dottore " + Thread.currentThread().getId() +  ": servo paziente " + p);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
