<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
input[type=text], select {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
}

input[type=submit] {
    width: 100%;
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

input[type=submit]:hover {
    background-color: #45a049;
}

div {
    border-radius: 5px;
    background-color: #f2f2f2;
    padding: 20px;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change your password</title>
<link rel = "stylesheet" href = "style.css">
<link rel = "stylesheet" href = "admin_style.css">
</head>
<body style="background-color: darkgrey;">


	<div>
  <form action="ResetPassword" method="post">
    <label for="fname">Email: </label>
    <input type="text" id="fname" name="userMail" placeholder="enter your email..." required>

    <label for="lname">New Passowrd: </label>
    <input type="text" id="lname" name="newPass" placeholder="enter your new password..." required>
    
     <input type="submit" value="Change">
  </form>
	</div>
	


</body>
</html>