<html>
<body>
	<h1>Add Employee</h1>

	<form action="/SpringMVCA5/addEmployee.html" method="post">

		<p>
			Employee Name : <input type="text" name="employeeName" />
		</p>

		<p>
			Employee Department : <input type="text" name="employeeDepartment" />
		</p>
		<p>
			Employee Designation : <input type="text" name="employeeDesignation" />

		</p>
		<p>
			Employee Salary : <input type="text" name="employeeSalary" />

		</p>

		<input type="submit" value="Add" />
	</form>

	<h2>${msg}</h2>

	<form action="/SpringMVCA5/index.html" method="get">
		<input type="submit" value="Homepage" />
	</form>
</body>
</html>