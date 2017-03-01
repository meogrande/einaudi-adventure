package it.fabiobiscaro.socket.invitofesta;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.commons.lang.StringEscapeUtils;

public class Server {
	
	public static boolean esisteIscritto(String nick) {
		
		Connection cn;
		Statement st;
		ResultSet rs;
		String sql;
		
		boolean esiste = true;
		
		// ________________________________connessione
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException: ");
			System.err.println(e.getMessage());
		} // fine try-catch

		try {
			// Creo la connessione al database
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/scuola?user=root&password=");

			nick = StringEscapeUtils.escapeSql(nick);
			sql = "SELECT * from iscritto where nick='"+nick+"';";
			// ________________________________query

			st = cn.createStatement(); // creo sempre uno statement sulla
										// connessione
			rs = st.executeQuery(sql); // faccio la query su uno statement

			if (rs.next()==true) {
				// Esiste un record
				cn.close();
				esiste = true;
			} else {
				// Non esiste un record
				cn.close();
				esiste = false;
			}
			
			//cn.close(); // chiusura connessione
		} catch (SQLException e) {
			System.out.println("errore:" + e.getMessage());
			e.printStackTrace();
		} // fine try-catch

		return esiste;
	}

	
	// Metodo per salvare nel database
	public static void nuovoIscritto(String nick) {
		Connection cn;
		Statement st;
		String sql;
		// ________________________________connessione
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException: ");
			System.err.println(e.getMessage());
		} // fine try-catch

		try {
			// Creo la connessione al database
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/scuola?user=root&password=");

			nick = StringEscapeUtils.escapeSql(nick);
			sql = "insert into iscritto (nick) values ('" + nick + "')";
			System.out.println(sql);
			// ________________________________query

			st = cn.createStatement(); // creo sempre uno statement sulla
										// connessione
			st.execute(sql); // faccio la query su uno statement
			cn.close(); // chiusura connessione
		} catch (SQLException e) {
			System.out.println("errore:" + e.getMessage());
		} // fine try-catch

	}
	
	public static void main(String[] args) {
		try {
			// Creo il serve per ricevee le connessioni
			ServerSocket ss = new ServerSocket(9999);
			while (true) {
					Socket s = ss.accept();
					
					// leggo il nick
					InputStreamReader isr = new InputStreamReader(s.getInputStream());
					BufferedReader in = new BufferedReader(isr);
					String nick = in.readLine();
					System.out.println("Il server riceve: " + nick);
					PrintWriter out = new PrintWriter(s.getOutputStream(), true);
					// Salvo nel database
					if (esisteIscritto(nick)) {
						out.println("Utente esistente");						
					} else {
						nuovoIscritto(nick);
						// Scrivo la risposta al client
						out.println("Ok");
					}
					
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
