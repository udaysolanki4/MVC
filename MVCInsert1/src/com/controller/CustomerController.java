package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

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
     * @see HttpServlet#HttpServlet()
     */
    public CustomerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String source = request.getParameter("source");
		if(source.equals("add")) {
			response.sendRedirect("addCustomer.html");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	private static Logger logger =Logger.getLogger(CustomerController.class);
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		logger.info("logger 1");
		@SuppressWarnings("unused")
		CustomerService service = new CustomerService();
		String source = request.getParameter("source");
		if(source.equals("addCustomer")) {
			logger.info("logger 2");
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
				logger.info("logger 3");
				//@SuppressWarnings("unused")
				//boolean flag = service.addCustomer(customer);
				Integer customerId = service.addCustomer(customer);
				if(customerId!=null) {
					logger.info("logger 4");
					request.setAttribute("customerId", customerId);
				}
				logger.info("logger 5");
				RequestDispatcher rd = request.getRequestDispatcher("addCustomer.jsp");
				rd.forward(request, response);
				
				
			}
		
			catch(ClassNotFoundException | SQLException e){
				logger.info("logger 6");
				e.printStackTrace();
			}
	}
	}
}


