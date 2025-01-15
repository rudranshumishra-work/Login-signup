package com.filter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

	public static boolean isValidPassword(String pass) {
		
		String regex = "^(?=.*[0-9])"
                		+ "(?=.*[a-z])(?=.*[A-Z])"
            			+ "(?=.*[@#$%^&+=])"
            			+ "(?=\\S+$).{8,20}$";
		
		Pattern p = Pattern.compile(regex);
		
		Matcher m = p.matcher(pass);
		
		return m.matches();
	}
	
	
	public static boolean isValidEmail(String email) {
		
		String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" 
						+ "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
		
		Pattern p = Pattern.compile(regex);
		
		Matcher m = p.matcher(email);
		
		return m.matches();
		
	}
	
	
	public static boolean isValidName(String name) {
		
		String regex = "^[A-Za-z]+$";
		
		Pattern p = Pattern.compile(regex);
		
		Matcher m = p.matcher(name);
		
		return m.matches();
	}
	
	
	public static boolean isValidUsername(String uname) {
		
		String regex = "^[A-Za-z]\\w{5,29}$";
		
		Pattern p = Pattern.compile(regex);
		
		Matcher m = p.matcher(uname);
		
		return m.matches();
	}
}
