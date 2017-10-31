/**
 * Scritto da Biagio Rosario Greco - birg81@libero.it
 */
package it.fabiobiscaro.socket.datagramserverSide;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class DgSckSrv implements Runnable {
	private final DatagramSocket s;
	private DatagramPacket pkt;
	private byte[] buf = new byte[256];
	
	public DgSckSrv(int PORT) throws Exception{
		System.out.printf("Server ready to recive on port: %d..\n", PORT);
		s = new DatagramSocket(PORT);
	}

	@Override
	public void run() {
		boolean running = true;
		String CMD;
		for ( ; running; ) {
			pkt = new DatagramPacket(buf, buf.length);
			try {
				s.receive(pkt);
			} catch (Exception e) {	}
			CMD = new String(pkt.getData(), 0, pkt.getLength());
			System.out.printf("> recive %d Byte message  \'%s\' from [%s:%s]..\n", pkt.getLength(), CMD, pkt.getAddress(), pkt.getPort());
			running = !CMD.equals("END");
		}
		System.out.println("Remote Command! Server Closed..");
		s.close();
	}
	
	public static void main(String[] args) throws Exception {
		new Thread(new DgSckSrv((args.length > 0) ? Integer.parseInt(args[0]) : 1234)).start();
	}

}
