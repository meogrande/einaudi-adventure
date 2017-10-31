package it.fabiobiscaro.thread.ciclisti;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class Ciclista extends JPanel {
	int coordx;
	int coordy;
	Image img;

	public Ciclista(int yy, int xx) {
		coordx = 0;
		coordy = yy;
		setSize(80, 81);
		Toolkit tk = Toolkit.getDefaultToolkit();

		switch (xx) {
		case 1: {
			img = tk.getImage("C:/APP/workspace/Threads/src/cane1.jpg");
			break;
		}
		case 2: {
			img = tk.getImage("C:/APP/workspace/Threads/src/cane2.jpg");
			break;
		}
		case 3: {
			img = tk.getImage("C:/APP/workspace/Threads/src/cane3.jpg");
			break;
		}
		case 4: {
			img = tk.getImage("C:/APP/workspace/Threads/src/cane4.jpg");
			break;
		}
		case 5: {
			img = tk.getImage("C:/APP/workspace/Threads/src/cane5.jpg");
			break;
		}
		case 6: {
			img = tk.getImage("C:/APP/workspace/Threads/src/cane6.jpg");
			break;
		}
		}
		MediaTracker mt = new MediaTracker(this);
		mt.addImage(img, 1);
		try {
			mt.waitForID(1);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void setCoordx(int n) {
		coordx = n;
	}
	
	public int getCoordx() {
		return coordx;
	}
	
	
	public void paint(Graphics g) {
		g.drawImage(img,  coordx,  coordy, null);
	}
}
