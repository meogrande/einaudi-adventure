package it.fabiobiscaro.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProvaSwing {

	private JFrame frame;
	private JTextField txtCiao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProvaSwing window = new ProvaSwing();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ProvaSwing() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblProva = new JLabel("Prova");
		lblProva.setBackground(Color.YELLOW);
		lblProva.setOpaque(true);
		frame.getContentPane().add(lblProva, BorderLayout.NORTH);
		
		txtCiao = new JTextField();
		txtCiao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("ciao");
			}
		});
		txtCiao.setText("ciao");
		frame.getContentPane().add(txtCiao, BorderLayout.WEST);
		txtCiao.setColumns(10);
	}

}
