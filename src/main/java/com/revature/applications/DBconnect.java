package com.revature.applications;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//this class gets and returns the connection to the database

public class DBconnect {
	
	private static final String username = "Will";
	private static final String password = "hi";
	private static final String url = "jdbc:postgresql://18.224.180.36:5430/Will";
	private static Connection connection;
	
	
	public static synchronized Connection getConnection() throws SQLException {
		if (connection == null) {
			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			connection = DriverManager.getConnection(url, username, password);
		}
		
		
		
		return connection;
	}
}