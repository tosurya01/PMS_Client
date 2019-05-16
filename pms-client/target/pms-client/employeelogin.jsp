<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Login</title>
</head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PMS</title>
</head>
<body style="background-color: powderblue;">
	<div align="center">
		<h1 align="center">Project Management System</h1>
		<a href="./index.jsp">Home</a>&nbsp;
		<a href="./adminlogin.jsp">AdminLogin</a>&nbsp;
		<a href="./employeelogin.jsp">EmployeeLogin</a>&nbsp;
	</div>
	<form action="./employeelogin">
		<table align="center">
			<tr><th>Employee ID: </th><td><input type="text" name="employeeId"/></td></tr>
			<tr><th>Password: </th><td><input type="password" name="password"/></td></tr>
			<tr><td><input type="submit" value="Login"/></td>
			<td><input type="reset" value="Reset"/></td></tr>
		</table>
	</form>
</body>
</html>