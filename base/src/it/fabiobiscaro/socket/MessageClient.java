package it.fabiobiscaro.socket;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;

import java.awt.Event;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class MessageClient {

	protected Shell shell;
	private Text text;
	private Text messaggi;
	MessageClientReceiver mcr;
	
	Socket s;
	PrintWriter out;
	BufferedReader in;
	MessageClient mc;
	
	private Button btnNewButton_1;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MessageClient window = new MessageClient();
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
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	public void addLine(String line) {
		Display.getDefault().asyncExec(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				messaggi.append(line+"\n");
			}
		});
	}
	
	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		// Salvo il riferimento di questo oggetto in mc
		mc = this;
		
		shell = new Shell();
		shell.setSize(373, 270);
		shell.setText("SWT Application");
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// Connessione al socket e imposto reader e writer
				try {
					System.out.println(Thread.currentThread().getId() + " connessione al server");
					s = new Socket("localhost", 9999);
					out = new PrintWriter(s.getOutputStream(), true);
					in = new BufferedReader(new InputStreamReader(s.getInputStream())); 
					// Attivo il ricevitore
					mcr = new MessageClientReceiver(in, mc);
					mcr.start();	
					// Disabilito il pulsante connessione
					btnNewButton.setEnabled(false);
				} catch (UnknownHostException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(274, 10, 75, 25);
		btnNewButton.setText("Connettiti");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(10, 197, 258, 21);
		
		messaggi = new Text(shell, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL | SWT.MULTI);
		messaggi.setBounds(10, 56, 339, 126);
		
		btnNewButton_1 = new Button(shell, SWT.NONE);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// Invio qualcosa al server
				System.out.println(Thread.currentThread().getId() + " invio al server: " + text.getText());
				out.println(text.getText());
			}
		});
		btnNewButton_1.setBounds(274, 195, 75, 25);
		btnNewButton_1.setText("Invia");
		
		// Quando chiudo tiro giù anche il thread
		shell.addListener(SWT.Close, new Listener() {			
			@Override
			public void handleEvent(org.eclipse.swt.widgets.Event arg0) {
				// TODO Auto-generated method stub	
				mcr.interrupt();
			}
		});

	}
}
