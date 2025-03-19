package com.corejavaapp.main.controller;

import com.corejavaapp.main.service.EmployeeService;
import com.corejavaapp.main.model.Employee;

import java.util.List;

public class EmployeeController {

	EmployeeService employeeService = new EmployeeService();

	public void displayEmployeeRecord() {
		List<Employee> empList = employeeService.getEmployee();

		for (Employee e : empList) {
			System.out.println(e);
		}
	}

	public void filterByBranch(String ibranch) {

		List<Employee> empList = employeeService.getEmployee();
		empList = employeeService.filterEmployeeByBranch(empList, ibranch);

		for (Employee e : empList) {
			System.out.println(e);
		}
	}

	public void filterByDepartment(String idepartment) {

		List<Employee> empList = employeeService.getEmployee();
		empList = employeeService.filterEmployeeByDeptartment(empList, idepartment);

		for (Employee e : empList) {
			System.out.println(e);
		}
	}

}
