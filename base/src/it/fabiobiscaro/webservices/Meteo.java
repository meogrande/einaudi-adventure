package it.fabiobiscaro.webservices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class Meteo {

	/**
	 * Effettua una connessione ad una pagina web
	 * @param targetURL l'indirizzo a cui fare la connessione
	 * @param urlParameters I parametri da passare
	 * @return Ritorna la stringa contenente i dati della pagina
	 */
	public static String excuteGet(String targetURL, String urlParameters) {
		URL url;
		HttpURLConnection connection = null;
		try {
			// Create connection
			url = new URL(targetURL + "?"+ urlParameters);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			
			// Per il POST
			//connection.setRequestMethod("POST");
			//connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			//connection.setRequestProperty("Content-Length", "" + Integer.toString(urlParameters.getBytes().length));
			connection.setRequestProperty("Content-Language", "en-US");

			connection.setUseCaches(false);
			connection.setDoInput(true);
			connection.setDoOutput(true);

			// Invia dati in post se necessario
//			DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
//			wr.writeBytes(urlParameters);
//			wr.flush();
//			wr.close();

			// Get Response
			InputStream is = connection.getInputStream();
			BufferedReader rd = new BufferedReader(new InputStreamReader(is));
			String line;
			StringBuffer response = new StringBuffer();
			while ((line = rd.readLine()) != null) {
				response.append(line);
				response.append('\r');
			}
			rd.close();
			return response.toString();

		} catch (Exception e) {

			e.printStackTrace();
			return null;

		} finally {

			if (connection != null) {
				connection.disconnect();
			}
		}
	}

	public static void jdomExecute() {
		SAXBuilder builder = new SAXBuilder();
		// Create l'URL in base alla scelta della tendina con lo ZIP code
		// Previsione a 16 giorni: http://openweathermap.org/forecast16
		// Dati correnti http://openweathermap.org/current
		// Ci si deve registrare a openweathermap per avere una chiave da
		// utilizzare come ho fatto qui sotto altrimenti dà solo i dati di prova
		// Come ricercare ad esempio per cap e paese:
		// api.openweathermap.org/data/2.5/weather?zip=94040,us&mode=xml
		try {
			URL xmlFile = new URL(
					"http://samples.openweathermap.org/data/2.5/weather?q=treviso&mode=xml&appid=b1b15e88fa797225412429c1c50c122a1");
			
			Document document = (Document) builder.build(xmlFile); // Creo il
																	// documento
			// System.out.println(document.toString());

			Element rootNode = document.getRootElement(); // Recupero l'elemento
															// del nodo root

			Element e = rootNode.getChild("city");
			System.out.println("Siamo nella città di: " + e.getAttribute("name").getValue());
			System.out.println("La velocità del vento e': "
					+ rootNode.getChild("wind").getChild("speed").getAttribute("value").getValue());

			/*
			 * Esempio se devo leggere da una lista di nodi List list =
			 * rootNode.getChildren("city"); // Prendo la lista delle città for
			 * (int i = 0; i < list.size(); i++) { Element node = (Element)
			 * list.get(i);
			 * 
			 * System.out.println("First Name : " +
			 * node.getChildText("country")); System.out.println("Last Name : "
			 * + node.getChildText("lastname")); System.out.println(
			 * "Nick Name : " + node.getChildText("nickname"));
			 * System.out.println("Salary : " + node.getChildText("salary"));
			 * 
			 * }
			 */

		} catch (IOException io) {
			System.out.println(io.getMessage());
		} catch (JDOMException jdomex) {
			System.out.println(jdomex.getMessage());
		}
	}

	public static void main(String[] args) {
		// Leggo un xml usando jdom (http è usato ma nascosto)
		jdomExecute();
		
		// Leggo usando una chiamata HTTP direttamente, posso invocare il metodo POST/GET, ecc...
		String risultato = excuteGet("http://samples.openweathermap.org/data/2.5/weather", "q=treviso&mode=xml&appid=b1b15e88fa797225412429c1c50c122a1");
		System.out.println(risultato);
	}

}
