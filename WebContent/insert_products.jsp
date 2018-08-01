<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert Products</title>
</head>

  <body style="background-color: darkgrey;">

	<form action="InsertProductsServlet" method="post">

		<table style="background-color: orange;" align="center" width="700" border="2" height="150">
			<tr align="center">
				<td colspan="2"><h2 style="font-family: verdana;">Insert Product</h2></td>
			</tr>
			<tr>
				<td align="right">Product Title:</td>
				<td><input type="text" name="product_title" size="50"></td>

			</tr>
			<tr>
				<td align="right">Product Category:</td>
				<td><select name="product_cats" style="width: 150px">

						<option>Select a category</option>


						<%
							try {

								Class.forName("com.mysql.jdbc.Driver");
								Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym&sportsmanagement", "root",	"root");
						%>

						<%
							Statement st = con.createStatement();
						%>

						<%
							ResultSet rs = st.executeQuery("select * from categories");
						%>

						<%
							while (rs.next()) {
						%>

						<%
							int category_id = rs.getInt("category_id");
						%>
						<%
							String category_title = rs.getString("category_title");
						%>

						<option value="<%=category_title%>"><%=category_title%>
						</option>

						<%
							}

							} catch (Exception e) {

								System.out.println("Failed to insert");
								System.out.println(e);

							}
						%>
				</td>

			</tr>
			<tr>
				<td align="right">Product Brand:</td>
				<td><select name="product_brand" style="width: 150px" required>

						<option>Select a brand
							</optin>

							<%
								try {

									Class.forName("com.mysql.jdbc.Driver");
									Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym&sportsmanagement", "root","root");
							%>

							<%
								Statement st = con.createStatement();
							%>

							<%
								ResultSet rs = st.executeQuery("select * from brands");
							%>

							<%
								while (rs.next()) {
							%>

							<%
								int brand_id = rs.getInt("brand_id");
							%>
							<%
								String brand_title = rs.getString("brand_title");
							%>
						
						<option value="<%=brand_title%>"><%=brand_title%>
						</option>

						<%
							}

							} catch (Exception e) {

								System.out.println("Failed to insert");
								System.out.println(e);

							}
						%>

				</select></td>


			</tr>

			<td align="right">Product Price:</td>
			<td><input type="text" name="product_price"></td>
			</tr>
			<tr>
				<td style="float: left;"><input type="submit" name="button"
					value="Insert"></td>
			</tr>
		</table>
	</form>
	<br />
	<br />
	<br />


	<form action="RemoveProductsServelt" method="post">
		<table style="background-color: orange;" align="center" width="700"
			border="2" height="150">
			<tr align="center">
				<td colspan="2"><h2 style="font-family: verdana;">Remove
						Product</h2></td>
			</tr>
			<tr>
				<td align="right">Product ID:</td>
				<td><input type="text" name="product_id" size="50" required></td>
			</tr>
			<tr>
				<td style="float: left;"><input type="submit"
					name="button_remove" value="Remove"></td>
			</tr>
		</table>
	</form>
</body>
</html>






