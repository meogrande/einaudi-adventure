package it.fabiobiscaro.database.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Ha deimetodi per leggere/scrivere e modificare il db amico
 * @author fabio
 *
 */
public class Database {

	public static ArrayList<Amico> elencoAmici() throws SQLException {
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

		// Creo la connessione al database
		cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=");
		
		sql = "SELECT id, nome, cognome, dataNascita FROM amici;";
		// ________________________________query
		try {
			st = cn.createStatement(); // creo sempre uno statement sulla
										// connessione
			rs = st.executeQuery(sql); // faccio la query su uno statement
			while (rs.next() == true) {
				Amico a = new Amico(rs.getInt("id"),rs.getString("nome"),
						rs.getString("cognome"), rs.getDate("dataNascita"));
				elenco.add(a);				
			}
		} catch (SQLException e) {
			System.out.println("errore:" + e.getMessage());
		} // fine try-catch
		cn.close(); // chiusura connessione
	
		return elenco;
	}
	
	public static void main(String[] args) throws SQLException {
		System.out.println(Database.elencoAmici());

	}

}
