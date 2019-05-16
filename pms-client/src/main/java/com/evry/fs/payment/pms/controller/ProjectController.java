package com.evry.fs.payment.pms.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.evry.fs.payment.ems.model.Employee;
import com.evry.fs.payment.pms.model.Project;
import com.evry.fs.payment.pms.service.ProjectService;

@Controller
public class ProjectController {
	@Autowired
	private ProjectService projectService;

	@PostMapping("/addProject")
	public ModelAndView addProject(@ModelAttribute Project project) {
		ModelAndView mav = new ModelAndView();
		boolean flag = projectService.addProject(project);
		if (flag) {
			mav.setViewName("projectsuccess");
		} else {
			mav.setViewName("projectfailure");
		}
		return mav;
	}

	@GetMapping("/getProjectInfo")
	public ModelAndView getProjectInfo(@RequestParam("projectId") long projectId) {
		ModelAndView mav = new ModelAndView();
		Project project = projectService.getProjectInfo(projectId);
		mav.setViewName("projectDetails");
		mav.addObject("projectId", project.getProjectId());
		mav.addObject("projectName", project.getProjectName());
		mav.addObject("projectStatus", project.getProjectStatus());
		mav.addObject("estimatedHrs", project.getEstimatedHrs());
		mav.addObject("loggedHrs", project.getLoggedHrs());
		mav.addObject("remainingHrs", project.getRemainingHrs());
		return mav;
	}

	@PostMapping("/updateProject")
	public ModelAndView updateProject(@ModelAttribute Project project) {
		ModelAndView mav = new ModelAndView();
		boolean flag = projectService.updateProject(project);
		if (flag) {
			mav.setViewName("projectsuccess");
		} else {
			mav.setViewName("projectfailure");
		}
		return mav;
	}

	@PostMapping("/deleteProject")
	public ModelAndView deleteProject(@RequestParam("projectId") long projectId) {
		ModelAndView mav = new ModelAndView();
		boolean flag = projectService.deleteProject(projectId);
		if (flag) {
			mav.setViewName("projectsuccess");
		} else {
			mav.setViewName("projectfailure");
		}
		return mav;
	}

	@GetMapping("/viewAllProjects")
	public ModelAndView getAllProjects() {
		ModelAndView mav = new ModelAndView();
		List<Project> porjects = projectService.getAllProjects();
		mav.setViewName("allProjects");
		mav.addObject("projects", porjects);
		return mav;
	}
}
