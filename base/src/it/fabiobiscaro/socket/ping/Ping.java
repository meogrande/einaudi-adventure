package it.fabiobiscaro.socket.ping;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.*;

public class Ping {
	private static Socket s = null;
	private static BufferedWriter os = null;
	private static BufferedReader is = null;

	public static void main(String argv[]) {
		char str[] = new char[10];
		try {
			s = new Socket("localhost", 7);

			is = new BufferedReader(new InputStreamReader(s.getInputStream()));
			os = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
			os.write("Hello1", 0, 6);
			os.flush();
			is.read(str, 0, 6);
			System.out.println(argv[0] + " IP = " + s.getInetAddress());
			System.out.println("Received: " + str);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}