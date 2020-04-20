<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body style="text-align: Center;">
<%

	String username2 = (String)session.getAttribute("username1");
	if(username2!=null){
		
		response.sendRedirect("/springmvc1/listEmployee");
	}
	String status = request.getParameter("status");
	if(status!=null){
		if(status.equals("false")){
			out.print("Invalid Credentials");
		}
	}

%>
	<h1>Employee Management</h1>

	<form action="./loginprocess" method="post">
		
	<table align="center">
		<tr><td>Username: </td><td><input type ="text" name="username" /></td></tr>
		<tr><td>Password: </td><td><input type ="password" name="password" /></td></tr>
		<tr><td></td><td><input type ="submit" name="Login" /></td></tr>
	</form>
</body>
</html>