package com.corejavaapp.main.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.corejavaapp.main.model.Employee;

public class DBUtil {

	private String userDB = "root";
	private String pwdDB = "Pooja@14";
	private String url = "jdbc:mysql://localhost:3306/fsd_java";
	private String driver = "com.mysql.cj.jdbc.Driver";

	Connection con;

	public Connection dbConnect() {

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
		return con;
	}

	public void dbClose() {
		try {
			con.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
