package it.fabiobiscaro.thread.contocorrente;

public class Cliente implements Runnable {

	private Conto c;

	public Cliente(Conto c) {
		this.c = c;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			// Ogni 500 ms estrae a caso se prelevare o
			// depositare soldi nel conto
			// Stampa il saldo alla fine dell'operazione
			double ammontare = Math.random() * 250;

			long cosaFaccio = Math.round(Math.random() + 0.3);
			if (cosaFaccio == 0) { // deposito
				c.aggiungi(ammontare);
				System.out.println("Ho depositato " + ammontare + ". " + "Ora ci sono " + c.estratto() + " €");
			} else {
				c.togli(ammontare);
				System.out.println("Ho prelevato " + ammontare + ". " + "Ora ci sono " + c.estratto() + " €");

			}

			// Attesa di 500ms
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
