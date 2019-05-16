<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PMS</title>
</head>
<body style="background-color:powderblue;">
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
	</div>
	<h4 align="center">Add New Employee</h1>
	<form action="./addEmployee" method="post">
		<table align="center">
			<table align="center">
			<tr><th>Employee Name : </th><td><input type="text" name="employeeName"/></td></tr>
			<tr><th>Password : </th><td><input type="password" name="password"/></td></tr>
			<tr><th>Location : </th><td><input type="text" name="location"/></td></tr>
			<tr><th>Access : </th><td><input type="text" name="access"/></td></tr>
			<tr><th>Project Id : </th><td><input type="text" name="projectId"/></td></tr>
			<tr><td><input type="submit" value="Add Employee"/></td>
			<td><input type="reset" value="Reset"/></td></tr>
		</table>
	</form>
</body>
</html>