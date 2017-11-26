package it.fabiobiscaro.datagram;

import java.io.*;
import java.net.*;

public class ClientObject {

	public void sendTo(Object o, String hostName, int desPort) {
		try {
			InetAddress address = InetAddress.getByName(hostName);
			DatagramSocket dSock = new DatagramSocket();
			ByteArrayOutputStream byteStream = new ByteArrayOutputStream(5000);
			ObjectOutputStream os = new ObjectOutputStream(new BufferedOutputStream(byteStream));
			os.flush();
			os.writeObject(o);
			os.flush();
			// retrieves byte array
			byte[] sendBuf = byteStream.toByteArray();
			DatagramPacket packet = new DatagramPacket(sendBuf, sendBuf.length, address, desPort);
			int byteCount = packet.getLength();
			dSock.send(packet);
			os.close();
		} catch (UnknownHostException e) {
			System.err.println("Exception:  " + e);
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ClientObject cb = new ClientObject();
		//cb.sendTo(new String("ciao"), "localhost", 9999);
		Prova p = new Prova(1,3);
		cb.sendTo(p, "localhost", 9999);
	}
	
}
