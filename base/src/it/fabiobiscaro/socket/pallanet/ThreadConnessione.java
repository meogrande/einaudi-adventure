package it.fabiobiscaro.socket.pallanet;

import java.net.ServerSocket;

import javax.swing.JOptionPane;

public class ThreadConnessione implements Runnable {
	private PallaNetServer finestra;
	private Thread me;
	public ThreadConnessione(PallaNetServer finestra) {
		this.finestra = finestra;
		me = new Thread(this);
		me.start();
	}
	public void run() {
		try{
			ServerSocket server = new ServerSocket(6789);
			finestra.setConnessione(server.accept());
			server.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,  e.toString());
			System.exit(-1);
		}
	};
}
