package com.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	static final String serverName ="localhost";
	static final String portNumber = "1521";
	static final String sid = "pi";
	static final String url = "jdbc:oracle:thin:@"+ serverName+":"+portNumber+":"+sid;
	static final String dbUsername = "hr";
	static final String dbPassword = "hr";
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("The Jdbc URL is "+ url);
			conn = DriverManager.getConnection(url, dbUsername, dbPassword);
		}catch(ClassNotFoundException |SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
