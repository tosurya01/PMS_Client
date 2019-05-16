package com.evry.fs.payment.ems.controller;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.evry.fs.payment.ems.model.Employee;
import com.evry.fs.payment.ems.service.EmployeeService;
import com.evry.fs.payment.pms.model.Project;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private Employee employee;

	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();
		return mav;
	}

	@GetMapping("/employeelogin")
	public ModelAndView employeeLogin(@RequestParam("employeeId") long employeeId,
			@RequestParam("password") String password, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		long access = employeeService.checkLogin(employeeId, password);
		if (access == 0) {
			session.setAttribute("employeeId", employeeId);
			mav.setViewName("employee");
		} else {
			mav.setViewName("redirect:index.jsp");
		}

		return mav;
	}

	@GetMapping("/adminlogin")
	public ModelAndView adminLogin(@RequestParam("employeeId") long employeeId,
			@RequestParam("password") String password, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		long access = employeeService.checkLogin(employeeId, password);
		if (access == 1) {
			session.setAttribute("employeeId", employeeId);
			mav.setViewName("project");
		} else {
			mav.setViewName("redirect:index.jsp");
		}

		return mav;
	}

	@GetMapping("/employeeInfo")
	public ModelAndView getEmployeeInfo(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		long employeeId = (Long) session.getAttribute("employeeId");
		Employee employee = employeeService.getEmployeeInfo(employeeId);
		mav.setViewName("employeeresult");
		mav.addObject("id", employee.getEmployeeId());
		mav.addObject("projectId", employee.getProjectId());
		mav.addObject("password", employee.getPassword());
		mav.addObject("name", employee.getEmployeeName());
		mav.addObject("location", employee.getLocation());
		mav.addObject("access", employee.getAccess());
		return mav;
	}

	@PostMapping("/employeeEdit")
	public ModelAndView updateEmployee(HttpSession session, @ModelAttribute Employee employee) {
		employee.setEmployeeId((Long) session.getAttribute("employeeId"));
		ModelAndView mav = new ModelAndView();
		boolean flag = employeeService.updateEmployee(employee);
		mav.setViewName("updateemployeesuccess");
		return mav;
	}

	@GetMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		session.invalidate();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:index.jsp");
		return mav;
	}

	@PostMapping("/addEmployee")
	public ModelAndView addEmployee(@ModelAttribute Employee employee) {
		ModelAndView mav = new ModelAndView();
		boolean flag = employeeService.addEmployee(employee);
		if (flag) {
			mav.setViewName("ad_projectsuccess");
		} else {
			mav.setViewName("ad_projectfailure");
		}
		return mav;
	}

	@PostMapping("/deleteEmployee")
	public ModelAndView deleteEmployee(@RequestParam("employeeId") long employeeId) {
		ModelAndView mav = new ModelAndView();
		boolean flag = employeeService.deleteEmployee(employeeId);
		if (flag) {
			mav.setViewName("ad_projectsuccess");
		} else {
			mav.setViewName("ad_projectfailure");
		}
		return mav;
	}

	@PostMapping("/updateEmployee")
	public ModelAndView updateEmployee(@ModelAttribute Employee employee) {
		ModelAndView mav = new ModelAndView();
		boolean flag = employeeService.updateEmployee(employee);
		if (flag) {
			mav.setViewName("ad_projectsuccess");
		} else {
			mav.setViewName("ad_projectfailure");
		}
		return mav;
	}

	@GetMapping("/viewAllEmployees")
	public ModelAndView getAllEmployees() {
		ModelAndView mav = new ModelAndView();
		List<Employee> employees = employeeService.getAllEmployees();
		mav.setViewName("allEmployees");
		mav.addObject("employees", employees);
		return mav;
	}

	@GetMapping("/getEmployeeInfo")
	public ModelAndView getEmployeeInfo(@RequestParam("employeeId") long employeeId) {
		ModelAndView mav = new ModelAndView();
		Employee employee = employeeService.getEmployeeInfo(employeeId);
		mav.setViewName("ad_employeeresult");
		mav.addObject("id", employee.getEmployeeId());
		mav.addObject("password", employee.getPassword());
		mav.addObject("name", employee.getEmployeeName());
		mav.addObject("location", employee.getLocation());
		mav.addObject("access", employee.getAccess());
		mav.addObject("projectId", employee.getProjectId());
		return mav;
	}

	@GetMapping("/employeesInProject")
	public ModelAndView getAllEmployeesInProject(@RequestParam("projectId") long projectId) {
		ModelAndView mav = new ModelAndView();
		List<Employee> employees = employeeService.getAllEmployeesInProject(projectId);
		mav.setViewName("ad_allEmployees");
		mav.addObject("employees", employees);
		return mav;
	}

	@GetMapping("/benchResources")
	public ModelAndView getAllFreeResources() {
		ModelAndView mav = new ModelAndView();
		List<Employee> employees = employeeService.getAllFreeResources();
		mav.setViewName("ad_allEmployees");
		mav.addObject("employees", employees);
		return mav;
	}
}
