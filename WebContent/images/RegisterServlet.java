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


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public RegisterServlet() {
        super();
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String userName = request.getParameter("name");
		String userEmail= request.getParameter("email");
		String userPassword = request.getParameter("pass");
		String userTelephone= request.getParameter("phone");
		String userAddress= request.getParameter("address");
		
		RegisterBean bean = new RegisterBean();
		bean.setName(userName);
		bean.setEmail(userEmail);
		bean.setPassword(userPassword);
		bean.setPhone(userTelephone);
		bean.setAddress(userAddress);
		
		request.setAttribute("bean", bean);
		
		boolean comparePassword = bean.validatePassword();
		boolean passwordNull = bean.checkNullPass();
		boolean usernameNull = bean.checkNullUserID();
		
		
		
		if(comparePassword && passwordNull && usernameNull){
			RequestDispatcher rd=request.getRequestDispatcher("login-success.jsp");
			rd.forward(request, response);
			
			try
			{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym&sportsmanagement", "root", "root");
			java.sql.Statement st=  conn.createStatement();

			st.executeUpdate("insert into customer(customer_name,customer_email,customer_pass,customer_phone,customer_address)values('"+userName+"','"+userEmail+"','"+userPassword+"','"+userTelephone+"','"+userAddress+"')");
			System.out.println("Data is successfully inserted!");
			}
			catch(Exception e)
			{
			System.out.print(e);
			e.printStackTrace();
			}
			
			
		}
		else{
			RequestDispatcher rd=request.getRequestDispatcher("register-error.jsp");
			rd.forward(request, response);
		}
		

		
		
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}


}
