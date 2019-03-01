package cihan.kurs.flow.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class ConnectionManager {
	private static ConnectionManager instance=null;
	private Connection conn;
	private String url = "jdbc:postgresql://127.0.0.1:5432/postgres";
	private String userName = "postgres";
	private String password = "root";
	
	private ConnectionManager() throws SQLException {

		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(url, userName, password);
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your PostgreSQL JDBC Driver? " + "Include in your library path!");
			e.printStackTrace();
		}

	}
	
	public Connection getConnection() {
		return this.conn;
	}
	
	public static ConnectionManager getIntance() throws SQLException {
		if(instance==null) {
			instance = new ConnectionManager();
		}else if(instance.getConnection().isClosed()) {
			instance = new ConnectionManager();
		}
		
		return instance;
	}



}
