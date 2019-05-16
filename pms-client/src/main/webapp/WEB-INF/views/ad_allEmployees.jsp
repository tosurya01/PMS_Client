<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
		<a href="./addProject.jsp">Add Project</a>&nbsp;
		<a href="./updateProject.jsp">Update Project</a>&nbsp;
		<a href="./deleteProject.jsp">Delete Project</a>&nbsp;
		<a href="./viewProject.jsp">Project Info</a>&nbsp;
		<a href="./viewAllProjects">All Projects</a>&nbsp;
		<a href="./viewEmployeesInProject.jsp">Employees In A Project</a>&nbsp;
		<a href="./benchResources">Bench Resources</a>&nbsp;
	</div><br/>
	<div align="center">
	<h4>All Employee Details</h4>
	 <table border="1">
      <tr><th>Employee Id</th><th>Project Id</th><th>Name</th><th>Password</th><th>Location</th><th>Access</th></tr>
	<c:if test="${not empty employees}">
    <c:forEach items="${employees}" var="employees">
	<tr><td>${employees.employeeId}</td><td>${employees.projectId}</td><td>${employees.employeeName}</td><td>${employees.password}</td><td>${employees.location}</td><td>${employees.access}</td></tr>
</c:forEach>
</c:if>
</table>
	</div>
</body>
</html>