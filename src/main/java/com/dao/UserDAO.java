package com.dao;

import java.security.PrivateKey;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.user.User;

import jakarta.servlet.ServletException;


public class UserDAO {
	
	private Connection connection;
	
	public UserDAO(Connection connection) {
		this.connection = connection;
	}
	
	public boolean saveUser(User user){
		try {
			PreparedStatement ps = connection.prepareStatement("insert into users(name, email, p_number, username, password) values(?, ?, ?, ?, ?)");

			//	Conditions for name
			String fullName = user.getFirstName();
			if(!user.getMiddleName().isEmpty()) {
				fullName += " " + user.getMiddleName();
			}
			if(!user.getLastName().isEmpty()) {
				fullName += " " + user.getLastName();
			}
			
			ps.setString(1, fullName);
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getpNumber());
			ps.setString(4, user.getUsername());
			ps.setString(5, user.getPassword());
			
			return ps.executeUpdate()>0;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
	private String fetchedname;
	
	public boolean authenticate(String username, String password) throws ServletException {
		
		try {
			PreparedStatement ps = connection.prepareStatement("select * from users where username=? and password=?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				fetchedname = rs.getString("name");
				return true;
			}
			 			 
			
		} catch (SQLException e) {
			throw new ServletException("Database error: "+ e.getMessage(), e);
		}
		
		return false;
	}

	public String getFetchedname() {
		return fetchedname;
	}


}
