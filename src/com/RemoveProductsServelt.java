package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/RemoveProductsServelt")
public class RemoveProductsServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public RemoveProductsServelt() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		
		response.setContentType("text/html");
	
		
		String productID= request.getParameter("product_id");
		int product = Integer.parseInt(productID);
		
		//building DB connection
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym&sportsmanagement", "root", "root");
			Statement st = conn.createStatement();
			
			st.executeUpdate("delete from products where product_id = ('"+product+"')");
			System.out.println("Data is deleted successfully!");
			
			
		}catch(Exception e) {
			
			System.out.print(e);
			e.printStackTrace();
			
		}
		//Re-directs to the following page
		RequestDispatcher dispatch = request.getRequestDispatcher("insert_products.jsp");
        dispatch.forward(request, response);
		
	}

}
