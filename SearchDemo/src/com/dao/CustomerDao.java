package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.Customer;
import com.util.DatabaseUtil;

public class CustomerDao {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet result = null;
	
	public Customer searchCustomerById(int customerId) throws SQLException, ClassNotFoundException{
		Customer customer = null;
		@SuppressWarnings("unused")
		boolean flag = false;
		con = DatabaseUtil.getConnection();
		
		ps = con.prepareStatement("select * from Customer_4 where CUSTOMERID= ? ");
		
		ps.setInt(1,customerId);
		
		result = ps.executeQuery();
		
		while(result.next()) {
			customer = new Customer();
			customer.setCustomerId(result.getInt(1));
			customer.setFirstName(result.getString(2));
			customer.setLastName(result.getString(3));
			customer.setContact(result.getString(4));
			customer.setGender(result.getString(5));
			customer.setMarried(result.getString(6));
			customer.setCity(result.getString(7));
		}
		DatabaseUtil.closeConnection(con);
		DatabaseUtil.closeStatement(ps);
		
		
		return customer;
	}
	public ArrayList<Customer> searchCustomerByCity(String city) throws SQLException, ClassNotFoundException{
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		Customer customer = null;
		@SuppressWarnings("unused")
		boolean flag =false;
		con = DatabaseUtil.getConnection();
		
		ps = con.prepareStatement("select * from Customer_4 where UPPER(CITY)= UPPER(?) ");
		
		ps.setString(1,city);
		
		result = ps.executeQuery();
		
		while(result.next()) {
			customer = new Customer();
			customer.setCustomerId(result.getInt(1));
			customer.setFirstName(result.getString(2));
			customer.setLastName(result.getString(3));
			customer.setContact(result.getString(4));
			customer.setGender(result.getString(5));
			customer.setMarried(result.getString(6));
			customer.setCity(result.getString(7));
			customerList.add(customer);
		}
		DatabaseUtil.closeConnection(con);
		DatabaseUtil.closeStatement(ps);
		
		
		return customerList;
		
	}
	public ArrayList<Customer> searchCustomerByHobby(String hobby) throws SQLException, ClassNotFoundException{
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		Customer customer = null;
		@SuppressWarnings("unused")
		boolean flag =false;
		con = DatabaseUtil.getConnection();
		
		ps = con.prepareStatement("select * from Customer_4 c, Hobby_4 h where UPPER(h.HOBBY)= UPPER(?) and c.CUSTOMERID = h.CUSTOMERID ");
		
		ps.setString(1,hobby);
		
		result = ps.executeQuery();
		
		while(result.next()) {
			customer = new Customer();
			customer.setCustomerId(result.getInt(1));
			customer.setFirstName(result.getString(2));
			customer.setLastName(result.getString(3));
			customer.setContact(result.getString(4));
			customer.setGender(result.getString(5));
			customer.setMarried(result.getString(6));
			customer.setCity(result.getString(7));
			customerList.add(customer);
		}
		DatabaseUtil.closeConnection(con);
		DatabaseUtil.closeStatement(ps);
		
		
		return customerList;
	}
}
