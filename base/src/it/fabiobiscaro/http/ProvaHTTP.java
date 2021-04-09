package it.fabiobiscaro.http;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class ProvaHTTP {

	public static void main(String[] args) {
		// Richiesta URL
		try {
			URL url = new URL("http://www.google.it/");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			BufferedReader read = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line = read.readLine();
			String html = "";
			while (line != null) {
				html += line;
				line = read.readLine();
			}
			System.out.println(html);
		} catch (MalformedURLException ex) {
			ex.printStackTrace();
		} catch (IOException ioex) {
			ioex.printStackTrace();
		}

		// Invio dati via post (che macellino...)
		try {
			String urlParameters = "a=1&b=2&operazione=%2B";
			byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);
			int postDataLength = postData.length;
			String request = "http://fabioprof.altervista.org/calcolatrice/calcolo.php";
			URL url = new URL(request);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setInstanceFollowRedirects(false);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			conn.setRequestProperty("charset", "utf-8");
			conn.setRequestProperty("Content-Length", Integer.toString(postDataLength));
			conn.setUseCaches(false);
			// I dati vanno inviati nel body
			try (DataOutputStream wr = new DataOutputStream(conn.getOutputStream())) {
				wr.write(postData);
			}
			
			// Leggo i dati della risposta
			BufferedReader read = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line = read.readLine();
			String html = "";
			while (line != null) {
				html += line;
				line = read.readLine();
			}
			// Stampo i dati della risposta
			System.out.println(html);
			
		} catch (MalformedURLException ex) {
			ex.printStackTrace();
		} catch (IOException ioex) {
			ioex.printStackTrace();
		}
	}

}
