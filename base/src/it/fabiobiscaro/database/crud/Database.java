package it.fabiobiscaro.database.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import org.apache.commons.lang.StringEscapeUtils;

/**
 * Ha deimetodi per leggere/scrivere e modificare il db amico
 * 
 * @author fabio
 *
 */
public class Database {

	/**
	 * Restituisce l'elenco degli amici presenti nella tabella amici
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<Amico> elencoAmici() {
		ArrayList<Amico> elenco = new ArrayList<Amico>();
		Connection cn;
		Statement st;
		ResultSet rs;
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
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=");

			sql = "SELECT id, nome, cognome, dataNascita FROM amici;";
			// ________________________________query

			st = cn.createStatement(); // creo sempre uno statement sulla
										// connessione
			rs = st.executeQuery(sql); // faccio la query su uno statement
			while (rs.next() == true) {
				Amico a = new Amico(rs.getInt("id"), rs.getString("nome"), rs.getString("cognome"),
						rs.getDate("dataNascita"));
				elenco.add(a);
			}

			cn.close(); // chiusura connessione
		} catch (SQLException e) {
			System.out.println("errore:" + e.getMessage());
			e.printStackTrace();
		} // fine try-catch

		return elenco;
	}

	/**
	 * Inserisci un nuovo amico nella tabella
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static void nuovoAmico(Amico a) {
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
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=");

			String nome = StringEscapeUtils.escapeSql(a.getNome());
			String cognome = StringEscapeUtils.escapeSql(a.getCognome());
			Calendar data = Calendar.getInstance();
			data.setTime(a.getData());
			String sqlData = data.get(Calendar.YEAR) + "-" + data.get(Calendar.MONTH) + "-"
					+ data.get(Calendar.DAY_OF_MONTH);

			sql = "insert into amici (nome, cognome, dataNascita) values ('" + nome + "','" + cognome + "','" + sqlData
					+ "')";

			// ________________________________query

			st = cn.createStatement(); // creo sempre uno statement sulla
										// connessione
			st.execute(sql); // faccio la query su uno statement
			cn.close(); // chiusura connessione
		} catch (SQLException e) {
			System.out.println("errore:" + e.getMessage());
		} // fine try-catch

	}

	/**
	 * Modifica un amico nella tabella MySQL
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static void modificaAmico(Amico a) throws SQLException {
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

		// Creo la connessione al database
		cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=");

		// Inserisco nelle variabili i valori da modificare
		int id = a.getId();
		String nome = StringEscapeUtils.escapeSql(a.getNome());
		String cognome = StringEscapeUtils.escapeSql(a.getCognome());
		Calendar data = Calendar.getInstance();
		data.setTime(a.getData());
		String sqlData = data.get(Calendar.YEAR) + "-" + data.get(Calendar.MONTH) + "-"
				+ data.get(Calendar.DAY_OF_MONTH);

		sql = "update amici set nome='" + nome + "', cognome = '" + cognome + "', dataNascita='" + sqlData
				+ "' where id=" + id;

		// ________________________________query
		try {
			st = cn.createStatement(); // creo sempre uno statement sulla
										// connessione
			st.execute(sql); // faccio la query su uno statement

		} catch (SQLException e) {
			System.out.println("errore:" + e.getMessage());
		} // fine try-catch
		cn.close(); // chiusura connessione
	}

	/**
	 * Elimina un amico nella tabella MySQL
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static void eliminaAmico(Amico a) {
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
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=");

			// Recupero l'id. Se volessi fare altri controlli potrei recuperare
			// anche gli altri valori
			int id = a.getId();

			sql = "delete from amici where id=" + id;

			// ________________________________query

			st = cn.createStatement(); // creo sempre uno statement sulla
										// connessione
			st.execute(sql); // faccio la query su uno statement
			cn.close(); // chiusura connessione
		} catch (SQLException e) {
			System.out.println("errore:" + e.getMessage());
		} // fine try-catch

	}

	public static void main(String[] args) throws SQLException, ParseException {
		java.text.DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Database.nuovoAmico(new Amico(1, "1", "2", df.parse("2016-10-10")));
		Database.modificaAmico(new Amico(2, "Antonio", "Dall'Armi", df.parse("2000-10-10")));
		Database.eliminaAmico(new Amico(3, null, null, null));
		System.out.println(Database.elencoAmici());
	}
}
