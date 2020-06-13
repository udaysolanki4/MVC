package com.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Customer;
import com.service.CustomerService;
import com.util.DateUtil;

/**
 * Servlet implementation class CustomerController
 */
@WebServlet("/CustomerController")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CustomerService service = new CustomerService();
		String source = request.getParameter("source");
		if(source.equals("addCustomer")) {
			Customer customer = new Customer();
			customer.setFirstName(request.getParameter("firstName"));
			customer.setLastName(request.getParameter("lastName"));
			customer.setDob(DateUtil.convertStringToDate(request.getParameter("dob"),"dd/MM/yyyy"));
			customer.setGender(request.getParameter("gender"));
			customer.setCity(request.getParameter("city"));
			customer.setCountry(request.getParameter("country"));
			customer.setEmail(request.getParameter("email"));
			customer.setAnnual_salary(Double.parseDouble(request.getParameter("salary")));
			System.out.println("Customer Details:\n"+customer.getFirstName());
			
			
			try {
				//@SuppressWarnings("unused")
				@SuppressWarnings("unused")
				boolean flag = service.addCustomer(customer);}
			catch(ClassNotFoundException | SQLException e){
				e.printStackTrace();
			}
	}

}
}
