package it.fabiobiscaro.lista;

public class Persona {
	private String nome;
	private String cognome;
	/**
	 * Anno di nascita
	 */
	private int anno;

	private Persona next;

	/**
	 * Costruttore di una persona
	 * 
	 * @param nome
	 * @param cognome
	 * @param anno
	 */
	public Persona(String nome, String cognome, int anno) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.anno = anno;
		next = null; // Imposto a null il prossimo elemento
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public int getAnno() {
		return anno;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}

	public Persona getNext() {
		return next;
	}

	public void setNext(Persona next) {
		this.next = next;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + anno;
		result = prime * result + ((cognome == null) ? 0 : cognome.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		if (anno != other.anno)
			return false;
		if (cognome == null) {
			if (other.cognome != null)
				return false;
		} else if (!cognome.equals(other.cognome))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Persona [nome=" + nome + ", cognome=" + cognome + ", anno=" + anno + "]";
	}

	
}
