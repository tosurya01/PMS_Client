package com.evry.fs.payment.pms.client.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.evry.fs.payment.pms.client.model.Project;
import com.evry.fs.payment.pms.client.service.ProjectService;

//@Controller
@RestController
public class ProjectController {
	@Autowired
	private ProjectService projectService;

	@Autowired
	private ModelAndView mv;

	@PostMapping("/addProject")
	public boolean addProject(@RequestBody Project project) {
		return projectService.addProject(project);
	}

	@GetMapping("/getProjectInfo/{id}")
	public Project getProjectInfo(@PathVariable("id") int id) {
		return projectService.getProjectInfo(id);
	}

	@PostMapping("/updateProject/{id}/{name}")
	public boolean updateProject(@PathVariable("id") int id, @PathVariable("name") String name) {
		return projectService.updateProject(id, name);
	}

	@DeleteMapping("/deleteProject/{id}")
	public boolean deleteProject(@PathVariable("id") int id) {
		return projectService.deleteProject(id);
	}

//	@GetMapping("/getAllProjects")
//	public String getAllProjects(Model model) {
//		//model.addAllAttributes(projectService.getAllProjects());
//		model.addAttribute("name", projectService.getAllProjects().get(0).getProjectName());
//		 //mv.setViewName("allProjects");
//		
//		return "allProjects";
//	}
	@GetMapping("/getAllProjects")
	public List<Project> getAllProjects() {
		return projectService.getAllProjects();
	}
}
