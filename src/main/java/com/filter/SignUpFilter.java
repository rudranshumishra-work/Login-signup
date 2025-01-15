package com.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter("/signupform")
public class SignUpFilter extends HttpFilter implements Filter{
	
	@Override
	protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String fname = request.getParameter("firstname");
		String mname = request.getParameter("middlename");
		String lname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String p_number = request.getParameter("number");
		String uname = request.getParameter("username");
		String pass = request.getParameter("password");
		
		boolean isError = false;
		
//		Checking first name if null
		if(fname.isEmpty() == true) {
			isError = true;
			request.setAttribute("firstnameerror","Please Enter First Name");
		}
//		checking first name is not null and is valid
		else if(fname.isEmpty() == false && Validator.isValidName(fname) == false) {
			isError = true;
			request.setAttribute("firstnameerror","Please Enter Valid Name");
		}
//		setting value if correct
		else {
			request.setAttribute("firstNameValue",fname);
		}

//		checking second name is not null and is valid		
		if(mname.isEmpty() == false && Validator.isValidName(mname) == false) {
				isError = true;
				request.setAttribute("middlenameerror","Please Enter Valid Name");
		}
//		setting value if correct
		else {
			request.setAttribute("middleNameValue",mname);
		}
		
//		checking last name is not null and is valid
		if(lname.isEmpty() == false && Validator.isValidName(lname) == false) {
				isError = true;
				request.setAttribute("lastnameerror","Please Enter Valid Name");
		}
//		setting value if correct
		else {
			request.setAttribute("lastNameValue",lname);
		}
		
		
//		checking if email is null
		if(email.isEmpty() == true) {
			isError = true;
			request.setAttribute("emailerror","Please Enter Email");
		}
//		checking if email is not null and is valid
		else if(email.isEmpty() == false && Validator.isValidEmail(email) == false) {
				isError = true;
				request.setAttribute("emailerror","Please Enter Valid Email");
		}
//		setting value if correct
		else {
			request.setAttribute("emailValue",email);
		}
		
//		checking if number is not null
		if(p_number.isEmpty() == true) {
			isError = true;
			request.setAttribute("numbererror","Please Enter Number");
		}
//		checking if number is not null and is valid
		else if(p_number.isEmpty() == false && p_number.length() !=10) {
			isError = true;
			request.setAttribute("numbererror", "Enter valid number");
		}
//		setting value if correct
		else {
			request.setAttribute("phoneNumberValue",p_number);
		}
		
//		checking if username is null
		if(uname.isEmpty() == true) {
			isError = true;
			request.setAttribute("usernameerror","Please Enter Username");
		}
//		checking if username is not null and is valid
		else if(uname.isEmpty() == false && Validator.isValidUsername(uname) == false) {
				isError = true;
				request.setAttribute("usernameerror","Please Enter Valid Username");
		}
//		setting value if correct
		else {
			request.setAttribute("usernameValue",uname);
		}
		
//		checking if password is empty
		if(pass.isEmpty() == true) {
			isError = true;
			request.setAttribute("passworderror","Please Enter Password");
		}
//		checking if password is not empty and is valid
		else if(pass.isEmpty() == false && Validator.isValidPassword(pass) == false) {
				isError = true;
				request.setAttribute("passworderror","Please Enter Valid Password");
		}
//		setting value if correct
		else {
			request.setAttribute("passwordValue",pass);
		}
		
		
		
		
		RequestDispatcher rd = null;
//		Forward
		if(isError == false) {
			chain.doFilter(request, response);
		}
//		Backward
		else {
			rd = request.getRequestDispatcher("signup.jsp");
			rd.forward(request, response);
		}

		
	}

}
