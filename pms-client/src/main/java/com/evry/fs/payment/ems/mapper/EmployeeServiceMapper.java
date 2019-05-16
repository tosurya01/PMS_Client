package com.evry.fs.payment.ems.mapper;

import org.springframework.stereotype.Component;

import com.evry.fs.payment.ems.EmployeeType;
import com.evry.fs.payment.ems.model.Employee;

@Component("employeeServiceMapper")
public class EmployeeServiceMapper {

	public Employee employeeTypeToEmployee(EmployeeType employeeType) {
		Employee employee = new Employee();
		employee.setEmployeeId(employeeType.getEmployeeId());
		employee.setEmployeeName(employeeType.getEmployeeName());
		employee.setPassword(employeeType.getPassword());
		employee.setLocation(employeeType.getLocation());
		employee.setAccess(employeeType.getAccess());
		employee.setProjectId(employeeType.getProjectId());
		return employee;
	}

}
