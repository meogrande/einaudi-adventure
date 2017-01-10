package it.fabiobiscaro.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class StringMultiClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		// Invia dati al server
		Socket s = new Socket("localhost", 9999);
		
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			
		}
		
		PrintWriter out = new PrintWriter(s.getOutputStream(), true);
		out.println("ciao " + Math.random());

		// riceva del testo
		InputStreamReader isr = new InputStreamReader(s.getInputStream());
		BufferedReader in = new BufferedReader(isr);
		System.out.println("Il client riceve " + System.currentTimeMillis() + ": " + in.readLine());
		
		s.close();

	}

}
