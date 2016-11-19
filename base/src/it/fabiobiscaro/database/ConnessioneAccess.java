package it.fabiobiscaro.database;

import java.io.IOException;
import java.sql.*;

public class ConnessioneAccess {
	public static void main(String[] args) throws SQLException {
		Connection cn;
		Statement st;
		ResultSet rs;
		String sql;
		// ________________________________connessione
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException: ");
			System.err.println(e.getMessage());
		} // fine try-catch

		try {
			System.out.println(new java.io.File("src").getCanonicalPath());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			cn = DriverManager.getConnection("jdbc:ucanaccess://" + ((new java.io.File("src")).getCanonicalPath())
					+ "/it/fabiobiscaro/database/prova.mdb;");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			cn = null;
		}

		sql = "SELECT * FROM clienti;";
		// ________________________________query
		try {
			st = cn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next() == true)
				System.out.println(rs.getString("nome") + "\t" + rs.getString("cognome"));
		} catch (SQLException e) {
			System.out.println("errore:" + e.getMessage());
		} // fine try-catch
		cn.close(); // chiusura connessione
	}// fine main
}// fine classe