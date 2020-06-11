package com.controller;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;

import com.service.UserService;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
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
		String uname = request.getParameter("username");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String country = request.getParameter("country");
		String errorMsg = null;
		if(uname == null || uname.equals("")) {
			errorMsg = "User Name can't be null or empty.";
		}
		if(password == null || password.equals("")) {
			errorMsg = "Password can't be null or empty.";
		}
		if(name == null || name.equals("")) {
			errorMsg = "Name can't be null or empty";
		}
		if(country == null || name.equals("")) {
			errorMsg = "Country can't be null or empty";
		}
		if(errorMsg != null) {
			RequestDispatcher rd = 
					getServletContext().getRequestDispatcher("/Register.html");
			PrintWriter out = response.getWriter();
			out.println("<font color=red>"+errorMsg+"</font>");
			rd.include(request, response);
		}
		else {
			UserBean userBn = new UserBean();
			userBn.setUsername(name);
			userBn.setPassword(country);
			userBn.setUsername(uname);
			userBn.setPassword(password);
			UserService userSvc = new UserService();
			if(userSvc.insertUserService(userBn)) {
				RequestDispatcher rd = 
						getServletContext().getRequestDispatcher("/Login.html");
				PrintWriter out = response.getWriter();
				out.println("<font color=green>Registration successful, please login below.</font>");
				rd.include(request, response);
			}
			
	
	}

}
}
