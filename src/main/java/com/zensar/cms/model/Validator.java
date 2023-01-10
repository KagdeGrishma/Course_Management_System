package com.zensar.cms.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.zensar.cms.dto.RequestTemplate;
import com.zensar.cms.util.Constants;

public class Validator {
	
	public String isValid(RequestTemplate request){
		
		if(request.getUserDetailsInfo().getFirstname()==null || (request.getUserDetailsInfo().getFirstname()=="")) {
			return "Enter First Name";
		}
		if(!isValidFirstname(request.getUserDetailsInfo().getFirstname()))
			return "First letter should be uppercase";
		
		if(request.getUserDetailsInfo().getLastname()==null || (request.getUserDetailsInfo().getLastname()=="")) {
			return "Enter Last Name";
		}
		if(!isValidLastname(request.getUserDetailsInfo().getLastname()))
			return "First letter should be uppercase";
		if(request.getUserDetailsInfo().getMobileNumber()==null || (request.getUserDetailsInfo().getMobileNumber()=="")) {
			return "Enter Mobile Number";
			
		}
		if(!isValidMobileNumber(request.getUserDetailsInfo().getMobileNumber())) {
			return "Invalid Mobile Number";
		}
			
		if(request.getUserDetailsInfo().getPassword()==null || (request.getUserDetailsInfo().getPassword()=="")) {
			return "Enter Password";
		}
		
		if(!isValidPassword(request.getUserDetailsInfo().getPassword())) {
			return "Password must contain at least one number, one lowercase, one uppercase letter and one special character";
			
		}
		if(request.getUserDetailsInfo().getAddress()==null || (request.getUserDetailsInfo().getAddress()=="")) {
			return "Enter Address";
		}
		if(request.getUserDetailsInfo().getUsername()==null || (request.getUserDetailsInfo().getUsername()=="")) {
			return "Enter Username";
		}	
		return "Valid";
	}
	
	public static boolean isValidMobileNumber(String s) 
	{ 
	      

	    Pattern p = Pattern.compile("(0/91)?[7-9][0-9]{9}"); 
	    Matcher m = p.matcher(s); 
	    return (m.find() && m.group().equals(s)); 
	}

	public static boolean isValidPassword(String password) 
    { 
        String regex = "^(?=.*[0-9])"
                       + "(?=.*[a-z])(?=.*[A-Z])"
                       + "(?=.*[@#$%^&+=])"
                       + "(?=\\S+$).{8,20}$"; 
        Pattern p = Pattern.compile(regex); 
 
        if (password == null) { 
            return false; 
        } 

        Matcher m = p.matcher(password); 
        return m.matches(); 
    } 
	
	public static boolean isValidFirstname(String firstname) {
		
		if (firstname.charAt(0) >= 'A' && firstname.charAt(0) <= 'Z') 
	        return true; 
	    else
	        return false; 
	}
	
	public static boolean isValidLastname(String lastname) {
		
		if (lastname.charAt(0) >= 'A' && lastname.charAt(0) <= 'Z') 
	        return true; 
	    else
	        return false; 
	}
}
