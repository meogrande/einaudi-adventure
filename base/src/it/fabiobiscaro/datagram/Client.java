package it.fabiobiscaro.datagram;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;

import javax.imageio.ImageIO;

class Client {
	public static void main(String args[]) throws Exception {
		/*Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()); //Rilevo la dimensione dello schermo per lo screenshot
		BufferedImage capture = new Robot().createScreenCapture(screenRect); //faccio lo screenshot e lo memorizzo in un BufferedImgage
		ByteArrayOutputStream baos = new ByteArrayOutputStream(); //Creazione di un array di byte di lunghezza 32
		ImageIO.write(capture, "bmp", baos);  //Salva l'immagine dell'oggetto baos sotto formato bmp
		baos.flush();
		byte[] buffer = baos.toByteArray();*/
		
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
		DatagramSocket clientSocket = new DatagramSocket();
		InetAddress IPAddress = InetAddress.getByName("localhost");
		byte[] sendData = new byte[1024];
		byte[] receiveData = new byte[1024];
		String sentence = "";
		while(true){
			if(sentence.equalsIgnoreCase("FINE")){ //Se la string inserita corrisponde a FINE, allora esco dal ciclo
				break;
			}
			sentence = inFromUser.readLine(); //Lettura input da tastiera
			sendData = sentence.getBytes(); //inserimento dell'input all'interno di un byte
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876); //Creo il pacchetto da inviare al server0
			clientSocket.send(sendPacket); //Invio il paccheto sopra creato
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);  //Crea il pacchetto dove memorizzare i dati ricevuti dal server
			clientSocket.receive(receivePacket); //Il client si mette in attesa della ricezione di un pacchetto
			String modifiedSentence = new String(receivePacket.getData());
			if(modifiedSentence != null){
				System.out.println("FROM SERVER:" + modifiedSentence);
			}
		}
		clientSocket.close();
	}
	
	
}