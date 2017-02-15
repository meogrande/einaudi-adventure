package it.fabiobiscaro.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Il message server rimpalla a tutti i client connessi i messaggi ricevuti
 * 
 * @author fabio
 *
 */

public class MessageServer {

	private static ArrayList<PrintWriter> clients;

	private static class MessageServerThread extends Thread {
		Socket s;
		PrintWriter out;
		BufferedReader in;

		public MessageServerThread(Socket s) {
			this.s = s;

			try {
				out = new PrintWriter(s.getOutputStream(), true);
				in = new BufferedReader(new InputStreamReader(s.getInputStream()));
				// Aggiungo il client
				clients.add(out);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();

			// Accetta sempre messaggi?
			try {
				while (true) {
					System.out.println(Thread.currentThread().getId() + " Server in ascolto ");
					String input = in.readLine();
					System.out.println(Thread.currentThread().getId() + " Il server riceve: " + input
							+ " e lo ritrasmette a tutti");
					// Rispedisco a tutti gli output
					for (PrintWriter printWriter : clients) {
						printWriter.println(input);
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				// Se capita qualche errore esce 
				
			}

		}
	}

	public static void main(String[] args) {
		// Inizializzo i client
		clients = new ArrayList<PrintWriter>();
		// Attivo il server
		ServerSocket ss;
		try {
			ss = new ServerSocket(9999);
			while (true) {
				Socket s = ss.accept();
				MessageServerThread mst = new MessageServerThread(s);
				mst.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
