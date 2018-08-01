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


@WebServlet("/RegisterServlet")
public abstract class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public RegisterServlet() {
        super();
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		response.setContentType("text/html");
		
		
		String userName = request.getParameter("name");
		String userEmail= request.getParameter("email");
		String userPassword = request.getParameter("pass");
		String userTelephone= request.getParameter("phone");
		String userAddress= request.getParameter("address");
		
		//Object of Customer model and initialising values that we receive from the user
		CustomerModel bean = new CustomerModel();
		bean.setName(userName);
		bean.setEmail(userEmail);
		bean.setPassword(userPassword);
		bean.setPhone(userTelephone);
		bean.setAddress(userAddress);
		
		//set attribute of request object can be used to set an attribute and can be used within JSP files to display information whenever we want.
		request.setAttribute("bean", bean);
		
		//Three boolean type variables to invoke the validation methods of the Register Bean interface
		boolean comparePassword = bean.validatePassword();
		boolean passwordNull = bean.checkNullPass();
		boolean usernameNull = bean.checkNullUserID();
		
		
		//if the following information satisfies , create the connection
		if(comparePassword && passwordNull && usernameNull){
			RequestDispatcher rd=request.getRequestDispatcher("login-success.jsp");
			rd.forward(request, response);
			
			
			try
			{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym&sportsmanagement", "root", "root");
			Statement st=  conn.createStatement();

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
			//else go to the following page
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
