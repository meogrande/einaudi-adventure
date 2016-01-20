package it.fabiobiscaro.prodotti;

public class Prodotto implements Cloneable {
	String codice;//Torresan Pajazzo
	String descrizione;
	float prezzo;

	public Prodotto(String codice, String descrizione, float prezzo) {
		super();
		this.codice = codice;
		this.descrizione = descrizione;
		this.prezzo = prezzo;
	}

	/**
	 * Ciao a tutti!
	 * @return
	 */
	public String getCodice() {
		return codice;
	}


	/**
	 * Questo metodo imposta un bel codice 
	 * @param codice
	 */

	public void setCodice(String codice) {
		this.codice = codice;
	}

	/**
	 * Restituisce la descrizione
	 * @return
	 */
	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}

	public void applicaSconto() {
		this.prezzo = this.prezzo * 0.95f;
	}

	@Override
	public String toString() {
		return "Cod: " + codice + " descrizione: " + descrizione + " prezzo:" + prezzo;
	}

	@Override
	public boolean equals(Object obj) {
		// Sono uguali se sono uguali tutti i campi
		Prodotto p = (Prodotto) obj;
		if (p.getCodice().equals(codice) && p.getDescrizione().equals(descrizione) && p.getPrezzo() == prezzo) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
}
