package com.corejavaapp.main.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.corejavaapp.main.model.Employee;
import com.corejavaapp.main.model.EmployeeProject;
import com.corejavaapp.main.utility.DBUtil;

public class EmployeeRepository {

	private String userDB = "root";
	private String pwdDB = "Pooja@14";
	private String url = "jdbc:mysql://localhost:3306/fsd_java";
	private String driver = "com.mysql.cj.jdbc.Driver";

	Connection con;

	List<Employee> empList = new ArrayList<>();

	public void dbConnect() {

		try {
			Class.forName(driver);
			System.out.println("Driver loaded successfully");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		try {
			con = DriverManager.getConnection(url, userDB, pwdDB);
			System.out.println("Connection Established");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void dbClose() {
		try {
			con.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void populateRecords() {
		Employee e1 = new Employee(2, "Pooja", "Chennai", "IT", 75000);
		Employee e2 = new Employee(9, "Sri", "Bengaluru", "Finance", 55000);
		Employee e3 = new Employee();
		e3.setId(3);
		e3.setName("Deepi");
		e3.setBranch("Hydrabad");
		e3.setSalary(85000);

		empList.add(e1);
		empList.add(e2);
		empList.add(e3);

	}

	public List<Employee> getEmployeeList() {
		dbConnect();
		List<Employee> list = new ArrayList<>();
		String sql = "SELECT * FROM EMPLOYEE";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("emp_id");
				String name = rs.getString("emp_name");
				String branch = rs.getString("branch");
				String department = rs.getString("department");
				double salary = rs.getDouble("salary");

				Employee e = new Employee(id, name, branch, department, salary);
				list.add(e);
			}
			dbClose();
			return list;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		dbClose();
		return empList;
	}

	public void addEmployee(Employee employee) {

		dbConnect();
		String sql1 = "Insert into address values (?,?,?)";
		String sql2 = "insert into employee values(?,?,?,?,?,?)";
		try {
			PreparedStatement stmt = con.prepareStatement(sql1);
			stmt.setInt(1, employee.getAddress().getId());
			stmt.setString(2, employee.getAddress().getCity());
			stmt.setString(3, employee.getAddress().getPincode());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			PreparedStatement stmt = con.prepareStatement(sql2);
			stmt.setInt(1, employee.getId());
			stmt.setString(2, employee.getName());
			stmt.setString(3, employee.getBranch());
			stmt.setString(4, employee.getDepartment());
			stmt.setDouble(5, employee.getSalary());
			stmt.setInt(6, employee.getAddress().getId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void assignProject(EmployeeProject employeeProject, int emp_id, int project_id) {
		DBUtil dbUtil = new DBUtil();
		con = dbUtil.dbConnect();
		String sql = "insert into employee_project values(?,?,?,?)";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, employeeProject.getId());
			stmt.setInt(2, emp_id);
			stmt.setInt(3, project_id);
			stmt.setString(4, employeeProject.getDateOfAssign().toString());
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		dbUtil.dbClose();
	}
}

/*
 * executeQuery(): select --- ResultSet executeUpdate() : insert, update,delete
 */
