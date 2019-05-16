<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color: powderblue;">
	<div align="center">
		<h1 align="center">Project Management System</h1>
		<a href="./projectInfo.jsp">Project Details</a>&nbsp;
		<a href="./employeeInfo.jsp">Employee Details</a>&nbsp;
		<a href="./logout">Logout</a>&nbsp;
	</div><br/>
	<hr/><br/>
	<div align="center">
		<a href="./addEmployee.jsp">Add Employee</a>&nbsp;
		<a href="./updateEmployee.jsp">Update Employee</a>&nbsp;
		<a href="./deleteEmployee.jsp">Delete Employee</a>&nbsp;
		<a href="./viewEmployee.jsp">View Employee</a>&nbsp;
		<a href="./viewAllEmployees">View All Employees</a>&nbsp;
	</div><br/><br/><br/>
	<div align="center">
	
	<table border="1">
	<tr>Employee Details</tr>
	<tr><th>Employee Id</th><th>Project Id</th><th>Name</th><th>Password</th><th>Location</th><th>Access</th></tr>
	<tr><td>${id}</td><td>${projectId}</td><td>${name}</td><td>${password}</td><td>${location}</td><td>${access}</td></tr>
	</table>
	</div>
</body>
</html>