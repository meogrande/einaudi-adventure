package it.fabiobiscaro.socket;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class FabioClient {
	public static void main(String[] args) {
		// Mi connetto al server
		try {
			Socket s = new Socket("localhost", 9080);
			s.getOutputStream().write((int)(Math.random()*10));
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
