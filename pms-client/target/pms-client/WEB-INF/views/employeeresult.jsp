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
		<a href="./employeeInfo">Profile</a>&nbsp;
		<a href="./employeeEdit.jsp">Edit Profile</a>&nbsp;
		<a href="./logout">Logout</a>&nbsp;
	</div><br/><br/><br/>
	<div align="center">
	
	<table border="1">
	<tr>Employee Details</tr>
	<tr><th>Employee Id</th><th>Password</th><th>Name</th><th>Location</th></tr>
	<tr><td>${id}</td><td>${password}</td><td>${name}</td><td>${location}</td></tr>
	</table>
	</div>
</body>
</html>