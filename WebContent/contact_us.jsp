
<!DOCTYPE html>
<html>
<head>

<style>

</style>
<link rel = "stylesheet" href = "style.css">
<link rel = "stylesheet" href = "admin_style.css">
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


<h1 align = "center">Contact Us </h1>

<div class="container">

	
	<form  action ="ContactUs" method = "post">
		
			<table height = "auto" width = "500" align = "center" bgcolor = "silver">
			
				<tr  align = "center">
				<td bgcolor = "grey" colspan =  "6"><h2>please submit this form</h2></td></tr>
				<tr>
					<td align = "right">Name: </td>
					<td><input type = "text" name = "firstname" required></td>
				</tr>
				
				<tr>
					<td align = "right">Last Name: </td>
					<td><input type = "text" name = "lastname" required></td>
				</tr>
				<tr>
					<td align = "right">City: </td>
					<td><input type = "text" name = "city" required></td>
				</tr>
				<tr>
					<td align = "right">Message: </td>
					<td><input type = "text" name = "message" required></td>
				</tr>
				
				<br />
				
				<tr align = "center">
				
					<td colspan = "5"><input type = "submit" name = "inquire" value = " Send"></td> 
				</tr>
					
					
			
				
			
			</table>
		
		
		</form>
	


</div>
<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>

</body>
</html>
	


