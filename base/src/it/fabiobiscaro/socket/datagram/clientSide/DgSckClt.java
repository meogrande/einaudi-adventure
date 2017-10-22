package it.fabiobiscaro.socket.datagram.clientSide;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.DatagramPacket;

public class DgSckClt {

	public static void main(String[] args) throws Exception{
		final InetAddress IP = InetAddress.getByName((args.length > 0) ? args[0] : "localhost");
		final int PORT = (args.length > 1) ? Integer.parseInt(args[1]) : 1234;
		//final String MSG = (args.length > 2) ? args[2] : "GodAbenFitz";
	
		for (String MSG: args) {
			System.out.printf("* Send \'%s\' message to [%s:%d]..\n", MSG, IP, PORT);
			DatagramSocket s = new DatagramSocket();
			s.send(new DatagramPacket(MSG.getBytes(), MSG.getBytes().length, IP, PORT));
			s.close();
		}
	}

}
