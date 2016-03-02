package it.fabiobiscaro.imagescroll;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.wb.swt.SWTResourceManager;

public class Prova {

	protected Shell shell;
	Display display;
	Canvas canvas;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Prova window = new Prova();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		display = Display.getDefault();
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

		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Image image = new Image(display, getClass().getResourceAsStream("/it/fabiobiscaro/imagescroll/img/cassa.gif"));

				GC gc = new GC(canvas);
				gc.drawImage(image, 0, 0);

				/*
				 * canvas.addPaintListener(new PaintListener() { public void
				 * paintControl(PaintEvent e) { e.gc.drawImage(image, 0, 0); }
				 * });
				 * 
				 * canvas.redraw();
				 */

				for (int i = 0; i < 50; i++) {
					System.out.println(i);
					gc.drawImage(image, 0, -20 + i * 1);
					try {
						Thread.sleep(60); // 1000 milliseconds is one second.
					} catch (InterruptedException ex) {
						Thread.currentThread().interrupt();
					}

				}
			}
		});
		btnNewButton.setBounds(350, 31, 75, 25);
		btnNewButton.setText("New Button");

		canvas = new Canvas(shell, SWT.NONE);
		canvas.setBounds(10, 10, 296, 241);

		Button btnAsync = new Button(shell, SWT.NONE);
		btnAsync.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				display.asyncExec(new Runnable() {
					Image image = new Image(display, getClass().getResourceAsStream("/it/fabiobiscaro/imagescroll/img/cassa.gif"));

					GC gc = new GC(canvas);

					public void run() {
						for (int i = 0; i < 50; i++) {
							System.out.println(i);
							gc.drawImage(image, 0, -20 + i * 1);
							try {
								System.out.println("Thread " + i + " " + Thread.activeCount());
								Thread.sleep(60); // 1000 milliseconds is one
													// second.
							} catch (InterruptedException ex) {
								Thread.currentThread().interrupt();
							}
						}
					}});
				System.out.println("Thread: "  + Thread.activeCount());
				/*new Runnable() {
					public void run() {
						for (int i = 0; i < 50; i++) {
							try {
								System.out.println("Thread " + i + " " + Thread.activeCount());
								Thread.sleep(60); // 1000 milliseconds is one
													// second.
							} catch (InterruptedException ex) {
								Thread.currentThread().interrupt();
							}
						
				}}}.run();*/
				/*
				new Runnable() {
					Image image = new Image(display, getClass().getResourceAsStream("img/cassa.gif"));

					GC gc = new GC(canvas);

					public void run() {
						for (int i = 0; i < 50; i++) {
							System.out.println(i);
							gc.drawImage(image, 0, -20 + i * 1);
							
						}
					}*/
				
			}
		});
		btnAsync.setBounds(350, 85, 75, 25);
		btnAsync.setText("Async");
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setImage(SWTResourceManager.getImage(Prova.class, "/it/fabiobiscaro/imagescroll/img/cassa.gif"));
		lblNewLabel.setBounds(333, 156, 92, 95);
		lblNewLabel.setText("New Label");

	}
}
