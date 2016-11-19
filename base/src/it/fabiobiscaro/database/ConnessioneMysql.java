package it.fabiobiscaro.database;

import java.io.IOException;
import java.sql.*;

public class ConnessioneMysql {
	public static void main(String[] args) throws SQLException {
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
			System.out.println(new java.io.File("src").getCanonicalPath());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/peer?user=root&password=");
			//jdbc:mysql://localhost:3306/Contatti?user=root&password=secret
		

		sql = "SELECT * FROM corso;";
		// ________________________________query
		try {
			st = cn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next() == true)
				System.out.println(rs.getString("id") + "\t" + rs.getString("idTutor"));
		} catch (SQLException e) {
			System.out.println("errore:" + e.getMessage());
		} // fine try-catch
		cn.close(); // chiusura connessione
	}// fine main
}// fine classe