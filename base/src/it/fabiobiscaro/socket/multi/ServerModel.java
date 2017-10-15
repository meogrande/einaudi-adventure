package it.fabiobiscaro.socket.multi;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ServerModel {
	public static ArrayList<Socket> listaSocket = new ArrayList<Socket>();

	/**
	 * Invio un messaggio a tutti
	 * 
	 * @param message
	 *            // Il messaggio da inviare
	 * @param sender
	 *            // Chi invia il messaggio
	 */
	public static void sendMessage(String message, Socket sender) {
		for (int i = 0; i < listaSocket.size(); i++) {
			try {
				Socket temp = listaSocket.get(i);
				if (sender != temp) {
					PrintWriter out = new PrintWriter(temp.getOutputStream(), true);
					out.println(sender.getPort() + " dice: " + message);
				}
			} catch (IOException e) {
				// Nel caso ci sia qualche problema salta quel socket
				e.printStackTrace();
			}
		}
	}

	/**
	 * Chiudo tutti i socket
	 */
	public static void close() {
		for (int i = 0; i < listaSocket.size(); i++) {
			try {
				listaSocket.get(i).close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
