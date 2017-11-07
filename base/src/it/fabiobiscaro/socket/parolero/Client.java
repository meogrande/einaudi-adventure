package it.fabiobiscaro.socket.parolero;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class Client {

	private JFrame frame;
	private JTextField textIndovina;

	private String parola;
	private Socket socket;
	JLabel lblIndovina;
	ClientThread ct;

	class ClientThread extends Thread {
		@Override
		public void run() {
			// Connetto il socket e mi metto in ascolto
			super.run();
			try {
				socket = new Socket("localhost", 9999);
				Scanner in = new Scanner(socket.getInputStream());
				while (true) {
					// Ad ogni parola che arriva la metto nella casella di testo
					parola = in.nextLine();
					lblIndovina.setText(parola);
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Client window = new Client();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Client() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblParola = new JLabel("Parola da scrivere:");
		lblParola.setBounds(10, 44, 135, 14);
		frame.getContentPane().add(lblParola);

		lblIndovina = new JLabel("...");
		lblIndovina.setBounds(155, 44, 46, 14);
		frame.getContentPane().add(lblIndovina);

		textIndovina = new JTextField();
		textIndovina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Quando si preme invio invia al server quello che c'è nella
				// casella di testo
				if (socket != null) {
					PrintWriter out;
					try {
						out = new PrintWriter(socket.getOutputStream(), true);
						out.println(textIndovina.getText());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		textIndovina.setBounds(155, 93, 86, 20);
		frame.getContentPane().add(textIndovina);
		textIndovina.setColumns(10);

		JButton btnConnetti = new JButton("Connetti!");
		btnConnetti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Il tasto connetti si connette al server
				// Si connette se non è già connesso
				if (ct == null) {
					ct = new ClientThread();
					ct.start();
				}
			}
		});
		btnConnetti.setBounds(10, 11, 89, 23);
		frame.getContentPane().add(btnConnetti);
		
		JLabel lblIstruzioniAvviaIl = new JLabel("Avvia il server e due client. Quando 2 client sono connessi inizia il programma.");
		lblIstruzioniAvviaIl.setHorizontalAlignment(SwingConstants.LEFT);
		lblIstruzioniAvviaIl.setBounds(10, 149, 414, 36);
		frame.getContentPane().add(lblIstruzioniAvviaIl);
		
		JLabel lblScrivilaQui = new JLabel("Scrivila qui e premi invio:");
		lblScrivilaQui.setBounds(10, 96, 135, 14);
		frame.getContentPane().add(lblScrivilaQui);
	}
}
