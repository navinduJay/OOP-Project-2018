/*
package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DisplayProductsServlet")
public class DisplayProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DisplayProductsServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
	}


	protected  void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		
         response.setContentType("text/html");
         
         //DB connection
         try {
        	 
        	 Class.forName("com.mysql.jdbc.Driver");
        	 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym&sportsmanagement" , "root", "root");
        	 System.out.println("Connected to database.");
        	 
        	 
        	 String query = "select * from products";
        	 
        	 Statement st = con.createStatement();
        	 ResultSet rs = st.executeQuery(query);
        	 
        	 while(rs.next()) {
        		 
        		 int pid = rs.getInt("product_id");
        		 String category = rs.getString("product_cats");
        		 String brand = rs.getString("product_brand");
        		 String title = rs.getString("product_title");
        		 String price = rs.getString("product_price");
        		 
        		 System.out.println(pid);
        		 
        		 
        		 
        	 }
        	 
         }catch(Exception e) {
        	 
        	 System.out.println("Error");
         }
	}

}
*/