package it.fabiobiscaro.database.crud;

import java.util.Date;

public class Amico {
	int id;
	String nome;
	String cognome;
	Date data;

	public Amico(int id, String nome, String cognome, Date data) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.data = data;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Amico [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", data=" + data + "]";
	}

	
	
}
