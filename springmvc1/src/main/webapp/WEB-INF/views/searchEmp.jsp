<%@page import="com.tyss.springmvc1.beans.EmployeeInfoBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<% EmployeeInfoBean employeeInfoBean = (EmployeeInfoBean) request.getAttribute("employee1");
	String errMsg = (String) request.getAttribute("errMsg");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body><%
		String username2 = (String) session.getAttribute("username1");
		if (username2 == null) {

			response.sendRedirect("index.jsp");
		}
		String status = request.getParameter("status");
		if (status != null) {
			if (status.equals("false")) {
				out.print("Invalid Credentials");
			}
		}
	%>
<center>
		<h1>User Management</h1>
		<h2>
		<a href="http://localhost:8080/springmvc1/getEmployeeForm">Search Employee</a> &nbsp;&nbsp;&nbsp; 
			<a href="http://localhost:8080/springmvc1/addEmployeeForm">Add New Employee</a> &nbsp;&nbsp;&nbsp; <a href="http://localhost:8080/springmvc1/listEmployee">List
				All Users</a> &nbsp;&nbsp;&nbsp; <a href="http://localhost:8080/springmvc1/logout.jsp">Logout</a>

		</h2>
	</center>
	<fieldset>
		<legend>Search Employee Record</legend>
		<form action="./getEmployee" method="get">
			Employee ID : <input type="text" name="id" required="required">
			<br><br>
			<input type="submit" value="Search"> 
		</form>
	</fieldset>
	
	<% if (errMsg != null && !errMsg.isEmpty()) { %>
		<h3 style="color: red;"><%=errMsg %></h3>
	<% } %>
	
	<% if (employeeInfoBean != null) { %>
	<br><br>
	<div align="center">
		<table border="1" style="width: 70%;">
			<tr style="background: navy; color: white;">
				<th>ID</th>
				<th>Name</th>
				<th>Email</th>
				<th>date of birth</th>
				<th>date of joining</th>
				<th>deptID</th>
				<th>designation</th>
				<th>salary</th>
				<th>manager ID</th>
				<th>mobile No</th>
				<th>password</th>
			</tr>
			<tr>
				<td><%=employeeInfoBean.getId()%></td>
				<td><%=employeeInfoBean.getName()%></td>
				<td><%=employeeInfoBean.getEmail()%></td>
				<td><%=employeeInfoBean.getDateofbirth()%></td>
				<td><%=employeeInfoBean.getDateofjoining()%></td>
				<td><%=employeeInfoBean.getDeptID()%></td>
				<td><%=employeeInfoBean.getDesignation()%></td>
				<td><%=employeeInfoBean.getSalary()%></td>
				<td><%=employeeInfoBean.getManagerID()%></td>
				<td><%=employeeInfoBean.getMobileNo()%></td>
				<td><%=employeeInfoBean.getPassword()%></td>
			</tr>
		</table>
	</div>

	<% } %>
	
</body>
</html>
















