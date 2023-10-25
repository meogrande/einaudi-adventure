package it.fabiobiscaro.file.testo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class ProvaScroll {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProvaScroll window = new ProvaScroll();
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
	public ProvaScroll() {
		initialize();
		
		System.out.println(ProvaScroll.class.getResource("/").toString());
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setRows(8);
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(0, 0, 436, 150);
		frame.getContentPane().add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(ProvaScroll.class.getResource("/it/fabiobiscaro/base/nerd-girl.jpg")));
		lblNewLabel.setBounds(0, 0, 45, 13);
		frame.getContentPane().add(lblNewLabel);
		scrollPane.setVisible(true);
		
		//frame.getContentPane().add(textArea, BorderLayout.SOUTH);
	}
}
