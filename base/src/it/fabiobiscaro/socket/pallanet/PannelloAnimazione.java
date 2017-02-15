package it.fabiobiscaro.socket.pallanet;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JPanel;
import javax.swing.Timer;



public class PannelloAnimazione extends JPanel implements WindowListener, ActionListener {
	private PallaNetServer finestra;
	private Dimension dimensioni;
	private Image bufferVirtuale;
	private Graphics offScreen;
	private Timer tim = null;
	private int xPallina = 0;
	private int yPallina = 0;
	private int diametroPallina = 40;
	private int spostamento = 3;
	private int timerDelay = 10;
	private boolean destra, basso, pallinaPresente, arrivoComunicato;
	
	
	public PannelloAnimazione(PallaNetServer finestra, Dimension dimensione) {
		super();
		this.finestra = finestra;
		this.setSize(dimensioni);
		destra = true;
		basso = true;
		pallinaPresente = true;
		arrivoComunicato = false;
		tim = new Timer(timerDelay, this);
		tim.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (pallinaPresente) {
			if (basso) {
				
			}
		}
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}
