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
	</div><br/><hr/><br/>
	<h4 align="center">Update Employee Details</h1>
	<form action="./employeeEdit" method="post">
		<table align="center">
			<tr><th>Employee Name: </th><td><input type="text" name="employeeName"/></td></tr>
			<tr><th>Password: </th><td><input type="password" name="password"/></td></tr>
			<tr><th>Location: </th><td><input type="text" name="location"/></td></tr>
			<tr><td><input type="submit" value="Update"/></td>
			<td><input type="reset" value="Reset"/></td></tr>
		</table>
	</form>
</body>
</html>