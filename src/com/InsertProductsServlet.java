package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


@WebServlet("/InsertProductsServlet")
public class InsertProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public InsertProductsServlet() {
        super();
     
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		String productCategory= request.getParameter("product_cats");
		String productBrand = request.getParameter("product_brand");
		String productTitle = request.getParameter("product_title");
		String productPrice= request.getParameter("product_price");
		
		//Setup database connection..
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym&sportsmanagement", "root", "root");
		java.sql.Statement st=  conn.createStatement();

		st.executeUpdate("insert into products(product_category,product_brand,product_title,product_price)values('"+productCategory+"','"+productBrand+"','"+productTitle+"','"+productPrice+"')");
		System.out.println("Data is successfully inserted!");
		}
		catch(Exception e)
		{
		System.out.print(e);
		e.printStackTrace();
		}
		//Redirects to the following page
		RequestDispatcher dispatch = request.getRequestDispatcher("insert_products.jsp");
        dispatch.forward(request, response);
	}

}
