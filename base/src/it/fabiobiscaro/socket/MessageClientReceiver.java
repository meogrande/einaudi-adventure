package it.fabiobiscaro.socket;

import java.io.BufferedReader;
import java.io.IOException;

public class MessageClientReceiver extends Thread {

	BufferedReader in;
	MessageClient mc;

	public MessageClientReceiver(BufferedReader in, MessageClient mc) {
		super();
		// TODO Auto-generated constructor stub
		this.in = in;
		this.mc = mc;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();

		// Ascolto i messaggi in arrivo
		try {
			while (true) {
				System.out.println(Thread.currentThread().getId() + " in attesa di messaggi dal server");
				String line = in.readLine();
				// Scrivo nella grafica la linea
				mc.addLine(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// Se il server cade esce
		}
	}

}
