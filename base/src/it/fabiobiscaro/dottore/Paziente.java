package it.fabiobiscaro.dottore;

public class Paziente implements Runnable {

	Distributore d;
	
	public Paziente(Distributore d) {
		this.d = d;
	}
	
	@Override
	public void run() {
		int mioNumero = d.ritiraNumero();
		System.out.println("Paziente " + Thread.currentThread().getId() +  ": Ho preso il numero " + mioNumero);
		d.attendiNumero(mioNumero);
		System.out.println("Paziente " + Thread.currentThread().getId() +  ": Entro dal dottore! ");
	}

}
