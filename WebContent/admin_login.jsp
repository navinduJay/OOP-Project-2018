<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administrator Login</title>
<link rel = "stylesheet" href = "style.css">
<link rel = "stylesheet" href = "admin_style.css">
</head>
<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
<jsp:include page="/WEB-INF/views/menubar.jsp"></jsp:include>
<body style="background-color: darkgrey;">

	<div id = "content_wrapper_admin">
	
	
		<div id = "content_area_admin">
		
	<form method="post" action="AdminLogin" >
	
		<table style="background-color: orange;" align="center" width="700" border="2" height="150">
		
			<tr align="center">
				<td colspan="2"><h2 style="font-family: verdana;">ADMIN LOGIN</h2></td>
			</tr>
			<tr>
				<td align="right">User name: </td>
				<td><input type="text" name="admin_username" size="50"></td>

			</tr>
			<tr>
				<td align="right">Password: </td>
				<td><input type="password" name="admin_pass" size="50"></td>

			</tr>
			<tr>
				
				<td><input type="submit" name="submit_admin" size="50" value = "Login"></td>

			</tr>
			
			
			</table>
			
			</form>
			
			</div>
			<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
			
			</div>
			


</body>
</html>