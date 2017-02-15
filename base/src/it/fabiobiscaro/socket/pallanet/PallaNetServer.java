package it.fabiobiscaro.socket.pallanet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PallaNetServer extends JFrame {
	private Socket connessione = null;
	private DataOutputStream out = null;
	private DataInputStream in = null;

	public PallaNetServer() {
		super("PallaNet - Server");
		this.setSize(500, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		ThreadConnessione attendiConnessione = new ThreadConnessione(this);
		this.setVisible(true);
	}

	public void setConnessione(Socket connessione) {
		this.connessione = connessione;

		try {
			out = new DataOutputStream(connessione.getOutputStream());
			in = new DataInputStream(connessione.getInputStream());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.toString());
			System.exit(-1);
		}
		
		PannelloAnimazione pan = new PannelloAnimazione(this, this.getSize());
		this.addWindowListener(pan);
	}
	
	public DataInputStream getInput() {
		return in;
	}
	
	public DataOutputStream getOutput() {
		return out;
	}

}
