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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
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
		String errorMsg = null;
		if(uname == null || uname.equals("")) {
			errorMsg = "User Name can't be null or empty";
		}
		if(password == null || password.equals("")) {
			errorMsg = "Password can't be null or empty";
		}
		if(errorMsg != null) {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/Login.html");
			PrintWriter out = response.getWriter();
			out.println("<font color=red>"+errorMsg+"</font>");
			rd.include(request, response);
		}
		else {
			UserBean userBn = new UserBean();
			userBn.setUsername(uname);
			userBn.setPassword(password);
			UserService userSvc = new UserService();
			boolean userFound= userSvc.getUserService(userBn);
			if(userFound) {
				RequestDispatcher rd =
						getServletContext().getRequestDispatcher("/Welcome.html");
				rd.forward(request, response);
			}
			else {
				RequestDispatcher rd = 
						getServletContext().getRequestDispatcher("/Login.html");
				PrintWriter out = response.getWriter();
				out.println("<font color=red>No user found with given email id, please register first. </font>");
				rd.include(request, response);
			}
							}
			}
	}


