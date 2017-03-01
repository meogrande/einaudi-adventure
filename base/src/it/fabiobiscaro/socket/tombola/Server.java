package it.fabiobiscaro.socket.tombola;

import it.fabiobiscaro.socket.tombola.buddy.Cartella;

public class Server {

	// 1) Alla connessione il server dà la lista dei numeri
	// 1bis) Il gioco comincia, il server avvisa tutti (GIOCO ON)
	// 2) Il server invia un un numero (NUMERO n)
	// 3) Il client avvisa quando ha vinto (VINCITA quale)
	// 4) Il server avvisa tutti quando ha vinto un client e aggiorna la vincita (VINTO nomeClient)
	// 5) Il server dichiara la fine della partita (GIOCO OFF)
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cartella c = new Cartella();
		// L'elenco dei numeri da dare al client
		int numeri[] = c.getNumeri();
		for (int i : numeri) {
			System.out.println(i + " ");
		}
		
	}

}
