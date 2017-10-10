package it.fabiobiscaro.thread;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Conteggio {

	protected Shell shell;
	private Text text;
	private Label label;

	private class Ciclo extends Thread {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			
			int i = 0;
			while(true) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				aggiorna(String.valueOf(i));
				i++;
			}
		}
	}
	
	
	private void aggiorna(String testo) {
		Display.getDefault().asyncExec(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				label.setText(testo);
			}
		});
	}
	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Conteggio window = new Conteggio();
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
		
		Button btnInizia = new Button(shell, SWT.NONE);
		btnInizia.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Ciclo c = new Ciclo();
				c.start();
			}
		});
		btnInizia.setBounds(35, 55, 75, 25);
		btnInizia.setText("Inizia");
		
		label = new Label(shell, SWT.NONE);
		label.setBounds(35, 118, 55, 15);
		label.setText("0");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(232, 72, 76, 21);
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(232, 44, 55, 15);
		lblNewLabel.setText("New Label");

	}

}
