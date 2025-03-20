package com.corejavaapp.main.controller;

import com.corejavaapp.main.service.EmployeeService;
import com.corejavaapp.main.utility.IDUtil;
import com.corejavaapp.main.model.Address;
import com.corejavaapp.main.model.Employee;

import java.util.List;
import java.util.Scanner;

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

	public void addEmployee() {

		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter the employee name:");
			String name = sc.next();
			System.out.println("Enter the employee branch:");
			String branch = sc.next();
			System.out.println("Enter the employee department:");
			String department = sc.next();
			System.out.println("Enter the employee salary:");
			double salary = sc.nextDouble();
			sc.nextLine();
			System.out.println("Enter the employee city:");
			String city = sc.next();
			System.out.println("Enter the  pincode:");
			String pincode = sc.next();

			Employee employee = new Employee(name, branch, department, salary);

			Address address = new Address(city, pincode);

			IDUtil idUtil = new IDUtil();

			int addressid = idUtil.getRandomId();
			int empid = idUtil.getRandomId();

			employee.setId(empid);
			address.setId(addressid);

			employee.setAddress(address);

			employeeService.addEmployee(employee);
		}

	}

	public void assignProjects() {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter the employee id: ");
			int emp_id = sc.nextInt();
			System.out.println("Enter the projedct id: ");
			int project_id = sc.nextInt();

			employeeService.assignProjects(emp_id, project_id);
		}

	}

}
