package it.fabiobiscaro.webservices;

import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class CalculatorPHP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Inserisci un numero:");
		int a = input.nextInt();
		System.out.println("Inserisci un altro numero:");
		int b = input.nextInt();
		String operazione = input.nextLine();
		System.out.println("Inserisci una operazione:");
		operazione = input.nextLine();

		SAXBuilder builder = new SAXBuilder();

		try {
			URL xmlFile = new URL("http://localhost/calculator/calcola.php?a=" + String.valueOf(a) + "&b="
					+ String.valueOf(b) + "&operazione=" + URLEncoder.encode(operazione));

			Document document = (Document) builder.build(xmlFile); // Creo il
																	// documento
			Element rootNode = document.getRootElement(); // Recupero l'elemento
															// del nodo root

			String risultato = rootNode.getText(); // Prendo il testo dentro il risultato
			System.out.println("Il risultato è: " + risultato);

		} catch (Exception io) {
			io.printStackTrace();
		}

		// Chiamo un web service per fare la somma, la somma è restituita in
		// xml!
	}

}
