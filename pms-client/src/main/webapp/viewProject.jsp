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
		<a href="./addProject.jsp">Add Project</a>&nbsp;
		<a href="./updateProject.jsp">Update Project</a>&nbsp;
		<a href="./deleteProject.jsp">Delete Project</a>&nbsp;
		<a href="./viewProject.jsp">Project Info</a>&nbsp;
		<a href="./viewAllProjects">All Projects</a>&nbsp;
		<a href="./viewEmployeesInProject.jsp">Employees In A Project</a>&nbsp;
		<a href="./benchResources">Bench Resources</a>&nbsp;
	</div>
	<h4 align="center">View Project</h1>
	<form action="./getProjectInfo" method="get">
		<table align="center">
			<tr><th>Project Id : </th><td><input type="text" name="projectId"/></td></tr>
			<tr><td><input type="submit" value="Get Project"/></td>
			<td><input type="reset" value="Reset"/></td></tr>
		</table>
	</form>
</body>
</html>