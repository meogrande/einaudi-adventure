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

public enum Vincita {
	Ambo,
	Terna,
	Quaterna,
	Cinquina,
	Tombola;
	
	// restituisce la vincita successiva a quella indicata
	public static Vincita next(final Vincita v) {
		if (v == null)
			return Ambo;
		else if (v == Ambo)
			return Terna;
		else if (v == Terna)
			return Quaterna;
		else if (v == Quaterna)
			return Cinquina;
		else if (v == Cinquina)
			return Tombola;
		else // if (v == Tombola)
			return null;
	}
}