package com.evry.fs.payment.pms.client.service.mapper;

import org.springframework.stereotype.Component;

import com.evry.fs.payment.pms.ProjectDetailsType;
import com.evry.fs.payment.pms.client.model.Project;

@Component("projectServiceMapper")
public class ProjectServiceMapper {

	public Project projectDetailsTypeToProject(ProjectDetailsType projectDetails) {
		Project project = new Project();
		project.setProjectId(projectDetails.getProjectId());
		project.setProjectName(projectDetails.getProjectName());
		project.setProjectStatus(projectDetails.getProjectStatus());
		project.setEstimatedHrs(projectDetails.getEstimatedHrs());
		project.setLoggedHrs(projectDetails.getLoggedHrs());
		project.setRemainingHrs(projectDetails.getRemainingHrs());
		return project;
	}

	public ProjectDetailsType projectToProjectDetailsType(Project project) {
		ProjectDetailsType projectDetailsType = new ProjectDetailsType();
		projectDetailsType.setProjectId(project.getProjectId());
		projectDetailsType.setProjectName(project.getProjectName());
		projectDetailsType.setProjectStatus(project.getProjectStatus());
		projectDetailsType.setEstimatedHrs(project.getEstimatedHrs());
		projectDetailsType.setLoggedHrs(project.getLoggedHrs());
		projectDetailsType.setRemainingHrs(project.getRemainingHrs());
		return projectDetailsType;
	}

}
