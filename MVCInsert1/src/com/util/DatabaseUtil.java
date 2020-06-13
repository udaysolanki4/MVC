package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseUtil {
		private static final String  URL = "jdbc:oracle:thin:@localhost:1521:pi";
		private static final String  DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
		private static final String  USERNAME = "hr";
		private static final String  PASSWORD = "hr";
		
		public static Connection getConnection() {
			Connection con = null;
			
			try {
				Class.forName(DRIVER_NAME);
				con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
						
			}
			catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			return con;	
		}
		public static void closeConnection(Connection con) {
			if(con!=null) {
				try {
					con.close();
					}
				catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		public static void closeStatement(PreparedStatement ps) {
			if(ps!=null) {
				try {
					ps.close();
					
				}
				catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
}
