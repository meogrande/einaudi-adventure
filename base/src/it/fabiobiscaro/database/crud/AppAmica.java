package it.fabiobiscaro.database.crud;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.List;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JList;

import org.eclipse.swt.SWT;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Label;

public class AppAmica {

	protected Shell shlDatabaseI;
	private List list;
	private ArrayList<Amico> risultati = new ArrayList<Amico>();
	private Button btnModifica;
	private Button btnCancella;
	private Button btnNuovo;
	private Text textNome;
	private Text textCognome;
	private DateTime dataNascita;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			AppAmica window = new AppAmica();
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
		shlDatabaseI.open();
		shlDatabaseI.layout();
		while (!shlDatabaseI.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	private void svuotaCaselle() {
		textNome.setText("");
		textCognome.setText("");
	}

	private void popolaCaselleDaLista() {
		// Imposto i valori delle caselle
		if (list.getSelectionIndex() >= 0) {
			Amico a = risultati.get(list.getSelectionIndex());
			textNome.setText(a.getNome());
			textCognome.setText(a.getCognome());
			Calendar data = Calendar.getInstance();
			data.setTime(a.getData());			
			dataNascita.setYear(data.get(Calendar.YEAR));
			dataNascita.setMonth(data.get(Calendar.MONTH));
			dataNascita.setDay(data.get(Calendar.DAY_OF_MONTH));
		}
	}

	private void caricaLista() {
		risultati = Database.elencoAmici();
		list.removeAll(); // Ripulisco la lista
		for (int i = 0; i < risultati.size(); i++) {
			list.add(risultati.get(i).getNome() + " " + risultati.get(i).getCognome());
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlDatabaseI = new Shell();
		shlDatabaseI.setSize(450, 337);
		shlDatabaseI.setText("Database I");

		list = new List(shlDatabaseI, SWT.BORDER | SWT.V_SCROLL);
		list.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// Quando seleziono un elemento popolo le caselle a destra con i
				// valori dell'amico
				popolaCaselleDaLista();
			}
		});
		list.setBounds(29, 41, 151, 236);

		Button btnCarica = new Button(shlDatabaseI, SWT.NONE);
		btnCarica.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				caricaLista();
			}
		});
		btnCarica.setBounds(237, 40, 75, 25);
		btnCarica.setText("Carica");

		btnModifica = new Button(shlDatabaseI, SWT.NONE);
		btnModifica.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int elementoSelezionato = list.getSelectionIndex();
				if (elementoSelezionato >= 0) {
					// Creo un oggetto amico
					String nome = textNome.getText();
					String cognome = textCognome.getText();
					java.text.DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
					Date dataN = null;
					try {
						dataN = df.parse(dataNascita.getYear() + "-" + dataNascita.getMonth() + "-" + dataNascita.getDay());
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					int id = risultati.get(elementoSelezionato).getId();
					Amico a = new Amico(id, nome, cognome, dataN);
					// Salvo l'amico modificato nel database
					Database.modificaAmico(a);
					// ricarico la lista
					caricaLista();
				}
			}
		});
		btnModifica.setBounds(237, 252, 75, 25);
		btnModifica.setText("Modifica");

		btnCancella = new Button(shlDatabaseI, SWT.NONE);
		btnCancella.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int elementoSelezionato = list.getSelectionIndex();
				if (elementoSelezionato >= 0) {
					// Elimino l'amico dal db
					Database.eliminaAmico(risultati.get(elementoSelezionato));

					// Ricarico la lista così aggiorno i miei risultati
					caricaLista();
				}
			}
		});
		btnCancella.setBounds(333, 40, 75, 25);
		btnCancella.setText("Cancella");

		btnNuovo = new Button(shlDatabaseI, SWT.NONE);
		btnNuovo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// Prendo i valori dai campi
				String nome = textNome.getText();
				String cognome = textCognome.getText();
				java.text.DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				Date dataN = null;
				try {
					dataN = df.parse(dataNascita.getYear() + "-" + dataNascita.getMonth() + "-" + dataNascita.getDay());
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Amico a = new Amico(0, nome, cognome, dataN);
				Database.nuovoAmico(a);

				// Svuoto le caselle di input
				svuotaCaselle();

				// Poi ricarico dal db per aggiornare l'elenco
				caricaLista();
			}
		});
		btnNuovo.setBounds(333, 252, 75, 25);
		btnNuovo.setText("Nuovo");

		textNome = new Text(shlDatabaseI, SWT.BORDER);
		textNome.setBounds(332, 106, 92, 21);

		textCognome = new Text(shlDatabaseI, SWT.BORDER);
		textCognome.setBounds(332, 154, 92, 21);

		dataNascita = new DateTime(shlDatabaseI, SWT.BORDER);
		dataNascita.setBounds(333, 199, 91, 24);

		Label lblNewLabel = new Label(shlDatabaseI, SWT.NONE);
		lblNewLabel.setBounds(237, 112, 55, 15);
		lblNewLabel.setText("Nome");

		Label lblNewLabel_1 = new Label(shlDatabaseI, SWT.NONE);
		lblNewLabel_1.setBounds(237, 160, 55, 15);
		lblNewLabel_1.setText("Cognome");

		Label lblNewLabel_2 = new Label(shlDatabaseI, SWT.NONE);
		lblNewLabel_2.setBounds(237, 209, 75, 15);
		lblNewLabel_2.setText("Data Nascita");

	}
}
