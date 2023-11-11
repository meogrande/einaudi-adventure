package it.fabiobiscaro.a2023.grafica;

public class Quadrato extends Poligono {
	
	int colore;
	
	public Quadrato(int lunghezzaLato, int colore) {
		super(4, lunghezzaLato);
		this.colore = colore;
	}
	
	public void setNumeroLati(int numeroLati) {
		this.numeroLati = 4;
	}

}
