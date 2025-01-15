package com.controller;

import java.io.IOException;
import java.sql.Connection;

import com.dao.UserDAO;
import com.user.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/signupform")
public class SignUpServlet extends HttpServlet{
	
	private UserDAO userDAO;
	
	@Override
	public void init() {
		Connection connection = (Connection) getServletContext().getAttribute("DBConnection");
		userDAO = new UserDAO(connection);
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String firstName = req.getParameter("firstname");
		
		String middleName = req.getParameter("middlename");
//		to stop showing null pointer exception
		if (middleName == null) {
		    middleName = ""; 
		}
		String lastName = req.getParameter("lastname");
//		to stop showing null pointer exception
		if (lastName == null) {
		    lastName = ""; 
		}
		
		String email = req.getParameter("email");
		String pNumber = req.getParameter("number");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		User user = new User(firstName, middleName, lastName, email, pNumber, username, password);
		
		RequestDispatcher rd = null;
		if(userDAO.saveUser(user)) {
			rd = req.getRequestDispatcher("redirecting.jsp");
			rd.forward(req, resp);
		}else {
			req.setAttribute("error","Failed to sign up. Please try again.");
			rd = req.getRequestDispatcher("signup.jsp");
			rd.forward(req, resp);
		}

	}
}