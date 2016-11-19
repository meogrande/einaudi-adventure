package it.fabiobiscaro.database;

import java.sql.*;

public class Connessione {
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
		
		cn = DriverManager.getConnection("jdbc:ucanaccess://d://prova.mdb;");
		
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