package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		@SuppressWarnings("unused")
		CustomerService service = new CustomerService();
		String source = request.getParameter("source");
		if(source.equals("addCustomer")) {
			Customer customer = new Customer();
			customer.setFirstName(request.getParameter("firstname"));
			customer.setLastName(request.getParameter("lastname"));
			customer.setDob(DateUtil.convertStringToDate(request.getParameter("dob"),"dd/MM/yyyy"));
			customer.setGender(request.getParameter("gender"));
			customer.setCity(request.getParameter("city"));
			customer.setCountry(request.getParameter("country"));
			customer.setEmail(request.getParameter("email"));
			customer.setAnnual_salary(Double.parseDouble(request.getParameter("salary")));
			System.out.println("Customer Details:\n"+customer.getFirstName());
			try {
				//@SuppressWarnings("unused")
				boolean flag = service.addCustomer(customer);
				if(flag) {
					response.setContentType("text/html");
					PrintWriter out = response.getWriter();
					out.println("<html>");
					out.println("<head>");
					out.println("<title>View customer</title>");
					out.println("</head>");
					out.println("<body>");
					
					out.println("Firstname :"+customer.getFirstName()+"<br/>");
					out.println("Lastname :"+customer.getLastName()+"<br/>");
					out.println("Date of Birth :"+customer.getDob()+"<br/>");
					out.println("Gender :"+customer.getGender()+"<br/>");
					out.println("City :"+customer.getCity()+"<br/>");
					out.println("Country :"+customer.getCountry()+"<br/>");
					out.println("Email :"+customer.getEmail()+"<br/>");
					out.println("Annual Salary :"+customer.getAnnual_salary()+"<br/>");
					
					out.println("</body>");
					out.println("</html");
					
				}
				
			}
			catch(ClassNotFoundException | SQLException e){
				e.printStackTrace();
			}
	}
	}
}


