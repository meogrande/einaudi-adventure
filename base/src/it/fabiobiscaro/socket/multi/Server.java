package it.fabiobiscaro.socket.multi;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public void start() {
		try {
			ServerSocket serverSocket = new ServerSocket(6789);
			for (;;) { // Altro modo di fare un ciclo infinito
				System.out.println("-> Server in attesa...");
				Socket socket = serverSocket.accept();
				
				System.out.println("-> Creo un nuovo thread assegnando il socket: " + socket);
				ServerThread serverThread = new ServerThread(socket);
				serverThread.start();
				
				// Aggiungo il socket alla lista dei socket
				ServerModel.listaSocket.add(socket);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	public static void main(String[] args) {
		Server tcpServer = new Server();
		tcpServer.start();
	}
}
