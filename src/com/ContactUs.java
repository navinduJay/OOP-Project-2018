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


@WebServlet("/ContactUs")
public class ContactUs extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ContactUs() {
        super();
    
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		//setting up the content type
		response.setContentType("text/html");
		
		//catching 
		String name = request.getParameter("firstname");
		String lname = request.getParameter("lastname");
		String city = request.getParameter("city");
		String messagee = request.getParameter("message");
		
		
		//set up the database connection
		try
		{
			
			
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym&sportsmanagement", "root", "root");
		Statement st=  conn.createStatement();

		
		st.executeUpdate("insert into message_table(name,l_name,city,message)values('"+name+"','"+lname+"','"+city+"','"+messagee+"')");
		
		}
		catch(Exception e)
		{
		System.out.print(e);
		e.printStackTrace();
		}
		
		
	}

}
