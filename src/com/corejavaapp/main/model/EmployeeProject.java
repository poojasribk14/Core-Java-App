package com.corejavaapp.main.model;

import java.time.LocalDate;

public class EmployeeProject {

	private int id;
	private LocalDate dateOfAssign;

	public EmployeeProject() {
	}

	public EmployeeProject(int id, LocalDate dateOfAssign) {
		super();
		this.id = id;
		this.dateOfAssign = dateOfAssign;
	}

	public EmployeeProject(LocalDate dateOfAssign) {
		super();
		this.dateOfAssign = dateOfAssign;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDateOfAssign() {
		return dateOfAssign;
	}

	public void setDateOfAssign(LocalDate dateOfAssign) {
		this.dateOfAssign = dateOfAssign;
	}

	@Override
	public String toString() {
		return "EmployeeProject [id=" + id + ", dateOfAssign=" + dateOfAssign + "]";
	}

}
