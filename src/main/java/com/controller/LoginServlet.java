package com.controller;

import java.io.IOException;
import java.sql.Connection;

import org.apache.catalina.core.AprLifecycleListener;

import com.dao.UserDAO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/loginform")
public class LoginServlet extends HttpServlet{
	private UserDAO userDAO;
	
	@Override
	public void init() {
		Connection connection = (Connection) getServletContext().getAttribute("DBConnection");
		userDAO = new UserDAO(connection);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
		
		//Read Data from jsp form
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		try {
			if(userDAO.authenticate(username, password)) {
				
				String fetchedname = userDAO.getFetchedname();
				
				HttpSession hs = req.getSession();
				hs.setAttribute("username", fetchedname);
				
				System.out.println(fetchedname);
				
				resp.sendRedirect("welcome.jsp");
			}
			else {
				HttpSession hs = req.getSession();
				hs.setAttribute("loginerror", "Invalid username or password");

				resp.sendRedirect("login.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
