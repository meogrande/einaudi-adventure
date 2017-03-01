package it.fabiobiscaro.socket.missitalia;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;

public class Client {

	protected Shell shlVotami;
	List list;
	private Button btnVota;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Client window = new Client();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlVotami.open();
		shlVotami.layout();
		while (!shlVotami.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlVotami = new Shell();
		shlVotami.setSize(450, 300);
		shlVotami.setText("Votami");

		Button btnCarica = new Button(shlVotami, SWT.NONE);
		btnCarica.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					// creo il socket
					Socket s = new Socket("localhost", 9999);
					// Creo gli oggetti per leggere e scrivere nel socket
					PrintWriter out = new PrintWriter(s.getOutputStream(), true); // Scrive
					InputStreamReader isr = new InputStreamReader(s.getInputStream());
					BufferedReader in = new BufferedReader(isr); // Legge

					// Invio il comando lista
					out.println("LISTA");
					// Aggiorno la lista locale caricando dal serve l'elenco dei
					// nomi
					list.removeAll();
					String nome;
					do {
						nome = in.readLine();
						if (!nome.equalsIgnoreCase("FINE")) {
							list.add(nome);
						}
					} while (!nome.equalsIgnoreCase("FINE"));

					// Abilito il pulsante vota
					btnVota.setEnabled(true);
					// Disabilito il pulsante lista
					btnCarica.setEnabled(false);

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnCarica.setBounds(30, 39, 75, 25);
		btnCarica.setText("Carica");

		list = new List(shlVotami, SWT.BORDER);
		list.setBounds(177, 39, 137, 213);

		btnVota = new Button(shlVotami, SWT.NONE);
		btnVota.setEnabled(false);
		btnVota.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// Invio il voto solo se ho selezionato un nome
				if (list.getSelectionIndex() >= 0) {
					try {
						// Creo un socket
						Socket s = new Socket("localhost", 9999);
						// Creo gli oggetti per leggere e scrivere nel socket
						PrintWriter out = new PrintWriter(s.getOutputStream(), true);
						InputStreamReader isr = new InputStreamReader(s.getInputStream());
						BufferedReader in = new BufferedReader(isr);

						// Invio il comando VOTA seguito dal nome
						out.println("VOTA");
						String nome = list.getItem(list.getSelectionIndex());
						out.println(nome);

						// Chiudo il socket
						s.close();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnVota.setBounds(30, 117, 75, 25);
		btnVota.setText("Vota");

	}
}
