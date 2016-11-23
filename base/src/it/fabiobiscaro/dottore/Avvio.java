package it.fabiobiscaro.dottore;

public class Avvio {

	public static void main(String[] args) {
		// Avvio il distributore
		Distributore distributore = new Distributore();
		// Avvio dottore
		Dottore d = new Dottore(distributore);
		Thread t = new Thread(d);
		t.start();
		// Avvio 10 pazienti, uno mezzo secondo
		for (int i=0; i<10; i++) {
			Paziente p = new Paziente(distributore);
			Thread t1 = new Thread(p);
			t1.start();				
		}
	}

}
