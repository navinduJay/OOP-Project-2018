package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SearchItemServlet")
public class SearchItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public SearchItemServlet() {
        super();
       
        
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		
		String userQuery = request.getParameter("searchItem");
		
		
		try {
			
			 
       	 Class.forName("com.mysql.jdbc.Driver");
       	 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym&sportsmanagement" , "root", "root");
       	 System.out.println("Connected to database.");
       	 
       	String query = "select * from products where product_category like '"+userQuery+"'";
   	 
	   	 Statement st = con.createStatement();
	   	 ResultSet rs = st.executeQuery(query);
   	 
		
	      
    	ArrayList arrayList = null;
    	 ArrayList productInfo = new ArrayList();
    	  
    	 
    	  
    	  while(rs.next()) {
    		  arrayList = new ArrayList();
    		  arrayList.add(rs.getString(1));
    		  arrayList.add(rs.getString(2));
    		 arrayList.add(rs.getString(3));
    		  
    		 boolean x = arrayList.add(rs.getString(4));
    		  
    		 if(x) {
    			 
    			 arrayList.add(rs.getString(4));
    			 
    		 }
    		
    		  
    		  
    		  productInfo.add(arrayList);    	  
    		  
    	  }
    	
    	 
    	  request.setAttribute("ProductInfo", productInfo);
    	  
    	  RequestDispatcher rd=request.getRequestDispatcher("login-success.jsp");
			rd.forward(request, response);
		}catch(Exception e) {
			
			System.out.println(e);
		}
		
		
		
	}

}
