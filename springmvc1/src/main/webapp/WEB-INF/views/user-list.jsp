<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%

	String username2 = (String)session.getAttribute("username1");
	if(username2==null){
		
		response.sendRedirect("/WEB_INF/views/index.jsp");
	} 
	String status = request.getParameter("status");
	if(status!=null){
		if(status.equals("false")){
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
	<div align="center">
		<table border="1" cellpadding="5">
			<caption>
				<h2>List of Users</h2>
			</caption>
			<tr>
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
			<c:forEach var="employeeInfoBean" items="${listUser}">
				<tr>
					<td><c:out value="${employeeInfoBean.id}" /></td>
					<td><c:out value="${employeeInfoBean.name}" /></td>
					<td><c:out value="${employeeInfoBean.email}" /></td>
					<td><c:out value="${employeeInfoBean.dateofbirth}" /></td>
					<td><c:out value="${employeeInfoBean.dateofjoining}" /></td>
					<td><c:out value="${employeeInfoBean.deptID}" /></td>
					<td><c:out value="${employeeInfoBean.designation}" /></td>
					<td><c:out value="${employeeInfoBean.salary}" /></td>
					<td><c:out value="${employeeInfoBean.managerID}" /></td>
					<td><c:out value="${employeeInfoBean.mobileNo}" /></td>
					<td><c:out value="${employeeInfoBean.password}" /></td>
					<td><a href="./updateEmployeeForm?id=<c:out value='${employeeInfoBean.id}' />">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="./deleteUser?id=<c:out value='${employeeInfoBean.id}' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>