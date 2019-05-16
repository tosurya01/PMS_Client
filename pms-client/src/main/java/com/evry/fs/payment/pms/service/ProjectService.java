package com.evry.fs.payment.pms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evry.fs.payment.pms.AddProjectRequestType;
import com.evry.fs.payment.pms.AddProjectResponseType;
import com.evry.fs.payment.pms.DeleteProjectRequestType;
import com.evry.fs.payment.pms.DeleteProjectResponseType;
import com.evry.fs.payment.pms.GetAllProjectsRequestType;
import com.evry.fs.payment.pms.GetAllProjectsResponseType;
import com.evry.fs.payment.pms.GetProjectInfoRequestType;
import com.evry.fs.payment.pms.GetProjectInfoResponseType;
import com.evry.fs.payment.pms.ProjectType;
import com.evry.fs.payment.pms.UpdateProjectRequestType;
import com.evry.fs.payment.pms.UpdateProjectResponseType;
import com.evry.fs.payment.pms.mapper.ProjectServiceMapper;
import com.evry.fs.payment.pms.model.Project;
import com.evry.fs.payment.pms.srv.ws.service.ProjectServiceV191;
import com.evry.fs.payment.pms.srv.ws.service.ProjectServiceV191ImplService;

@Service("projectService")
public class ProjectService {
	@Autowired
	ProjectServiceMapper projectServiceMapper;
	ProjectServiceV191ImplService projectServiceV191ImplService = new ProjectServiceV191ImplService();
	ProjectServiceV191 projectServiceV191 = projectServiceV191ImplService.getProjectServiceV191ImplPort();

	public List<Project> getAllProjects() {
		List<Project> projects = new ArrayList<Project>();
		GetAllProjectsRequestType parameters = new GetAllProjectsRequestType();
		GetAllProjectsResponseType getAllProjectsResponseType = projectServiceV191.getAllProjects(parameters);
		for (ProjectType projectType : getAllProjectsResponseType.getProjectType()) {
			projects.add(projectServiceMapper.projectDetailsTypeToProject(projectType));
		}
		return projects;
	}

	public boolean deleteProject(long id) {
		DeleteProjectRequestType parameters = new DeleteProjectRequestType();
		parameters.setProjectId(id);
		DeleteProjectResponseType deleteProjectResponseType = projectServiceV191.deleteProject(parameters);
		return deleteProjectResponseType.isFlag();
	}

	public boolean updateProject(Project project) {
		UpdateProjectRequestType parameters = new UpdateProjectRequestType();
		parameters.setProjectId(project.getProjectId());
		parameters.setProjectName(project.getProjectName());
		parameters.setProjectStatus(project.getProjectStatus());
		parameters.setEstimatedHrs(project.getEstimatedHrs());
		parameters.setLoggedHrs(project.getLoggedHrs());
		parameters.setRemainingHrs(project.getRemainingHrs());
		UpdateProjectResponseType updateProjectResponseType = projectServiceV191.updateProject(parameters);
		return updateProjectResponseType.isFlag();
	}

	public Project getProjectInfo(long id) {
		GetProjectInfoRequestType parameters = new GetProjectInfoRequestType();
		parameters.setProjectId(id);
		GetProjectInfoResponseType getProjectInfoResponseType = projectServiceV191.getProjectInfo(parameters);
		ProjectType projectDetailsType = getProjectInfoResponseType.getProjectType();
		return projectServiceMapper.projectDetailsTypeToProject(projectDetailsType);
	}

	public boolean addProject(Project project) {
		AddProjectRequestType parameters = new AddProjectRequestType();
		parameters.setProjectName(project.getProjectName());
		parameters.setEstimatedHrs(project.getEstimatedHrs());
		parameters.setLoggedHrs(project.getLoggedHrs());
		parameters.setProjectStatus(project.getProjectStatus());
		parameters.setRemainingHrs(project.getRemainingHrs());
		AddProjectResponseType addProjectResponseType = projectServiceV191.addProject(parameters);
		return addProjectResponseType.isFlag();
	}

}
