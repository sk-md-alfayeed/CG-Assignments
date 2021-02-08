package com.cg.mvc.a4;

import java.sql.*;

public class UserDB {

	public User getUser(String uname) {
		User a = new User();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "root");
			PreparedStatement st = con.prepareStatement("SELECT * FROM user WHERE username=?");
			st.setString(1, uname);
			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				a.setUsername(rs.getString("username"));
				a.setPassword(rs.getString("password"));
				a.setEmail(rs.getString("email"));
			} else {
				a.setUsername("dummy");
				a.setPassword("dummy");
				a.setEmail("dummy");
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return a;
	}

	public void inserUser(String uname, String mail, String password) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "root");
			PreparedStatement st1 = con.prepareStatement("INSERT INTO user values(?,?,?)");
			
			st1.setString(1, uname);
			st1.setString(2, mail);
			st1.setString(3, password);
			
			st1.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}