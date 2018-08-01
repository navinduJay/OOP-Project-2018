package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//Model interface of customer
public interface RegisterBean {


	
	//method to check whether the password is empty
	public boolean checkNullPass();
		
	//method to check whether the user-name is empty
	public boolean checkNullUserID();

	//method to validate password	
	public boolean validatePassword(); 
	
	//method to validate username
	public boolean validateUsername();


	
	
}
