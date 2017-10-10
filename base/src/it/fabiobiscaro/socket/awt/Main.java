package it.fabiobiscaro.socket.awt;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.BorderLayout;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame jframe = new JFrame("Riceve un numero");
		jframe.setBounds(100, 100, 1000, 600);
		jframe.setVisible(true);
		JButton jbutton = new JButton("premi");
		jbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		jbutton.setBounds(20,20,200,50);
		jframe.getContentPane().add(jbutton);
		
		JLabel lblCount = new JLabel("0 numeri ricevuti");
		jframe.getContentPane().add(lblCount, BorderLayout.SOUTH);
		
		try {
			ServerSocket ss = new ServerSocket(9080);
			while (true) {
				Socket s = ss.accept();
				int i = s.getInputStream().read();
				lblCount.setText(Integer.toString(i));
				System.out.println(s.getRemoteSocketAddress().toString());
				s.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
