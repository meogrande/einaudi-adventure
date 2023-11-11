package it.fabiobiscaro.a2023.grafica;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
/**
 * @author meogr
 */
public class Base {	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame jf = new JFrame("Prova");
		jf.setBounds(0, 0, 200, 200);
		
		JPanel jp = new JPanel(new BorderLayout());
		jf.add(jp);
		JLabel jl = new JLabel("prova") ;
		jp.add(jl);
		
		
		JButton jb = new JButton("Premi qui");
		jb.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("ciao");
				jl.setText("premuto");
			}
		});
		jp.add(jb, BorderLayout.SOUTH);
		
		jf.setVisible(true);

	}

}
