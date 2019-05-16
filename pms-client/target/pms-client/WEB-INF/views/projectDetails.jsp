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
	</div>
	<div align="center">
		<a href="./addProject.jsp">Add Project</a>&nbsp;
		<a href="./updateProject.jsp">Update Project</a>&nbsp;
		<a href="./deleteProject.jsp">Delete Project</a>&nbsp;
		<a href="./viewProject.jsp">View Project</a>&nbsp;
		<a href="./viewAllProjects">View All Projects</a>&nbsp;
	</div><br/><br/><br/>
	<div align="center">
	
	<table border="1">
	<tr>Project Details</tr>
	<tr><th>Project ID :</th><td>${projectId}</td></tr>
	<tr><th>Project Name :</th><td>${projectName}</td></tr>
	<tr><th>Project Status :</th><td>${projectStatus}</td></tr>
	<tr><th>Estimated Hrs :</th><td>${estimatedHrs}</td></tr>
	<tr><th>Logged Hrs :</th><td>${loggedHrs}</td></tr>
	<tr><th>Remaining Hrs :</th><td>${remainingHrs}</td></tr>
	</table>
	</div>
</body>
</html>