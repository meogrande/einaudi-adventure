package it.fabiobiscaro.socket.multi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerThread extends Thread {
	Socket client = null;
	String stringaModificata = null;
	String messaggio = null;
	BufferedReader input;
	PrintWriter output;

	public ServerThread(Socket socket) {
		this.client = socket;
	}

	public void run() {
		try {
			input = new BufferedReader(new InputStreamReader(client.getInputStream()));
			
			while(true) {
				messaggio = input.readLine(); // riceve il messaggio
				ServerModel.sendMessage(messaggio, client); // lo ritrasmette 
				
				if (messaggio == null || messaggio.equals("FINE")) {
					System.out.println(Thread.currentThread().getId() + " Addio! " + messaggio);
					ServerModel.close();
					System.exit(0);
				} 
			}		
			
		} catch (Exception e) {
			// esce e basta
		}
	}
}
