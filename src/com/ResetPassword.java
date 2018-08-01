package com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ResetPassword")
public class ResetPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ResetPassword() {
        super();
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		String userEmail = request.getParameter("userMail");
		String userNewPassword = request.getParameter("newPass");
		
		//DB connection
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym&sportsmanagement", "root", "root");
			Statement st = conn.createStatement();
			
			st.executeUpdate("update customer set customer_pass =('"+userNewPassword+"') where email = ('"+userEmail+"')");
			System.out.println("Data is updated successfully!");
			
			
		}catch(Exception e) {
			
			System.out.print(e);
			e.printStackTrace();
			
		}
		
		
	}

}
