package com.service;

import java.sql.SQLException;
import com.CustomerException.NoCustomerException;
import com.CustomerException.SameValueException;
import com.dao.CustomerDao;

public class CustomerService {
	CustomerDao cDao= new CustomerDao();
	public boolean updateCustomerCity(int customerId,String city) throws SQLException, ClassNotFoundException, SameValueException{
		return cDao.updateCustomerCity(customerId,city);
	}
	public boolean updateCustomerContact(int customerId,String contact) throws SQLException, ClassNotFoundException, SameValueException{
		return cDao.updateCustomerContact(customerId,contact);
	}
	public boolean deleteCustomer(int customerId) throws SQLException, ClassNotFoundException, SameValueException, NoCustomerException{
		return cDao.deleteCustomer(customerId);
	}
}
