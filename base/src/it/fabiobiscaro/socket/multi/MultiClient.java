package it.fabiobiscaro.socket.multi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MultiClient {
	String nomeServer = "localhost";
	int portaServer = 6789;
	Socket mioSocket;
	BufferedReader tastiera;
	String stringaUtente;
	String stringaRicevutaDalServer;
	PrintWriter outVersoServer;
	BufferedReader inDalServer;
	
	public Socket connetti() {
		System.out.println("2 CLIENT in esecuzione...");
		try {
			tastiera = new BufferedReader(new InputStreamReader(System.in));
			mioSocket = new Socket(nomeServer, portaServer);
			outVersoServer = new PrintWriter(mioSocket.getOutputStream(), true);
			inDalServer = new BufferedReader(new InputStreamReader(mioSocket.getInputStream()));
		} catch(Exception e) {
			e.printStackTrace();
		}
		return mioSocket;
	}
	
	public void comunica() {
		for (;;) {
			try {
				System.out.println("- utente, inserisci la stringa da trasmettere al server");
				stringaUtente = tastiera.readLine();
				// la spedisco al server
				System.out.println("- invio la stringa al server e attendo");
				outVersoServer.println(stringaUtente);
				// leggo la risposta del server
				stringaRicevutaDalServer = inDalServer.readLine();
				System.out.println("- risposta dal server " + "\n" + stringaRicevutaDalServer);
				if (stringaUtente.equals("FINE")) {
					System.out.println("- termina elaborazione e chiude connessione");
					mioSocket.close();
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
	}
	
	public static void main(String[] args) {
		MultiClient cliente = new MultiClient();
		cliente.connetti();
		cliente.comunica();
	}
}
