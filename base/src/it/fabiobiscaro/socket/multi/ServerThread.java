package it.fabiobiscaro.socket.multi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerThread extends Thread {
	ServerSocket server = null;
	Socket client = null;
	String stringaModificata = null;
	String stringaRicevuta = null;
	BufferedReader inDalCLient;
	PrintWriter outVersoClient;

	public ServerThread(Socket socket) {
		this.client = socket;
	}

	public void run() {
		try {
			System.out.println(" Server " + Thread.currentThread().getId() + " attivo");
			comunica();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void comunica() throws Exception {
		inDalCLient = new BufferedReader(new InputStreamReader(client.getInputStream()));
		outVersoClient = new PrintWriter(client.getOutputStream(), true);
		for (;;) {
			stringaRicevuta = inDalCLient.readLine();
			if (stringaRicevuta == null || stringaRicevuta.equals("FINE")) {
				outVersoClient.println(stringaRicevuta + " (server in chiusura...) ");
				System.out.println(Thread.currentThread().getId() + " Echo sul server in chiusura: " + stringaRicevuta);
				break;
			} else {
				outVersoClient.println(stringaRicevuta + " (ricevuta e ritrasmessa) ");
				System.out.println(Thread.currentThread().getId() + " Echo sul server: " + stringaRicevuta);
			}
		}
		outVersoClient.close();
		inDalCLient.close();
		System.out.println("Server: chiusura socket " + client);
		client.close();
	}
}
