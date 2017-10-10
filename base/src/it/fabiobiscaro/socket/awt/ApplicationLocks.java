package it.fabiobiscaro.socket.awt;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Text;

public class ApplicationLocks {

	protected Shell shell;
	private Text text;
	Label lblProva;

	private class Ciclo extends Thread {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			int a=0;
			while (true) {					
				try {
					Thread.sleep(100);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				setText(String.valueOf(a++));
			}
		}
	}
	
	private void setText(String s) {
		Display.getDefault().asyncExec(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				lblProva.setText(s);
			}
		});
	}
	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ApplicationLocks window = new ApplicationLocks();
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
		
		lblProva = new Label(shell, SWT.NONE);
		lblProva.setBounds(46, 181, 55, 15);
		lblProva.setText("prova");
		
		Button btnClick = new Button(shell, SWT.NONE);
		btnClick.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Ciclo ciclo = new Ciclo();
				ciclo.start();
			}
		});
		btnClick.setBounds(26, 90, 75, 25);
		btnClick.setText("click");
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.setBounds(129, 53, 75, 25);
		btnNewButton.setText("New Button");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(254, 90, 76, 21);
	}
}
