package com.corejavaapp.main.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.corejavaapp.main.model.Project;
import com.corejavaapp.main.utility.DBUtil;

public class ProjectRepository {

	DBUtil dbUtil = new DBUtil();

	public List<Project> fetchAllProjects() {
		Connection con = dbUtil.dbConnect();
		List<Project> list = new ArrayList<>();
		String sql = "Select * from project";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Project project = new Project(rs.getInt("id"), rs.getString("title"), rs.getInt("credits"));
				list.add(project);

			}
			dbUtil.dbClose();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		dbUtil.dbClose();
		return list;
	}

}
