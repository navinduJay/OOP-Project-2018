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

@WebServlet("/AdminLogin")
abstract public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AdminLogin() {
        super();
     
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html");
		
		
		String adminUserID = request.getParameter("admin_username");
		String adminPass = request.getParameter("admin_pass");
		
		AdminModel adminLogin = new AdminModel();
		adminLogin.setAdmin_username(adminUserID);
		adminLogin.setAdmin_pass(adminPass);
		
		
		
		
		boolean status = adminLogin.validatePassword();
		boolean status2 = adminLogin.validateUsername();
		
		if((status) && (status2)){
			RequestDispatcher rd=request.getRequestDispatcher("insert_products.jsp");
			rd.forward(request, response);
			
			
			try
			{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym&sportsmanagement", "root", "root");
			Statement st=  conn.createStatement();

			
			st.executeUpdate("insert into adminpanel(adminUsername,adminPassword)values('"+adminUserID+"','"+adminPass+"')");
			System.out.println("successful!");
			}
			catch(Exception e)
			{
			System.out.print(e);
			e.printStackTrace();
			}
			
		}
		else{
			RequestDispatcher rd=request.getRequestDispatcher("admin-login-error.jsp");
			rd.forward(request, response);
		}
		

		
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}


}
