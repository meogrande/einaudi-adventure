package it.fabiobiscaro.base;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class Prova2NerdGirl extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prova2NerdGirl frame = new Prova2NerdGirl();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Prova2NerdGirl() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		NerdGirl lblNewLabel = new NerdGirl();
		lblNewLabel.setBounds(56, 38, 131, 185);
		contentPane.add(lblNewLabel);
		lblNewLabel.changeCard();
		lblNewLabel.changeCard();
		
		NerdGirl lblNewLabel_1 = new NerdGirl();
		lblNewLabel_1.setBounds(217, 37, 172, 173);
		contentPane.add(lblNewLabel_1);
	}

}
