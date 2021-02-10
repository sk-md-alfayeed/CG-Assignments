package com.cg.mvc.a5;

import java.sql.*;

public class EmployeeDB {

	public Employee getEmployee(int eId) {
		String s = String.valueOf(eId);
		Employee a = new Employee();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "root");
			PreparedStatement st = con.prepareStatement("SELECT * FROM employee WHERE EmployeeId=?;");
			st.setString(1, s);
			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				a.setEmployeeName(rs.getString("employeeName"));
				a.setEmployeeDepartment(rs.getString("employeeDepartment"));
				a.setEmployeeDesignation(rs.getString("employeeDesignation"));
				a.setEmployeeSalary(rs.getInt("employeeSalary"));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return a;
	}

	public void addEmployee(String name, String department, String designation, int salary) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "root");
			PreparedStatement psAdd = con.prepareStatement(
					"INSERT INTO employee(EmployeeName, EmployeeDepartment, EmployeeDesignation, EmployeeSalary) values(?, ?, ?, ?)");

			psAdd.setString(1, name);
			psAdd.setString(2, department);
			psAdd.setString(3, designation);
			psAdd.setInt(4, salary);

			psAdd.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void deleteEmployee(int id) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "root");
			PreparedStatement psDel = con.prepareStatement("DELETE FROM employee WHERE EmployeeId=?;");
			psDel.setInt(1, id);
			psDel.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void updateEmployee(int id, String name, String department, String designation, int salary) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "root");
			PreparedStatement psUp = con.prepareStatement(
					"update employee set EmployeeName = ?, EmployeeDepartment = ?, EmployeeDesignation = ?, EmployeeSalary = ? where EmployeeId = ?");

			psUp.setString(1, name);
			psUp.setString(2, department);
			psUp.setString(3, designation);
			psUp.setInt(4, salary);
			psUp.setInt(5, id);

			psUp.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}