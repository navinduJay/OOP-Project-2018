package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CustomerLogin")
public class CustomerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CustomerLogin() {
        super();
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		

		response.setContentType("text/html");
		
		String userName= request.getParameter("name");  
		String password = request.getParameter("pass"); 
		
		CustomerModel bean = new CustomerModel();
		bean.setName(userName);
		bean.setPassword(password);
		request.setAttribute("bean", bean);
		
		boolean status1 = bean.checkNullUserID();
		boolean status2 = bean.checkNullPass();
		
		String dbName = null;
		String dbPassword = null;
		
		
		
		if(status1 && status2){
			
		
			try {
			
				String sql = ("select * from customer where customer_name=? and customer_pass=?");
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym&sportsmanagement", "root", "root");
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, userName);
				ps.setString(2, password);
				ResultSet rs = ps.executeQuery();
				
				
				while(rs.next()) {
					
					dbName = rs.getString("customer_name");
					dbPassword = rs.getString("customer_pass");
					
				}
				if(userName.equals(dbName) && password.equals(dbPassword)) {
					

					RequestDispatcher rd=request.getRequestDispatcher("login-success.jsp");
					rd.include(request, response);
					
				
			}else {
			
				RequestDispatcher rd=request.getRequestDispatcher("customer-login-error-invalid.jsp");
				rd.include(request, response);
			}
				
			}catch(SQLException | ClassNotFoundException e) {
			
				System.out.print(e);
			
			}
		
		}
		else {
			
				RequestDispatcher rd=request.getRequestDispatcher("customer-login-error-null.jsp");
				rd.include(request, response);
		}
		
	}
	
}