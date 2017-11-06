package it.fabiobiscaro.socket.parolero;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

	private Socket uno;
	private Socket due;
	PrintWriter out1;
	PrintWriter out2;
	
	String parola;

	private ServerSocket ss;

	// Classe Thread che si mette in ascolto sul socket
	class ServerThread extends Thread {
		Socket s;

		public ServerThread(Socket s) {
			this.s = s;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			// legge quello che arriva
			while (true) {
				try {
					Scanner in = new Scanner(s.getInputStream());
					String risposta = in.nextLine();
					System.out.println("Il server ha ricevuto: " + risposta + " " + risposta.equals(parola));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public void avvio() {
		// Crea il server socket le connessioni
		try {
			ss = new ServerSocket(9999);
			uno = ss.accept();
			due = ss.accept();
			// Ora invio due parole ai client ogni 10 secondi
			out1 = new PrintWriter(uno.getOutputStream(), true);
			out2 = new PrintWriter(due.getOutputStream(), true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Il programma non può ascoltare contemporaneamente su entrambi i
		// socket: Creo due thread passando le connessioni e li metto in ascolto!
		ServerThread st1 = new ServerThread(uno);
		st1.start();
		ServerThread st2 = new ServerThread(due);
		st2.start();

		// Dopo 5 secondi invio una parola diversa
		while (true) {
			// Scrivo
			parola = "fabio";
			out1.println(parola);
			out2.println(parola);

			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			parola = "giulio";
			out1.println(parola);
			out2.println(parola);

			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {
		// Avvio il server
		Server server = new Server();
		server.avvio();

	}

}
