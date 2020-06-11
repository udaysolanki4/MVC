package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.UserBean;

public class UserDao {
	static String serverName ="localhost";
	static String portNumber = "1521";
	static String sid = "pi";
	static String url = "jdbc:oracle:thin:@"+ serverName+":"+portNumber+":"+sid;
	static String dbUsername = "hr";
	static String dbPassword = "hr";
	
	public boolean insertUser(UserBean usr) {
		boolean status = false;
		PreparedStatement ps = null;
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("The Jdbc URL is "+ url);
			conn = DriverManager.getConnection(url, dbUsername, dbPassword);
			ps = conn.prepareStatement("insert into Users(name, username, country, password) values (?,?,?,?)");
			ps.setString(1, usr.getName());
			ps.setString(2, usr.getUsername());
			ps.setString(3, usr.getCountry());
			ps.setString(4, usr.getPassword());
			
			status = ps.execute();
			
		}catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				ps.close();}
			catch(SQLException e) {}
			}
		return status;
		}
	public boolean getUser(UserBean usr) {
		boolean userFound =false;
		PreparedStatement ps =null;
		Connection conn = null;
		ResultSet rs = null;
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				System.out.println("The Jdbc URL is "+ url);
				conn = DriverManager.getConnection(url, dbUsername, dbPassword);
				ps = conn.prepareStatement("select name,username,country from Users where username=? and password=?");
				ps.setString(1, usr.getUsername());
				ps.setString(2, usr.getPassword());
				rs = ps.executeQuery();
				if(rs !=null && rs.next()) {
					userFound =true;
				}else {
					userFound =false;
				}
			}catch(SQLException |ClassNotFoundException e) {
				e.printStackTrace();
			}
			finally {
				try {
					rs.close();
					ps.close();
				}catch(SQLException e) {}
			}
			return userFound;
	}
	
}


