package it.fabiobiscaro.thread.missitalia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServerTestuale {

	public static void main(String[] args) throws IOException {
		ArrayList<String> lista = new ArrayList<String>();
		lista.add("Anna");
		lista.add("Marta");
		lista.add("Ilaria");
		lista.add("Maria");
		ArrayList<Integer> voti = new ArrayList<Integer>();
		voti.add(0);
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
				for (int i=0; i<lista.size(); i++) {
					out.println(lista.get(i));
				}
				// Invia il fine lista
				out.println("FINE");
			} else {
				// Recupera il nome votato
				String nome = in.readLine();
				// Aggiorno la lista dei voti
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
