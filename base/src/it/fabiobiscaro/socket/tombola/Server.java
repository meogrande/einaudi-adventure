package it.fabiobiscaro.socket.tombola;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import it.fabiobiscaro.socket.tombola.buddy.Cartella;

public class Server {

	// 1) Alla connessione il server dà la lista dei numeri
	// 1bis) Il gioco comincia, il server avvisa tutti (GIOCO ON)
	// 2) Il server invia un un numero (NUMERO n)
	// 3) Il client avvisa quando ha vinto (VINCITA quale)
	// 4) Il server avvisa tutti quando ha vinto un client e aggiorna la vincita
	// (VINTO nomeClient)
	// 5) Il server dichiara la fine della partita (GIOCO OFF)

	public static void main(String[] args) {

		// Apertura server
		try {
			// Crei un server di connessione
			ServerSocket ss = new ServerSocket(9999);
			while (true) {
				// riceva una connessione
				Socket s = ss.accept();
				// riceva del testo
				InputStreamReader isr = new InputStreamReader(s.getInputStream());
				BufferedReader in = new BufferedReader(isr);
				
				// Invio i numeri
				// TODO Auto-generated method stub
				Cartella c = new Cartella();
				// L'elenco dei numeri da dare al client
				int numeri[] = c.getNumeri();
				for (int i : numeri) {
					System.out.print(i + " ");
					s.getOutputStream().write(i);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		

	}

}
