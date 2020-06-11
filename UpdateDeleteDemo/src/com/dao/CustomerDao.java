package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.CustomerException.NoCustomerException;
import com.CustomerException.SameValueException;
import com.bean.Customer;
import com.util.DatabaseUtil;

public class CustomerDao {
	Connection con = null;
	PreparedStatement ps = null;
	PreparedStatement ps1 = null;
	ResultSet result = null;
public boolean deleteCustomer(int customerId) throws SQLException, ClassNotFoundException, SameValueException, NoCustomerException{
		@SuppressWarnings("unused")
		Customer customer= null;
		@SuppressWarnings("unused")
		boolean flag = false;
		con = DatabaseUtil.getConnection();
		
		ps = con.prepareStatement("delete from Customer_4 where CUSTOMERID= ? ");
		
		ps.setInt(1,customerId);
		int count= ps.executeUpdate();
		
		
		
		DatabaseUtil.closeConnection(con);
		DatabaseUtil.closeStatement(ps);
		
		if(count>0)return true;
		else 
			throw new NoCustomerException("Customr does not exist");
	}
	
	public boolean updateCustomerCity(int customerId,String city) throws SQLException, ClassNotFoundException, SameValueException{
		
		con = DatabaseUtil.getConnection();
		
		ps = con.prepareStatement("select city from Customer_4 where CUSTOMERID= ? ");
		
		ps.setInt(1,customerId);
		
		result = ps.executeQuery();
		String customerCity="";
		
		while(result.next()) {
			
			customerCity= result.getString(1);
		}
		if(customerCity.equals(city)) {
			throw new SameValueException("Nothing to Modify");
		}
		ps1 = con.prepareStatement("update Customer_4 set CITY=? where CUSTOMERID=? ");
		ps1.setString(1, city);
		ps1.setInt(2, customerId);
		int count = ps1.executeUpdate();
		
		DatabaseUtil.closeConnection(con);
		DatabaseUtil.closeStatement(ps);
		DatabaseUtil.closeStatement(ps1);
		
		if(count>0)return true;
		return false;	
	}
	
public boolean updateCustomerContact(int customerId,String contact) throws SQLException, ClassNotFoundException, SameValueException{
		
		con = DatabaseUtil.getConnection();
		
		ps = con.prepareStatement("select city from Customer_4 where CUSTOMERID= ? ");
		
		ps.setInt(1,customerId);
		
		result = ps.executeQuery();
		String customerContact="";
		
		while(result.next()) {
			
			customerContact= result.getString(1);
		}
		if(customerContact.equals(contact)) {
			throw new SameValueException("Nothing to Modify");
		}
		ps1 = con.prepareStatement("update Customer_4 set CONTACT=? where CUSTOMERID=? ");
		ps1.setString(1, contact);
		ps1.setInt(2, customerId);
		int count = ps1.executeUpdate();
		
		DatabaseUtil.closeConnection(con);
		DatabaseUtil.closeStatement(ps);
		DatabaseUtil.closeStatement(ps1);
		
		if(count>0)return true;
		return false;	
	}
}
