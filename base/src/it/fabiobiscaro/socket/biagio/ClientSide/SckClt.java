/***
 * @author BiRG81
 * @descrption Classe Client-Side allo scopo di:
 * - instaurare una connessione con il server
 * - mandare al server, attraverso un socket, messaggi di testo
 * - chiudere da remoto il socket nel caso in cui il messaggio inviato sia END
 ***/

package it.fabiobiscaro.socket.biagio.ClientSide;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;



public class SckClt {

	public static void main(String[] args) throws IOException {

		// prelievo da linea di comando dei parametri IP, PORT, MSG
		final String IP = (args.length > 0) ? args[0] : "localhost";
		final int PORT = (args.length > 1) ? Integer.parseInt(args[1]) : 1234;
		final String MSG = (args.length > 2) ? args[2] : "VAT 69 - Un wisky maschio senza rischio!";

		// Creazione di uno stream per la scrittura sul buffer
		PrintWriter out = null;

		//instaurazione del socket
		Socket s = new Socket(IP, PORT);

		out = new PrintWriter(s.getOutputStream(), true);
		out.println(MSG);		// invio messagio al server

		System.out.print(
			"Client attivo [" + s.getLocalAddress() + "]\n" +
			" - Connesso al Server: " + IP + ":" +PORT + "\n" +
			" - invio messaggio: " + MSG + "..\n");

		s.close();
		System.out.println("Client chiuso...");
	}

}
