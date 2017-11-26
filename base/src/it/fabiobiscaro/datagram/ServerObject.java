package it.fabiobiscaro.datagram;

import java.io.*;
import java.net.*;

public class ServerObject {

	public Object recvObjFrom() {
		try {
			byte[] recvBuf = new byte[5000];
			DatagramPacket packet = new DatagramPacket(recvBuf, recvBuf.length);
			DatagramSocket dSock = new DatagramSocket(9999);
			dSock.receive(packet);
			int byteCount = packet.getLength();
			ByteArrayInputStream byteStream = new ByteArrayInputStream(recvBuf);
			ObjectInputStream is = new ObjectInputStream(new BufferedInputStream(byteStream));
			Object o = is.readObject();
			is.close();
			return (o);
		} catch (IOException e) {
			System.err.println("Exception:  " + e);
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return (null);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerObject so = new ServerObject();
		Prova o = (Prova) so.recvObjFrom();
		System.out.println(o.getA());
	}

}
