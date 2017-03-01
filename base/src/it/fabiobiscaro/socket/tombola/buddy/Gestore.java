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

import java.util.ArrayDeque;

public class Gestore {
	// Costanti modificabili
	public final static int    NUM_GIOCATORI          = 10;			// giocatori necessari per una partita
	public final static float  PREZZO_CARTELLA        = 10.00f;     // prezzo di una cartella

	// Costanti intrinseche della tombola, NON modificabili
	public final static int    NUM_IN_UNA_CARTELLA    = 15;
	public final static int    RIGHE_IN_UNA_CARTELLA  = 3;

	private ArrayDeque<Giocatore> coda;
	
	public Gestore() {
		coda = new ArrayDeque<>();
	}
	
	public void iscrivi(Giocatore g) {
		// controllo se il giocatore non sia già in coda
		if (!coda.contains(g)) {
			Utility.info("Aggiunto giocatore alla coda: "+g.getNome());
			coda.addLast(g);
		}

		// la partita si avvia automaticamente se viene raggiunto il numero minimo
		if (coda.size() >= NUM_GIOCATORI) {
			Utility.info("È stato raggiunta la soglia di "+NUM_GIOCATORI+" giocatori in coda. Avvio la partita");
			iniziaPartita();
		}
	}
	
	private void iniziaPartita() {
		// crea la lista dei giocatori
		final Giocatore[] giocatori = new Giocatore[NUM_GIOCATORI];
		for (int i=0; i<NUM_GIOCATORI; i++) {
			Giocatore g = coda.removeFirst();
			g.nuovaCartella();
			giocatori[i] = g;
		}
		
		// crea e avvia la partita
		final Partita p = new Partita(giocatori);
		p.avviaCiclo();
		
		// partita finita, riepilogo
		Utility.info("RIEPILOGO");
		for (Giocatore g: giocatori) {
			g.stampa();
		}
	}
	
}

