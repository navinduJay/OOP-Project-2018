<%@page import="com.RegisterBean"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Products</title>
<link rel = "stylesheet" href = "style.css">
</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
<div class = "main_wrapper">
	
		
		
		<div id = "menubar">
		
			<ul id = "menu">
			<li><a href="index.jsp">Home</a></li>
			
			<li><a href="contact_us.jsp">Contact Us</a></li>
			
			
			
			
			</ul>
			
			
		
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




<div id = "content_area">

			<div id = "form">
				
					
				<a class=  "logout" href = "index.jsp"></a>
				
				
			</div>

			
			<div id = "shopping_cart">
			
				<span style="float:right;font-size:18px;padding:5px;line-height:40px;">
				
				
				
					
						
							
							
																			
					 
				 <b style="color:yellow;padding-right:630px;">Available Products</h4></b>
				<a href="cart.jsp"></a>
				
				
				</span>
			
			</div>
			
					<div id = "products_box">
					
							 
        				 
        				<div id ='single_product'> 
        				 
        				 		<%try{
								
								Class.forName("com.mysql.jdbc.Driver");
								Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym&sportsmanagement" , "root", "root");%>
								
								<% Statement st = con.createStatement();%>
								
								<% ResultSet rs = st.executeQuery("select * from products");%>
								
								<% while(rs.next()) {%>
								
									<% int product_id = rs.getInt("product_id"); %>
									<% String product_category = rs.getString("product_category");%>
									<% String product_brand = rs.getString("product_brand");%>
									<% String product_title = rs.getString("product_title");%>
									<% String product_price = rs.getString("product_price");%>
								
										<div id="single_product">
										
										
												<h3><%=product_title %></h3>
												<h3><%= "Rs." + product_price %></h3>
												<a href="index.jsp"><button style = "float:right">Details</button></a>
										
										</div>
								<% }
        				  		
								}catch(Exception e){
									
									System.out.println("Failed");
									System.out.println(e);
									
									
								}%>
        				</div>
					
					
					</div>
			</div>
			</div>
		


<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
</body>

</body>
</html>