package it.fabiobiscaro.socket.awt;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;

public class Interfaccia {

	protected Shell shlLindovino;
	private Text text;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Interfaccia window = new Interfaccia();
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
		shlLindovino.open();
		shlLindovino.layout();
		while (!shlLindovino.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlLindovino = new Shell();
		shlLindovino.setSize(302, 193);
		shlLindovino.setText("L'indovino");
		
		Label lblIndovinaIlNumeo = new Label(shlLindovino, SWT.NONE);
		lblIndovinaIlNumeo.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.NORMAL));
		lblIndovinaIlNumeo.setBounds(10, 10, 239, 35);
		lblIndovinaIlNumeo.setText("Indovina il numero!");
		
		text = new Text(shlLindovino, SWT.BORDER);
		text.setText("12");
		text.setBounds(10, 70, 158, 21);
		
		Label lblNewLabel = new Label(shlLindovino, SWT.NONE);
		lblNewLabel.setBounds(153, 129, 97, 15);
		lblNewLabel.setText("Numero pi\u00F9 basso");
		
		Button btnIndovina = new Button(shlLindovino, SWT.NONE);
		btnIndovina.setBounds(174, 68, 75, 25);
		btnIndovina.setText("Indovina");

	}
}
