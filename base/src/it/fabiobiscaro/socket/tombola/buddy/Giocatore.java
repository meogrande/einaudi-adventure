package it.fabiobiscaro.socket.tombola.buddy;
/*
	Copyright (C) 2015-2016 Mario Cianciolo <mr.udda@gmail.com>

	This file is part of Tombola.

	Tombola is free software: you can redistribute it and/or modify
	it under the terms of the GNU General Public License as published by
	the Free Software Foundation, either version 3 of the License, or
	(at your option) any later version.

	Tombola is distributed in the hope that it will be useful,
	but WITHOUT ANY WARRANTY; without even the implied warranty of
	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
	GNU General Public License for more details.

	You should have received a copy of the GNU General Public License
	along with Tombola.  If not, see <http://www.gnu.org/licenses/>.
*/

import java.util.ArrayList;

public class Giocatore {
	private final String nome;
	private Cartella cart;
	private ArrayList<Vincita> vincite;
	private float sommaVinta;

	public Giocatore (String nome_) {
		nome = nome_;
		vincite = new ArrayList<>();
		sommaVinta = 0;
	}
	
	public void nuovaCartella() { // da chiamare ad ogni inizio di partita
		cart = new Cartella();
		Utility.info("Nuova cartella per "+getNome());
		cart.stampa();
	}
	public Cartella getCartella() {
		return cart;
	}
	
	public String getNome() {
		return nome;
	}

	
	public void aggiungiSommaVinta(float importo) {
		if (importo > 0)
			sommaVinta += importo;
	}
	public float getSommaVinta() {
		return sommaVinta;
	}
	
	public boolean getVincita(Vincita v) {
		return vincite.contains(v);
	}
	public void setVincita(Vincita v) {
		vincite.add(v);
	}
	
	public void stampa() {
		Utility.info("Giocatore: "+getNome());
		
		String vv = "Vincite: ";
		for (Vincita v: Vincita.values()) {
			if (getVincita(v))
				vv += v.name()+" ";
		}
		Utility.info(vv);
		Utility.info("Somma vinta: "+getSommaVinta());
		Utility.info();

	}

}
