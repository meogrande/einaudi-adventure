package it.fabiobiscaro.socket.tombola;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;

import java.io.IOException;
import java.net.Socket;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Client {

	Socket s;

	protected Shell shell;

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

		Button btnRecuperaNumeri = new Button(shell, SWT.NONE);
		btnRecuperaNumeri.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// Apre il socket
				try {
					Socket s = new Socket("localhost", 9999);
					for (int i = 0; i < 15; i++) {
						System.out.print(s.getInputStream().read() + " ");
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				// Riceve i 15 numeri
				// Apre il thread di comunicazione che riceverà i comandi
				// successivi
			}
		});
		btnRecuperaNumeri.setBounds(224, 85, 121, 25);
		btnRecuperaNumeri.setText("Recupera Numeri");

	}
}
