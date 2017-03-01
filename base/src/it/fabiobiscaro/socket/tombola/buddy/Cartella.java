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

import java.util.Arrays;

public class Cartella {
	private int[] numeri; // numeri contenuti in questa cartella
	final private boolean[] segnati; // true se il numero corrispondente è segnato
	
	public Cartella() {
		segnati = new boolean[15]; //default tutti false
		inizializzaCartella();
	}

	// Restituisce la vincita più alta presente in questa cartella
	public Vincita vincitaMax() {
		// Registra quanti numeri estratti in ogni riga della cartella
		final int[] righe = new int[3];
		for (int i=0; i<15; i++) {
			if (segnati[i])
				righe[(int)(i/5)] ++;
		}

		// Controlla tombola
		if (righe[0] + righe[1] + righe[2] == 15) // tutti i numeri segnati
			return Vincita.Tombola;
		
		// Niente tombola, calcola la riga migliore (quella con più numeri segnati)
		final int v = Math.max(righe[0], Math.max(righe[1], righe[2]));
		switch(v) {
			case 2:   // due numeri estratti nel caso migliore
				return Vincita.Ambo;
			case 3:   // tre numeri estratti nel caso migliore
				return Vincita.Terna;
			case 4:   // quattro numeri estratti nel caso migliore
				return Vincita.Quaterna;
			case 5:   // cinque numeri estratti nel caso migliore
				return Vincita.Cinquina;
			default:  // zero o un numero estratto nel caso migliore
				return null;
		}
	}

	// Chiamata ogni volta che viene estratto un numero
	public boolean numeroEstratto(final int numero) {
		// cerca il numero tra quelli presenti nella cartella, e se presente lo segna estratto
		final int indice = Utility.indexOf(numero, numeri, Gestore.NUM_IN_UNA_CARTELLA);
		if (indice >= 0) {
			segnati[indice] = true;
			return true;
		}
		return false;
	}
	
	// Posiziona i numeri nella cartella
	private void inizializzaCartella() {
		numeri = new int[15]; 
		// Riempio il vettore con 15 numeri casuali che rispettino le regole:
		// 1. no numeri ripetuti
		// 2. max 2 numeri con la stessa decina
		final int[] decine = new int[10]; //indica quanti numeri per ogni decina
		for (int i=0; i<15; i++) {
			// Genero un numero casuale tra 1 e 90
			final int n = Utility.generaCasuale(1, 90);
			// Decina attuale
			final int d = n==90? 8 : n/10; //il 90 va nella colonna degli 80

			// Se il numero casuale generato è già presente oppure se ci sono già due
			// numeri con la stessa decina, ripeto il calcolo dell'elemento i-esimo
			if (decine[d] >= 2 || Utility.indexOf(n, numeri, i) >= 0) {
				i--;
				continue;
			} else {
				numeri[i] = n;
				decine[d]++;
			}
		}

		// Ordina il vettore finale
		Arrays.sort(numeri);

		// Permuta per ottenere le righe finali (un elemento ogni tre nel vettore ordinato)
		int tmp = numeri[1];
		numeri[1] = numeri[3];
		numeri[3] = numeri[9];
		numeri[9] = numeri[13];
		numeri[13] = numeri[11];
		numeri[11] = numeri[5];
		numeri[5] = numeri[2];
		numeri[2] = numeri[6];
		numeri[6] = numeri[4];
		numeri[4] = numeri[12];
		numeri[12] = numeri[8];
		numeri[8] = numeri[10];
		numeri[10] = numeri[5];
		numeri[5] = tmp;
		
		// Scambia (in verticale) i numeri della stessa colonna se non sono in ordine tra loro
		for (int i=0; i<15; i++) {
			final int n = numeri[i];
			final int d = n/10;
			for (int j=i; j<15; j++) {
				final int n2 = numeri[j];
				final int d2 = n2/10;
				
				if (d == d2 && n>n2) { // d==d2: stessa colonna, n>n2 ordine invertito
					final int temp = numeri[i];
					numeri[i] = numeri[j];
					numeri[j] = temp;
				}
			}
		}
	}
	
	// Rappresentazione testuale
	public void stampa() {
		final String spacer = "   ";
		for (int r=0; r<3; r++) {
			String output = "";
			int d = 0;
			for (int c=0; c<5; c++) {
				int index = r*5+c;
				int num = numeri[index];

				// spazi per i numeri mancanti (per incolonnare i numeri nella giusta decina)
				int _d = (int)((double)num/10.0);
				if (num == 90) // il 90 va nella colonna degli 80
					_d = 8;
				for (int i=1; i<_d-d+(c==0?1:0); i++)
					output += spacer+"   ";
				d = _d;

				// stampa numero
				output += String.format("%s%02d%c", spacer, num, (segnati[index]?'#':' '));
			}

			Utility.info(output);
		}
	}

	/**
	 * Modificato da Fabio, ritorna i 15 numeri generati 
	 * @return
	 */
	public int[] getNumeri() {
		return numeri;
	}
}
