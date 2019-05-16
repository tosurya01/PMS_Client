package com.evry.fs.payment.pms.mapper;

import org.springframework.stereotype.Component;

import com.evry.fs.payment.pms.ProjectType;
import com.evry.fs.payment.pms.model.Project;

@Component("projectServiceMapper")
public class ProjectServiceMapper {

	public Project projectDetailsTypeToProject(ProjectType projectDetails) {
		Project project = new Project();
		project.setProjectId(projectDetails.getProjectId());
		project.setProjectName(projectDetails.getProjectName());
		project.setProjectStatus(projectDetails.getProjectStatus());
		project.setEstimatedHrs(projectDetails.getEstimatedHrs());
		project.setLoggedHrs(projectDetails.getLoggedHrs());
		project.setRemainingHrs(projectDetails.getRemainingHrs());
		return project;
	}


}
