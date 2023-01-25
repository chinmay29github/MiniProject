package com.velocity.miniproject;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
	Connection connection =null;
	public Connection getConnectionDetails() {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz","root","root");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	
	

}
