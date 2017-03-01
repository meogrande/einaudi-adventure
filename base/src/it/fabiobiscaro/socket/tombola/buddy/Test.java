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

public class Test {

	public static void main(String[] args) {
		Gestore g = new Gestore();
	
		// aggiunge NUM_GIOCATORI giocatori al gestore g. La partita
		// inizia automaticamente non appena ci sono abbastanza giocatori
		for (int i=0; i<Gestore.NUM_GIOCATORI; i++) {
			g.iscrivi(new Giocatore("Giocatore "+i));
		}
	}
	
}
