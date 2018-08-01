<%@page import="com.DisplayProductsServlet"%>
<%@page import = "java.sql.DriverManager" %>
<%@page import = "java.sql.ResultSet" %>
<%@page import = "java.sql.Connection" %>
<%@page import = "java.sql.Statement" %>
<%@page import = "java.sql.*" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
a.login  {
   background-color: white;
  color: black;
  padding: 1em 1.5em;
  text-decoration: none;
  text-transform: uppercase;
}

a.login :hover {
  background-color: darkorange;
}

a.login:active {
  background-color: darkorange;
}

a.login:hover, a.login:active {
    background-color: darkorange;
}
a.login:visited {
  background-color: #ccc;
}

</style>
<link rel = "stylesheet" href = "style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>
<body>

	
	<div class = "main_wrapper">
	
		<div class = "header_wrapper">
	
			<img src = "images/logo.jpg" id = "logo">
			<img src = "images/banner3.jpg" id = "banner">
			
			
		
		</div>
		
		<div id = "menubar">
		
			<ul id = "menu">
			<li><a href="index.jsp">Home</a></li>
			
			
			<li><a href="register.jsp">Sign Up</a></li>
			<li><a href="contact_us.jsp">Contact Us</a></li>
			
			</ul>
			
			<div id = "form">
				
					
				<a class=  "login" href = "login.jsp">Login</a>
				
				
			</div>
			
		
		</div>
		
		
		
		<div class = "content_wrapper">
		
			<div id = "sidebar">
			
				<div id = "siderbar_title">Categories</div>
				
					<ul id = "categories">
					
			
					
						<%try{
								
								Class.forName("com.mysql.jdbc.Driver");
								Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym&sportsmanagement" , "root", "root");%>			
								
						
					
								<% Statement st = con.createStatement();%>
								
								<%ResultSet rs = st.executeQuery("select * from categories");%>
								
						
								<% while(rs.next()) {%>
									
									<% int category_id = rs.getInt("category_id"); %>
									<% String category_title = rs.getString("category_title");%>
									
									<li><a href="#"><%=category_title%></a></li>
									
								<% } 
		
		
	
		
		
								}catch(Exception e){
									
									System.out.println("Failed");
									System.out.println(e);
									
									
								}%>
					
					
					
					
					</ul>
					<div id = "siderbar_title">Brands</div>
					<ul id = "categories">
					
						<li><a href ="#">Teleseen</a></li>
						<li><a href ="#">Eser</a></li>
						<li><a href ="#">Nike</a></li>
						<li><a href ="#">Under Armour</a></li>
						<li><a href ="#">Reebok</a></li>
					
					
					
					</ul>
					
			
			
			</div>
			<div id = "content_area">
			
			
				<h2></h2>
					
			
			</div>
			<div id = "footer"><h4 style="text-align:center;padding-top:30px;font-family:serif;">&copy; 2018 OOP Project . All Rights Reserved</h4></div>
		
		</div>
		
		 

	
	
	
	
	</div>

</body>




</body>
</html>