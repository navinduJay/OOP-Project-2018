
<%@page import="com.RegisterBean"%>

<%@page import="java.util.*"%>

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

<link rel = "stylesheet" href = "style.css">
</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
<div class = "main_wrapper">
	
		
		
		<div id = "menubar">
		
			<ul id = "menu">
			<li><a href="index.jsp">Home</a></li>
			
			<li><a href="contact_us.jsp">Contact Us</a></li>
			<li><a href="all_products.jsp">All Products</a></li>
			
			
			
			
			</ul>
			
			
		
		</div>
		
		</div>




<!--  login success page -->






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
			
				<span style="float:left;font-size:18px;padding:5px;line-height:40px;">
				
				
				
					
						
						  	
								<%  RegisterBean bean2=(RegisterBean)request.getAttribute("bean");
								out.print("Welcome, "+ bean2.getName() + "!");%>
							 
							
																			
					 
				 <b style="color:yellow"> Search Our Products...</b> 
				<a href="cart.jsp"></a>
				
				
				</span>
				
	<table align= "right">
		<tr>
		<form action = "SearchItemServlet" method = "post">
			<td><input type="text" id="search-bar" placeholder="Search an item..." name = "searchItem"></td>	
			<td><input type ="submit" value = "Search"></td>
		</form>
		</tr>
		
		
	
	</table>
    
    
  </form>
			
			</div>
			
			<table width="700px" align="center" border = "1px solid black">
				<tr>
				<td colspan=8 align="center"
				style="background-color:ffeeff">
				<b>Products Table</b></td>
				</tr>
				<tr style="background-color:efefef;">
				<td><b>Product Category</b></td>
				<td><b>Product Brand</b></td>
				<td><b>Product Title</b></td>
				<td><b>Product Price</b></td>
				
				
				</tr>
				<%
				int count=0;
				String color = "#F9EBB3";
				
				
				if(request.getAttribute("ProductInfo")!=null)
				{
					
				 
				ArrayList al = (ArrayList)request.getAttribute("ProductInfo");
				Iterator itr = al.iterator();
				
				
				while(itr.hasNext()){
				
				if((count%2)==0){
				color = "#eeffee";
				}
				else{
				color = "#F9EBB3";
				}
				count++;
				ArrayList productInfo = (ArrayList)itr.next();
				%>
				<tr style="background-color:<%=color%>;">
				
				<td><%=productInfo.get(1)%></td>
				<td><%=productInfo.get(2)%></td>
				<td><%=productInfo.get(3)%></td>
				
				
				</tr>
				<%
				}
				}
				%>
				<%
				if(count==0){
				%>
				<tr>
				<td colspan=8 align="center"
				style="background-color:eeffee"><b>No Record</b></td>
				</tr>
				<%
				}
				%>
				</table>
					
			</div>
			
			
</div>
			
			
		


<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
</body>

</body>
</html>