/***
* @author BiRG81
* @descrption Classe Server-Side allo scopo di:
* - rimanere in ascolto in attesa di una connessione con un client
* - accettare una connessione con più client
* - ricevere messaggi dai client e stampari a console
* - instaurare protocollo C/S che per la chiusura Server alla ricezione di un messaggio "END"
***/

package it.fabiobiscaro.socket.biagio.ServerSide;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;	// [*] in alternativa: commentare e usare le classi successive
//import java.io.BufferedReader;
//import java.io.InputStreamReader;



public class SckSrv {
	public static void main(String[] args) throws IOException {
		// prendo la porta da linea di comando
		final int PORT = (args.length > 0) ? Integer.parseInt(args[0]) : 1234;
		ServerSocket ss = null;		// server che si mette in ascolto
		Socket s = null;			// socket per l'instaurazione della connessione
		Scanner in = null;			// lettura dei dati dallo stream buffer [*] in alternativa
		// BufferedReader in = null;
		String CMD = null;			//messaggio ricevuto dal Client


		ss = new ServerSocket(PORT);
		System.out.println("Server creato, in ascolto sulla porta: " + PORT);

		for(;;) {				// [*] alternativa al classico while (true)
		//while(true) {			// instaura la connessione col client
			s = ss.accept();
			System.out.println("Accettata connesione da: " + s.getInetAddress() + ":" + s.getPort());

			in = new Scanner(s.getInputStream());		// in alternativa [*]
			CMD = in.nextLine();

			// in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			// CMD = in.readLine();

			System.out.println("clt: " + CMD);
			s.close();

			if(CMD.equals("END")) {
				ss.close();
				in.close();
				System.out.println("Server Chiuso!..");
				break;
			}
		}

		System.out.println("Programma Terminato!..");
	}
}
