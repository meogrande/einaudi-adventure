package it.fabiobiscaro.datagram;

import java.io.*;
import java.net.*;

class Server {
	public static void main(String args[]) throws Exception {
		DatagramSocket serverSocket = new DatagramSocket(9876); //Creazione serverSocket sulla porta 9876
		byte[] receiveData = new byte[1024]; //Allocazione array di byte dove verranno memorizzati i dati da ricevere
		byte[] sendData = new byte[1024];	//Allocazione array di byte dove verranno memorizzati i dati da inviare
		while (true) {
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length); //Creazione pacchetto dove verrano inseriti i dati ricevuti
			serverSocket.receive(receivePacket); //riceve il pacchetto e lo memorizza nell'oggetto 'receivePacket'
			String sentence = new String(receivePacket.getData()); //Creazione della strinza da inviare, prendendo quella ricevuta
			System.out.println("RECEIVED: " + sentence);	//aggiungo "RECEIVED" alla stringa ricevuta dal client
 			InetAddress IPAddress = receivePacket.getAddress(); //Ottengo l'indirizzo IP del CLient
			int port = receivePacket.getPort(); //Ottengo la porta dove ricevo i dati
			if(!sentence.equalsIgnoreCase("fine")){ //Se il client invia messaggi normali, continua la comunicazione
				String capitalizedSentence = sentence.toUpperCase();
				sendData = capitalizedSentence.getBytes();	//trasforma la striga in una sequenza di byte
				DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port); //creazione del pacchetto da inviare
				serverSocket.send(sendPacket); //invio il pacchetto 
				sendPacket = null; //"azzero" il pacchetto
			}else{ 	//altrimenti, se il client invia "fine" termina la comunicazione
				String endSentence = "Fine Comunicazione"; 
				sendData = endSentence.getBytes();
				DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
				serverSocket.send(sendPacket);
				serverSocket.close();
			}
		}
	}
}