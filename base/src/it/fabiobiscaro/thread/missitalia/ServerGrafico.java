package it.fabiobiscaro.thread.missitalia;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;

public class ServerGrafico {

	protected Shell shlMissItalia;
	private Table table;
	private TableColumn tblclmnNome;
	private TableColumn tblclmnVoti;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ServerGrafico window = new ServerGrafico();
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
		shlMissItalia.open();
		shlMissItalia.layout();
		while (!shlMissItalia.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlMissItalia = new Shell();
		shlMissItalia.setSize(305, 234);
		shlMissItalia.setText("Miss Italia");
		
		table = new Table(shlMissItalia, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(34, 68, 221, 104);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		tblclmnNome = new TableColumn(table, SWT.NONE);
		tblclmnNome.setWidth(117);
		tblclmnNome.setText("Nome");
		
		tblclmnVoti = new TableColumn(table, SWT.NONE);
		tblclmnVoti.setWidth(100);
		tblclmnVoti.setText("Voti");
		
		Label lblNewLabel = new Label(shlMissItalia, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		lblNewLabel.setBounds(34, 24, 215, 27);
		lblNewLabel.setText("Lista Voti");
		
		// Faccio partire il thread grafico
		Thread t = new Thread(new ServerThread(this));
		t.start();

	}
	
	/**
	 * Aggiorna la tabella
	 */
	public void updateTable(ArrayList<String> lista, ArrayList<Integer> voti) {
		Display.getDefault().asyncExec(new Runnable() {			
			@Override
			public void run() {
				// Svuoto la tabella
				table.removeAll();
				// La ripopolo riga per riga
				for (int i=0; i<lista.size(); i++) {
					TableItem item = new TableItem(table, SWT.NULL);
				     // item.setText("Item " + 1); // A che serve questo? Un indice nascosto dell'item?
				     item.setText(0, lista.get(i));
				     item.setText(1, String.valueOf(voti.get(i)));
				}
				
			}
		});		
	}
}
