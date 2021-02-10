<!DOCTYPE html>
<html>
<head>
<title>Delete JSP</title>
<%@page import="java.sql.*"%>
</head>
<body>
	<%
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "root");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from employee;");
	%><table border=1 align=center style="text-align: center">
		<thead>
			<tr>
				<th>Employee ID</th>
				<th>Employee Name</th>
				<th>Employee Department</th>
				<th>Employee Designation</th>
				<th>Employee Salary</th>
				<th>Update</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>
			<%
			while (rs.next()) {
			%>
			<tr>
				<td><%=rs.getInt("employeeId")%></td>
				<td><%=rs.getString("employeeName")%></td>
				<td><%=rs.getString("employeeDepartment")%></td>
				<td><%=rs.getString("employeeDesignation")%></td>
				<td><%=rs.getString("employeeSalary")%></td>
				<td><form method="get" id="upButton" action="/SpringMVCA5/submitUpdate.html">
						<Input type="Hidden" name ="employeeId" value="<%=rs.getInt("employeeId")%>">
						<Input type="submit" value="Edit">
					</form></td>
				<td>
					<form method="get" id="delButton" action="/SpringMVCA5/submitDeleteButton.html">
						<Input type="Hidden" name ="employeeId" value="<%=rs.getInt("employeeId")%>">
						<Input type="submit" value="Delete">
					</form>
				</td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
	<br>
	<%
	} catch (Exception e) {
	out.print(e.getMessage());
	%><br>
	<%
	}
	%>
	
	<form action="/SpringMVCA5/index.html" method="get">
		<input type="submit" value="Homepage" />
	</form>
</body>
</html>