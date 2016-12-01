package it.fabiobiscaro.thread.ciclisti;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class GaraCiclistica extends JFrame {
	int posizione;
	Ciclista[] partecipanti;
	CiclistiInGara[] thread_partecipanti;
	Campo pista;
	Graphics offscreen;
	Image buffer_virtuale;
	
	public GaraCiclistica() {
		super("Gara Ciclistica");
		setSize(1000, 645);
		setLocation(10, 40);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pista = new Campo();
		partecipanti = new Ciclista[6];
		thread_partecipanti = new CiclistiInGara[6];
		posizione = 1;
		
		int partenza = 15;
		for (int xx=0; xx<6; xx++) {
			partecipanti[xx] = new Ciclista(partenza,  xx+1);
			thread_partecipanti[xx] = new CiclistiInGara(partecipanti[xx], this);
			partenza = partenza+100;			
		}
		// visualizza la gara
		this.add(pista);
		setVisible(true);
	}
	
	public synchronized int getPosizione() {
		return posizione++;
	}
	
	public synchronized void controllaArrivi() {
		boolean arrivati=true;
		for (int xx=0; xx<6; xx++) {
			if (thread_partecipanti[xx].posizione==0) {
				arrivati=false;
			}
		}
		if(arrivati) {
			visualizzaClassifica();
		}
	}
	
	public void visualizzaClassifica() {
		JLabel[] arrivi;
		arrivi = new JLabel[6];
		JFrame classifica = new JFrame("Classifica");
		classifica.setSize(500, 500);
		classifica.setLocation(280, 130);
		classifica.setBackground(Color.BLUE);
		classifica.setDefaultCloseOperation(EXIT_ON_CLOSE);
		classifica.getContentPane().setLayout(new GridLayout(6,1 ));
		
		for(int xx=1; xx<7; xx++) {
			for (int yy=0; yy<6; yy++) {
				if (thread_partecipanti[yy].posizione==xx){
					arrivi[yy]=new JLabel(xx+"' classificato cilcitica in " + (yy+1)+"' corsia");
					arrivi[yy].setFont(new Font("times New Roman", Font.ITALIC, 20));
					arrivi[yy].setForeground(Color.BLUE);
					classifica.getContentPane().add(arrivi[yy]);
				}
			}
		}
		classifica.setVisible(true);
		
	}
	
	public void update(Graphics g) {
		paint(g);
	}
	
	public void paint(Graphics g) {
		if (partecipanti != null) {
			Graphics2D screen = (Graphics2D) g;
			buffer_virtuale= createImage(1000, 645);
			offscreen = buffer_virtuale.getGraphics();
			Dimension d=getSize();
			pista.paint(offscreen);
			for (int xx=0; xx<6; xx++) {
				partecipanti[xx].paint(offscreen);
			}
			screen.drawImage(buffer_virtuale, 0, 30, this);
			offscreen.dispose();
		}
	}
	
	public static void main(String[] a) {
		GaraCiclistica m=new GaraCiclistica();
	}
}
