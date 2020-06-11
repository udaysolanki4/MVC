package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Customer;
import com.service.CustomerService;

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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CustomerService service = new CustomerService();
		@SuppressWarnings("unused")
		ArrayList<Customer> customerList = null;
		String source = request.getParameter("searchParam");
		if(source.equals("customerId")) {
			try {
				String customerId = request.getParameter("searchValue");
				Customer customer = service.searchCustomerById(Integer.parseInt(customerId));
				response.setContentType("text/html");
				
				PrintWriter out = response.getWriter();
				out.println("<html");
				out.println("<head>");
				out.println("<title>Customer Details</title>");
				out.println("</head>");
				out.println("<body>");
				
				if(customer != null) {
					out.println("<table border=\"1\"cellpadding=\"1\" cellspacing=\"1\" " );
					out.println("<tr>");
					out.println("<td>CUSTOMERID</td>");
					out.println("<td>FIRST NAME</td>");
					out.println("<td>LAST NAME</td>");
					out.println("<td>CONTACT</td>");
					out.println("<td>GENDER</td>");
					out.println("<td>MARRIED</td>");
					out.println("<td>CITY</td>");
					out.println("</tr>");
					
					out.println("<tr>");
					out.println("<td>"+customer.getCustomerId()+"</td>");
					out.println("<td>"+customer.getFirstName()+"</td>");
					out.println("<td>"+customer.getLastName()+"</td>");
					out.println("<td>"+customer.getContact()+"</td>");
					out.println("<td>"+customer.getGender()+"</td>");
					out.println("<td>"+customer.getMarried()+"</td>");
					out.println("<td>"+customer.getCity()+"</td>");
					out.println("</tr>");
					out.println("</table>");
									
				}
				else {
					out.println("Customer with customer Id as "+customerId+"does not exist");
					
				}
				out.println("</body>");
				out.println("</html>");
			}
			catch(ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		else if(source.equals("city")) {
			try {
				String city = request.getParameter("searchValue");
				customerList = service.searchCustomerByCity(city);
				response.setContentType("text/html");
				
				PrintWriter out = response.getWriter();
				out.println("<html");
				out.println("<head>");
				out.println("<title>Customer Details</title>");
				out.println("</head>");
				out.println("<body>");
				
				if(customerList.size()> 0) {
					out.println("<table border=\"1\"cellpadding=\"1\" cellspacing=\"1\" " );
					out.println("<tr>");
					out.println("<td>CUSTOMERID</td>");
					out.println("<td>FIRST NAME</td>");
					out.println("<td>LAST NAME</td>");
					out.println("<td>CONTACT</td>");
					out.println("<td>GENDER</td>");
					out.println("<td>MARRIED</td>");
					out.println("<td>CITY</td>");
					out.println("</tr>");
					
					for(Customer customer:customerList) {
						out.println("<tr>");
					out.println("<td>"+customer.getCustomerId()+"</td>");
					out.println("<td>"+customer.getFirstName()+"</td>");
					out.println("<td>"+customer.getLastName()+"</td>");
					out.println("<td>"+customer.getContact()+"</td>");
					out.println("<td>"+customer.getGender()+"</td>");
					out.println("<td>"+customer.getMarried()+"</td>");
					out.println("<td>"+customer.getCity()+"</td>");
					out.println("</tr>");
					}
					
					
					out.println("</table>");
									
				}
				else {
					out.println("No Customer are from city"+city);
					
				}
				out.println("</body>");
				out.println("</html>");
			}
			catch(ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		else if(source.equals("hobby")) {
			try {
				String hobby = request.getParameter("searchValue");
				customerList = service.searchCustomerByHobby(hobby);
				response.setContentType("text/html");
				
				PrintWriter out = response.getWriter();
				out.println("<html");
				out.println("<head>");
				out.println("<title>Customer Details</title>");
				out.println("</head>");
				out.println("<body>");
				
				if(customerList.size()> 0) {
					out.println("<table border=\"1\"cellpadding=\"1\" cellspacing=\"1\" " );
					out.println("<tr>");
					out.println("<td>CUSTOMERID</td>");
					out.println("<td>FIRST NAME</td>");
					out.println("<td>LAST NAME</td>");
					out.println("<td>CONTACT</td>");
					out.println("<td>GENDER</td>");
					out.println("<td>MARRIED</td>");
					out.println("<td>CITY</td>");
					out.println("<td>HOBBY</td>");
					out.println("</tr>");
					
					for(Customer customer:customerList) {
						out.println("<tr>");
					out.println("<td>"+customer.getCustomerId()+"</td>");
					out.println("<td>"+customer.getFirstName()+"</td>");
					out.println("<td>"+customer.getLastName()+"</td>");
					out.println("<td>"+customer.getContact()+"</td>");
					out.println("<td>"+customer.getGender()+"</td>");
					out.println("<td>"+customer.getMarried()+"</td>");
					out.println("<td>"+customer.getCity()+"</td>");
					out.println("<td>"+hobby+"</td>");
					out.println("</tr>");
					}
					
					
					out.println("</table>");
									
				}
				else {
					out.println("No Customer have"+hobby+"as Hobby");
					
				}
				out.println("</body>");
				out.println("</html>");
			}
			catch(ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}
