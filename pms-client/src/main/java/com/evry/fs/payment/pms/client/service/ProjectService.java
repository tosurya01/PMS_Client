package com.evry.fs.payment.pms.client.service;

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
import com.evry.fs.payment.pms.ProjectDetailsType;
import com.evry.fs.payment.pms.UpdateProjectRequestType;
import com.evry.fs.payment.pms.UpdateProjectResponseType;
import com.evry.fs.payment.pms.client.model.Project;
import com.evry.fs.payment.pms.client.service.mapper.ProjectServiceMapper;
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
		for (ProjectDetailsType projectDetails : getAllProjectsResponseType.getProjectDetailsType()) {
			projects.add(projectServiceMapper.projectDetailsTypeToProject(projectDetails));
		}
		return projects;
	}

	public boolean deleteProject(int id) {
		DeleteProjectRequestType parameters = new DeleteProjectRequestType();
		parameters.setProjectId(id);
		DeleteProjectResponseType deleteProjectResponseType = projectServiceV191.deleteProject(parameters);
		return deleteProjectResponseType.isFlag();
	}

	public boolean updateProject(int id, String name) {
		UpdateProjectRequestType parameters = new UpdateProjectRequestType();
		parameters.setProjectId(id);
		parameters.setProjectName(name);
		UpdateProjectResponseType updateProjectResponseType = projectServiceV191.updateProject(parameters);
		return updateProjectResponseType.isFlag();
	}

	public Project getProjectInfo(int id) {
		GetProjectInfoRequestType parameters = new GetProjectInfoRequestType();
		parameters.setProjectId(id);
		GetProjectInfoResponseType getProjectInfoResponseType = projectServiceV191.getProjectInfo(parameters);
		ProjectDetailsType projectDetailsType = getProjectInfoResponseType.getProjectDetailsType();
		return projectServiceMapper.projectDetailsTypeToProject(projectDetailsType);
	}

	public boolean addProject(Project project) {
		AddProjectRequestType parameters = new AddProjectRequestType();
		parameters.setProjectDetailsType(projectServiceMapper.projectToProjectDetailsType(project));
		AddProjectResponseType addProjectResponseType = projectServiceV191.addProject(parameters);
		return addProjectResponseType.isFlag();
	}

}
