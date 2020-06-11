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

import com.CustomerException.NoCustomerException;
import com.CustomerException.SameValueException;
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
		String source = request.getParameter("source");
		if(source.equals("update")) {
			response.sendRedirect("updateCustomer.html");
	     }
		else if(source.equals("delete")) {
			response.sendRedirect("deleteCustomer.html");
	     }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CustomerService service = new CustomerService();
		
		
		String source = request.getParameter("source");
		if(source.equals("delete")) {
			PrintWriter out = response.getWriter();
			try {
				
				String customerId = request.getParameter("customerId");
				boolean status = false;
				try {
					status = service.deleteCustomer(Integer.parseInt(customerId));
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SameValueException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				response.setContentType("text/html");
				
				
				out.println("<html");
				out.println("<head>");
				out.println("<title>Customer Details</title>");
				out.println("</head>");
				out.println("<body>");
				
				if(status) {
					out.println("<h3>Customer record is deleted successfully</h3>");
												
				}
				
				out.println("</body>");
				out.println("</html>");
			}
			catch(ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			catch(NoCustomerException e) {
				out.println("<h3>Sorry. "+ e.getMessage() +"</h3>");
				out.println("</body>");
				out.println("</html>");
			}
		}
		else if(source.equals("update")) {
			PrintWriter out = response.getWriter();
			try {
				
				String customerId = request.getParameter("customerId");
				String updateParam = request.getParameter("updateParam");
				String updateValue = request.getParameter("updateValue");
				boolean status = false;
				if(updateParam.equals("city")) {
					try {
						status = service.updateCustomerCity(Integer.parseInt(customerId),updateValue);
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SameValueException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else if(updateParam.equals("contact")) {
					try {
						status = service.updateCustomerContact(Integer.parseInt(customerId),updateValue);
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SameValueException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				response.setContentType("text/html");
				
				
				out.println("<html");
				out.println("<head>");
				out.println("<title>Customer Details</title>");
				out.println("</head>");
				out.println("<body>");
				
				if(status) {
					out.println("<h3>Customer record is updated successfully</h3>");
												
				}
				else {
					out.println("<h3>Sorry Something went wrong</h3>");
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
