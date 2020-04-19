<%@page import="com.tyss.springmvc1.beans.EmployeeInfoBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<% EmployeeInfoBean employeeInfoBean = (EmployeeInfoBean) request.getAttribute("employee12");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<center>
		<h1>User Management</h1>
		<h2>
			<a href="http://localhost:8080/springmvc1/getEmployeeForm">Search
				Employee</a> &nbsp;&nbsp;&nbsp; <a href="http://localhost:8080/springmvc1/getEmployeeForm">Add New Employee</a>
			&nbsp;&nbsp;&nbsp; <a href="list">List All Users</a>
			&nbsp;&nbsp;&nbsp; <a
				href="http://localhost:8080/egproject21/logout.jsp">Logout</a>

		</h2>
	</center>
	<div align="center">
		<c:if test="${employeeInfoBean != null}">
			<form action="update" method="POST">
		</c:if>
		<c:if test="${employeeInfoBean == null}">
			<form action="./addEmployee" method="POST">
		</c:if>
		<table border="1" cellpadding="5">
			<caption>
				<h2>
					<c:if test="${employeeInfoBean != null}">
               Edit User
              </c:if>
					<c:if test="${employeeInfoBean == null}">
               Add New User
              </c:if>
				</h2>
			</caption>
			<c:if test="${employeeInfoBean != null}">
				<input type="hidden" name="id" value="<c:out value='${employeeInfoBean.id}' />" />
			</c:if>
			<tr>
				<th>User Name:</th>
				<td><input type="text" name="name" size="45"
					value="<c:out value='${employeeInfoBean.name}' />" /></td>
			</tr>
			<tr>
				<th>User email:</th>
				<td><input type="text" name="email" size="45"
					value="<c:out value='${employeeInfoBean.email}' />" /></td>
			</tr>
			<tr>
				<th>User date of birth:</th>
				<td><input type="text" name="dateofbirth" size="45"
					value="<c:out value='${employeeInfoBean.dateofbirth}' />" /></td>
			</tr>

			<tr>
				<th>User date of joining:</th>
				<td><input type="text" name="dateofjoining" size="45"
					value="<c:out value='${employeeInfoBean.dateofjoining}' />" /></td>
			</tr>
			<tr>
				<th>User dept ID:</th>
				<td><input type="text" name="deptID" size="45"
					value="<c:out value='${employeeInfoBean.deptID}' />" /></td>
			</tr>
			<tr>
				<th>User designation:</th>
				<td><input type="text" name="designation" size="45"
					value="<c:out value='${employeeInfoBean.designation}' />" /></td>
			</tr>
			<tr>
				<th>User salary:</th>
				<td><input type="text" name="salary" size="45"
					value="<c:out value='${employeeInfoBean.salary}' />" /></td>
			</tr>
			<tr>
				<th>User manager ID:</th>
				<td><input type="text" name="managerID" size="45"
					value="<c:out value='${employeeInfoBean.managerID}' />" /></td>
			</tr>
			<tr>
				<th>User mobile No:</th>
				<td><input type="text" name="mobileNo" size="45"
					value="<c:out value='${employeeInfoBean.mobileNo}' />" /></td>
			</tr>
			<tr>
				<th>User password:</th>
				<td><input type="text" name="password" size="45"
					value="<c:out value='${employeeInfoBean.password}' />" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Save" /></td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>