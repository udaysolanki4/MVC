package com.service;

import java.sql.SQLException;

import com.bean.Customer;
import com.dao.CustomerDao;

public class CustomerService {
	CustomerDao cDao = new CustomerDao();
	public boolean addCustomer(Customer customer) throws SQLException, ClassNotFoundException{
		return cDao.addCustomer(customer);
}
}
