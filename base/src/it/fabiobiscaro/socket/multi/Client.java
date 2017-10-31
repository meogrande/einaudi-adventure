package it.fabiobiscaro.socket.multi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
	String nomeServer = "localhost";
	int portaServer = 6789;
	Socket socket;
	BufferedReader tastiera;
	PrintWriter out;
	String messaggio;
	
	private class ClientThread extends Thread {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			String messaggio;
			try {
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				while (true) {
					messaggio = in.readLine();
					if (messaggio == null || messaggio.equals("FINE")) {
						System.out.println("Addio! :'(");
						System.exit(0);
					} else {
						System.out.println(messaggio);
					}
				}
			} catch (IOException e) {				
				e.printStackTrace();
			}			
		}
	}
	
	public Socket connetti() {
		try {
			tastiera = new BufferedReader(new InputStreamReader(System.in));
			socket = new Socket(nomeServer, portaServer);
			out = new PrintWriter(socket.getOutputStream(), true);
					
			// Attivo un socket per la ricezione
			ClientThread ct = new ClientThread();
			ct.start();
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return socket;
	}
	
	public void comunica() {
		System.out.println("Benvenuto in chat 0.1234! Tu sei " + socket.getLocalPort());
		for (;;) {
			try {
				messaggio = tastiera.readLine();
				// la spedisco al server				
				out.println(messaggio);				
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
	}
	
	public static void main(String[] args) {
		Client cliente = new Client();
		cliente.connetti();
		cliente.comunica();
	}
}
