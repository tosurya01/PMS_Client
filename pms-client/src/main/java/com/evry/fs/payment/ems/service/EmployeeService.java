package com.evry.fs.payment.ems.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evry.fs.payment.ems.AddEmployeeRequestType;
import com.evry.fs.payment.ems.AddEmployeeResponseType;
import com.evry.fs.payment.ems.CheckLoginRequestType;
import com.evry.fs.payment.ems.CheckLoginResponseType;
import com.evry.fs.payment.ems.DeleteEmployeeRequestType;
import com.evry.fs.payment.ems.DeleteEmployeeResponseType;
import com.evry.fs.payment.ems.EmployeeType;
import com.evry.fs.payment.ems.GetAllEmployeesInProjectRequestType;
import com.evry.fs.payment.ems.GetAllEmployeesInProjectResponseType;
import com.evry.fs.payment.ems.GetAllEmployeesRequestType;
import com.evry.fs.payment.ems.GetAllEmployeesResponseType;
import com.evry.fs.payment.ems.GetAllFreeResourcesRequestType;
import com.evry.fs.payment.ems.GetAllFreeResourcesResponseType;
import com.evry.fs.payment.ems.GetEmployeeInfoRequestType;
import com.evry.fs.payment.ems.GetEmployeeInfoResponseType;
import com.evry.fs.payment.ems.UpdateEmployeeRequestType;
import com.evry.fs.payment.ems.UpdateEmployeeResponseType;
import com.evry.fs.payment.ems.mapper.EmployeeServiceMapper;
import com.evry.fs.payment.ems.model.Employee;
import com.evry.fs.payment.ems.srv.ws.service.EmployeeServiceV191;
import com.evry.fs.payment.ems.srv.ws.service.EmployeeServiceV191ImplService;

@Service("employeeService")
public class EmployeeService {
	@Autowired
	EmployeeServiceMapper employeeServiceMapper;
	EmployeeServiceV191ImplService employeeServiceV191ImplService = new EmployeeServiceV191ImplService();
	EmployeeServiceV191 employeeServiceV191 = employeeServiceV191ImplService.getEmployeeServiceV191ImplPort();

	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<Employee>();
		GetAllEmployeesRequestType parameters = new GetAllEmployeesRequestType();
		GetAllEmployeesResponseType getAllEmployeesResponseType = employeeServiceV191.getAllEmployees(parameters);
		for (EmployeeType employeeDetails : getAllEmployeesResponseType.getEmployeeType()) {
			employees.add(employeeServiceMapper.employeeTypeToEmployee(employeeDetails));
		}
		return employees;
	}

	public boolean deleteEmployee(long id) {
		DeleteEmployeeRequestType parameters = new DeleteEmployeeRequestType();
		parameters.setEmployeeId(id);
		DeleteEmployeeResponseType deleteEmployeeResponseType = employeeServiceV191.deleteEmployee(parameters);
		return deleteEmployeeResponseType.isFlag();
	}

	public boolean updateEmployee(Employee employee) {
		UpdateEmployeeRequestType parameters = new UpdateEmployeeRequestType();
		parameters.setEmployeeId(employee.getEmployeeId());
		parameters.setEmployeeName(employee.getEmployeeName());
		parameters.setPassword(employee.getPassword());
		parameters.setLocation(employee.getLocation());
		parameters.setProjectId(employee.getProjectId());
		UpdateEmployeeResponseType updateEmployeeResponseType = employeeServiceV191.updateEmployee(parameters);
		return updateEmployeeResponseType.isFlag();
	}

	public Employee getEmployeeInfo(long id) {
		GetEmployeeInfoRequestType parameters = new GetEmployeeInfoRequestType();
		parameters.setEmployeeId(id);
		GetEmployeeInfoResponseType getEmployeeInfoResponseType = employeeServiceV191.getEmployeeInfo(parameters);
		EmployeeType employeeType = getEmployeeInfoResponseType.getEmployeeType();
		return employeeServiceMapper.employeeTypeToEmployee(employeeType);
	}

	public boolean addEmployee(Employee employee) {
		AddEmployeeRequestType parameters = new AddEmployeeRequestType();
		parameters.setEmployeeName(employee.getEmployeeName());
		parameters.setPassword(employee.getPassword());
		parameters.setLocation(employee.getLocation());
		parameters.setAccess(employee.getAccess());
		parameters.setProjectId(employee.getProjectId());
		AddEmployeeResponseType addEmployeeResponseType = employeeServiceV191.addEmployee(parameters);
		return addEmployeeResponseType.isFlag();
	}

	public long checkLogin(long employeeId, String password) {
		CheckLoginRequestType parameters = new CheckLoginRequestType();
		parameters.setEmployeeId(employeeId);
		parameters.setPassword(password);
		CheckLoginResponseType checkLoginResponseType = employeeServiceV191.checkLogin(parameters);
		return checkLoginResponseType.getAccess();
	}

	public List<Employee> getAllEmployeesInProject(long id) {
		List<Employee> employees = new ArrayList<Employee>();
		GetAllEmployeesInProjectRequestType parameters = new GetAllEmployeesInProjectRequestType();
		parameters.setProjectId(id);
		GetAllEmployeesInProjectResponseType getAllEmployeesInProjectResponseType = employeeServiceV191
				.getAllEmployeesInProject(parameters);
		for (EmployeeType employeeType : getAllEmployeesInProjectResponseType.getEmployeeType()) {
			employees.add(employeeServiceMapper.employeeTypeToEmployee(employeeType));
		}
		return employees;
	}

	public List<Employee> getAllFreeResources() {
		List<Employee> employees = new ArrayList<Employee>();
		GetAllFreeResourcesRequestType parameters = new GetAllFreeResourcesRequestType();
		GetAllFreeResourcesResponseType getAllFreeResourcesResponseType = employeeServiceV191
				.getAllFreeResources(parameters);
		for (EmployeeType employeeType : getAllFreeResourcesResponseType.getEmployeeType()) {
			employees.add(employeeServiceMapper.employeeTypeToEmployee(employeeType));
		}
		return employees;
	}
}
