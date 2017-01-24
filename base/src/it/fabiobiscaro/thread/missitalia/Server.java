package it.fabiobiscaro.thread.missitalia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

	public static void main(String[] args) throws IOException {
		ArrayList<String> lista = new ArrayList<String>();
		lista.add("fabio");
		lista.add("giulio");
		lista.add("claudio");
		ArrayList<Integer> voti = new ArrayList<Integer>();
		voti.add(0);
		voti.add(0);	
		voti.add(0);
		
		// Crei un server di connessione
		ServerSocket ss = new ServerSocket(9999);
		while (true) {
			// riceva una connessione
			Socket s = ss.accept();
			// riceva del testo
			InputStreamReader isr = new InputStreamReader(s.getInputStream());
			BufferedReader in = new BufferedReader(isr);
			String comando = in.readLine();

			if (comando.equalsIgnoreCase("LISTA")) {
				// invia la lista
				PrintWriter out = new PrintWriter(s.getOutputStream(), true);
				out.println(lista.get(0));
				out.println(lista.get(1));
				out.println(lista.get(2));
				// Invia il fine lista
				out.println("FINE");
			} else {
				String nome = in.readLine();
				int pos = -1;
				for (int i=0; i<lista.size(); i++) {
					if (lista.get(i).equalsIgnoreCase(nome)) {
						voti.set(i, voti.get(i).intValue()+1);
					}
				}
				for (int i=0; i<lista.size(); i++) {
					System.out.println(lista.get(i) + " " + voti.get(i));
				}
			}

			s.close();
			// riparta
		}

	}

}
