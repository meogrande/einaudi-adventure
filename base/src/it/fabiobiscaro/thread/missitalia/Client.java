package it.fabiobiscaro.thread.missitalia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Client {

	protected Shell shell;
	List list;
	private Button btnVota;
		/**
	 * Launch the application.
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
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		Button btnCarica = new Button(shell, SWT.NONE);
		btnCarica.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					Socket s = new Socket("localhost",9999);
					PrintWriter out = new PrintWriter(s.getOutputStream(), true);
					
					InputStreamReader isr = new InputStreamReader(s.getInputStream());
					BufferedReader in = new BufferedReader(isr);
					
					out.println("LISTA");
					String nome;
					list.removeAll();
					do {
						nome = in.readLine();
						if (!nome.equalsIgnoreCase("FINE")) {
							list.add(nome);
						}
					} while (!nome.equalsIgnoreCase("FINE"));
					
					btnVota.setEnabled(true);
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnCarica.setBounds(30, 39, 75, 25);
		btnCarica.setText("Carica");
		
		list = new List(shell, SWT.BORDER);
		list.setBounds(177, 39, 137, 213);
		
		btnVota = new Button(shell, SWT.NONE);
		btnVota.setEnabled(false);
		btnVota.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					Socket s = new Socket("localhost",9999);
					PrintWriter out = new PrintWriter(s.getOutputStream(), true);
					
					InputStreamReader isr = new InputStreamReader(s.getInputStream());
					BufferedReader in = new BufferedReader(isr);
					
					out.println("VOTA");
					String nome = list.getItem(list.getSelectionIndex());
					
					out.println(nome);
					
					s.close();
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnVota.setBounds(30, 117, 75, 25);
		btnVota.setText("Vota");

	}
}
