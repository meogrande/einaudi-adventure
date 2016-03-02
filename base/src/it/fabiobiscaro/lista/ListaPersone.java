package it.fabiobiscaro.lista;

/**
 * Una lista puntata di persone
 * @author fabio
 *
 */
public class ListaPersone {
	private Persona testa;
	
	public ListaPersone() {
		testa = null;
	}
	
	/**
	 * Aggiunge una persona alla lista
	 * @param p
	 */
	public void add(Persona p) {
		if (testa == null) {
			testa = p;			
		} else {
			// Faccio l'inserimento in testa
			// Metto la testa nel prossimo del nuovo elemento
			p.setNext(testa);
			// Metto il nuovo elemento in testa
			testa = p;			
		}
	}
	
	/**
	 * Numero di elementi della lista
	 */
	public int size() {
		int numero  = 0;
		
		Persona temp = testa;
		while (temp!=null) {
			temp = temp.getNext();
			numero ++;
		}
		
		return numero;
	}
	
	/**
	 * restituisce il componente iesimo
	 */
	public Persona get(int i) {
		int pos  = 0;
		
		Persona temp = testa;
		while (pos<i && temp!=null) {
			temp = temp.getNext();
			pos ++;
		}
		
		// Se non trova l'elemento ritorna null
		if (pos==i) {
			return temp;
		} else {
			return null;
		}
	}
}
