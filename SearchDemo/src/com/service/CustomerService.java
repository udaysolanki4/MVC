package com.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.Customer;
import com.dao.CustomerDao;

public class CustomerService {
CustomerDao cDao =  new CustomerDao();
public Customer searchCustomerById(int customerId) throws SQLException, ClassNotFoundException{
	return cDao.searchCustomerById(customerId);
}
public ArrayList<Customer> searchCustomerByCity(String city) throws SQLException, ClassNotFoundException{
	return cDao.searchCustomerByCity(city);
}
public ArrayList<Customer> searchCustomerByHobby(String hobby) throws SQLException, ClassNotFoundException{
	return cDao.searchCustomerByHobby(hobby);
}
}
