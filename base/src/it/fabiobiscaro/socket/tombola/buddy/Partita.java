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

public class Partita {
	final private Giocatore[] giocatori;
	final private Tabellone tab;
	private Vincita ultimaVincita;

	final private static float montepremi = Gestore.NUM_GIOCATORI * Gestore.PREZZO_CARTELLA;
	
	public Partita(final Giocatore[] g) {
		giocatori = g;
		tab = new Tabellone();
		ultimaVincita = null;
		Utility.info("Creata nuova partita");
	}
	
	// Calcola l'importo della vincita.
	public static float calcolaVincita(Vincita v) {
		// suddivido il montepremi in base alla vincita
		switch (v) {
			case Ambo:
				return montepremi/15*1;
			case Terna:
				return montepremi/15*2;
			case Quaterna:
				return montepremi/15*3;
			case Cinquina:
				return montepremi/15*4;
			case Tombola:
				return montepremi/15*5;
			default:
				return 0;
		}
	}
	
	public void avviaCiclo() {
		while(true) { // ciclo infinito, termina solo quando finisce la partita
			final int n = tab.estraiNumero();
			Utility.info("Estratto numero: "+n);

			// controllo se il numero è presente in qualche cartella
			final ArrayList<Giocatore> vincitori = new ArrayList<>();
			for (Giocatore g: giocatori) {
				final Cartella c = g.getCartella();
				if (c.numeroEstratto(n)) {
					Utility.info("La cartella di "+g.getNome()+" contiene il numero!");
					final Vincita v = c.vincitaMax();
					if (v == Vincita.next(ultimaVincita)) {
						// il giocatore ha vinto, aggiungi alla lista dei vincitori per dividere il premio
						vincitori.add(g);
						Utility.info("La cartella di "+g.getNome()+" vince: "+v.name());
						c.stampa();
					}
				}
			}
			
			// suddivide la vincita tra gli eventuali vincitori
			if (vincitori.size() > 0) {
				ultimaVincita = Vincita.next(ultimaVincita);
				float importo = calcolaVincita(ultimaVincita) / vincitori.size();
				Utility.info("Divido la vincita ("+ultimaVincita.name()+") tra "+vincitori.size()+" giocatori: ciascuno "+importo);
				for (Giocatore g: vincitori) {
					g.setVincita(ultimaVincita);
					g.aggiungiSommaVinta(importo);
				}
			}
			
			if (ultimaVincita == Vincita.Tombola) {
				Utility.info("Tombola uscita, partita finita!");
				return;
			}
		}
	}
}

