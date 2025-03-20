package com.corejavaapp.main.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

import com.corejavaapp.main.model.Employee;
import com.corejavaapp.main.model.EmployeeProject;
import com.corejavaapp.main.repository.EmployeeRepository;
import com.corejavaapp.main.utility.IDUtil;

public class EmployeeService {
	EmployeeRepository employeeRepository = new EmployeeRepository();

	public List<Employee> getEmployee() {

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

	public void addEmployee(Employee employee) {
		employeeRepository.addEmployee(employee);
	}

	public void assignProjects(int emp_id, int project_id) {

		IDUtil idUtil = new IDUtil();
		int id = idUtil.getRandomId();
		EmployeeProject employeeProject = new EmployeeProject();
		employeeProject.setId(id);
		employeeProject.setDateOfAssign(LocalDate.now());

		employeeRepository.assignProject(employeeProject, emp_id, project_id);
	}

}
