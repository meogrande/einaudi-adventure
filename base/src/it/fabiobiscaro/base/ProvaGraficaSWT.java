package it.fabiobiscaro.base;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import java.awt.Color;

import javax.swing.JLabel;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.wb.swt.SWTResourceManager;

public class ProvaGraficaSWT {

	protected Shell shell;
	private Text text;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ProvaGraficaSWT window = new ProvaGraficaSWT();
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
		shell.setSize(541, 310);
		shell.setText("SWT Application");
		
		text = new Text(shell, SWT.BORDER);
		text.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (text.getText().length()>5) {
					// togli l'ultimo carattere...
					text.setText(text.getText().substring(0, 5));
					
				}
			}
		});
		text.setBounds(10, 12, 219, 21);
		Browser browser = new Browser(shell, SWT.NONE);
		browser.setBounds(10, 39, 505, 222);
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println("premuto il tasto");
				
				browser.setUrl(text.getText());
				
				
				
			}
		});
		btnNewButton.setBounds(235, 10, 75, 25);
		btnNewButton.setText("Premi qui");
		
		JLabel lblNewLabel = new JLabel("ciao");
		lblNewLabel.setBackground(Color.blue);
		lblNewLabel.setForeground(Color.red);
		lblNewLabel.setBounds(331, 12, 55, 15);
		lblNewLabel.setText("New Label");
		
		

	}
}
