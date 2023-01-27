package com.velocity.miniproject;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
	
	public static Connection getConnectionDetails() {	
		Connection connection =null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz","root","root");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	
	

}
