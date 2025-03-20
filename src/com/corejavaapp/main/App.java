package com.corejavaapp.main;

import java.util.Scanner;
import com.corejavaapp.main.controller.EmployeeController;
import com.corejavaapp.main.controller.ProjectController;

public class App {
	public static void main(String[] args) {
		EmployeeController employeeController = new EmployeeController();
		ProjectController projectController = new ProjectController();
		try {
			Scanner sc = new Scanner(System.in);

			while (true) {
				System.out.println("------MENU--------");
				System.out.println("1. Fetch all employees");
				System.out.println("2. Filter by branch,department");
				System.out.println("3. Add an Employee");
				System.out.println("4. Assign Project to Employee:");
				System.out.println("0. To Exit");
				int input = sc.nextInt();
				switch (input) {
				case 1:
					employeeController.displayEmployeeRecord();
					break;

				case 2:
					while (true) {
						System.out.println("1. Filter by Branch");
						System.out.println("2. Filter by Department");
						System.out.println("0. To Exit");
						int op = sc.nextInt();

						if (op == 0) {
							break;
						}

						switch (op) {
						case 1:
							System.out.println("Enter branch name");
							employeeController.filterByBranch(sc.next());
							break;

						case 2:
							System.out.println("Enter department name");
							employeeController.filterByDepartment(sc.next());
							break;
						}
					}

					break;
				case 3:
					employeeController.addEmployee();
					System.out.println("Employee added to the database.");
					sc.nextLine();
					break;
				case 4:
					employeeController.displayEmployeeRecord();
					projectController.displayProjectRecord();
					employeeController.assignProjects();
					System.out.println("Project assigned to employee..");
					break;
				}

			}
		} catch (Exception e) {
			e.getMessage();
		}
	}
}
