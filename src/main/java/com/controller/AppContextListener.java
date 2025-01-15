package com.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class AppContextListener implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/trial_app","root","root");
			sce.getServletContext().setAttribute("DBConnection", connection);
			
			System.out.println("Database connection initialised successfully!");
			
		} catch (Exception e) {
			throw new RuntimeException("Failed to initialised database connection", e);
		}
		
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		Connection connection = (Connection) sce.getServletContext().getAttribute("DBConnection");
		if(connection != null) {
			try {
				connection.close();
				System.out.println("Database Connection Closed.");
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
