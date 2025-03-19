package com.corejavaapp.main.model;

public class Employee {
	private int id;
	private String name;
	private String branch;
	private String department;
	private double salary;

	public Employee() {
	}

	public Employee(int id, String name, String branch, String department, double salary) {
		this.id = id;
		this.name = name;
		this.branch = branch;
		this.department = department;
		this.salary = salary;
	}

	public Employee(String name, String branch, String department, double salary) {
		this.name = name;
		this.branch = branch;
		this.department = department;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", branch=" + branch + ", department=" + department
				+ ", salary=" + salary + "]";
	}

}
