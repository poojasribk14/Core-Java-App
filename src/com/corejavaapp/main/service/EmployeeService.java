package com.corejavaapp.main.service;

import java.util.List;
import java.util.stream.Stream;

import com.corejavaapp.main.model.Employee;
import com.corejavaapp.main.repository.EmployeeRepository;

public class EmployeeService {

	public List<Employee> getEmployee() {
		EmployeeRepository employeeRepository = new EmployeeRepository();
		List<Employee> empList = employeeRepository.getEmployeeList();
		return empList;
	}

	public List<Employee> filterEmployeeByBranch(List<Employee> empList, String ibranch) {

		Stream<Employee> empStream = empList.parallelStream();
		empStream = empStream.filter(e -> e.getBranch().equalsIgnoreCase(ibranch));
		empList = empStream.toList();

		return empList;
	}

	public List<Employee> filterEmployeeByDeptartment(List<Employee> empList, String idepartment) {

		Stream<Employee> empStream = empList.parallelStream();
		empStream = empStream.filter(e -> e.getDepartment().equalsIgnoreCase(idepartment));
		empList = empStream.toList();
		return empList;
	}

}
