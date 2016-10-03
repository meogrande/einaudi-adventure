package it.fabiobiscaro.thread;

public class CC {
	public static void main(String args[]) {
		monitor conto = new monitor(1000);
		cliente T1 = new cliente(conto);
		cliente T2 = new cliente(conto);
		T1.start();
		T2.start();
		try {
			Thread.sleep(15000);// durata totale=15s
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		T1.stop();
		T2.stop();
	}// fine main
}// fine classe cc

class monitor {
	protected int saldo;

	monitor(int saldoIniziale) {
		saldo = saldoIniziale;
	}// costruttore

	synchronized int getSaldo() {
		return saldo;
	}

	synchronized void deposito(int somma) {
		saldo = saldo + somma;
	}

	synchronized void prelievo(int somma) {
		saldo = saldo - somma;
	}
}// fine monitor

class cliente extends Thread {
	monitor conto;
	int saldo;

	cliente(monitor c) {
		conto = c;
	}// fine costruttore

	public void run() {
		while (true) {
			try {// tempo di latenza del processo=1sec
				this.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			int somma = 500 + (int) (Math.random() * 200);
			if (Math.random() < 0.5)
				synchronized (conto) {
					System.out.print(this.getName());
					conto.deposito(somma);
					saldo = conto.getSaldo();
					System.out.println(" depositati:" + somma + " saldo:" + saldo);
				}
			else
				synchronized (conto) {
					System.out.print(this.getName());
					conto.prelievo(somma);
					saldo = conto.getSaldo();
					System.out.println(" prelevati:" + somma + " saldo:" + saldo);
				} // synchronized
		} // fine while
	}// fine run
}// fine classe cliente