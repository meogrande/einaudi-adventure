package it.fabiobiscaro.lista;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Control;

public class Pannello {

	protected Shell shell;
	private Text txtNome;
	private Text txtCognome;
	private Text txtAnnoNascita;
	private ListaPersone lista;
	List list;
	private Button btnNumeroElementi;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Pannello window = new Pannello();
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
		shell.setSize(619, 300);
		shell.setText("SWT Application");
		
		lista = new ListaPersone();
		
		Button btnAggiungi = new Button(shell, SWT.NONE);
		btnAggiungi.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				try {
					String nome = txtNome.getText();
					String cognome = txtCognome.getText();
					int anno = 0;
					anno = Integer.valueOf(txtAnnoNascita.getText());
					
					Persona p = new Persona(nome, cognome, anno);
					
					// Aggiungo alla lista e alla schermata grafica
					lista.add(p);
					list.add(p.toString());
					
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnAggiungi.setBounds(56, 197, 75, 25);
		btnAggiungi.setText("Aggiungi");
		
		txtNome = new Text(shell, SWT.BORDER);
		txtNome.setBounds(114, 28, 76, 21);
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(10, 31, 55, 15);
		lblNewLabel.setText("Nome");
		
		Label lblCognome = new Label(shell, SWT.NONE);
		lblCognome.setText("Cognome");
		lblCognome.setBounds(10, 72, 55, 15);
		
		Label lblAnno = new Label(shell, SWT.NONE);
		lblAnno.setText("Anno di nascita");
		lblAnno.setBounds(10, 113, 98, 15);
		
		txtCognome = new Text(shell, SWT.BORDER);
		txtCognome.setBounds(114, 69, 76, 21);
		
		txtAnnoNascita = new Text(shell, SWT.BORDER);
		txtAnnoNascita.setBounds(114, 110, 76, 21);
		
		list = new List(shell, SWT.BORDER);
		list.setBounds(217, 25, 376, 197);
		
		btnNumeroElementi = new Button(shell, SWT.NONE);
		btnNumeroElementi.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println(lista.size());
			}
		});
		btnNumeroElementi.setBounds(265, 228, 115, 25);
		btnNumeroElementi.setText("Numero Elementi");
		shell.setTabList(new Control[]{txtNome, txtCognome, txtAnnoNascita, list, btnAggiungi});

	}
}
