<html>
<body>
	<h1>Update Employee</h1>

	<form action="/SpringMVCA5/submitUpdateButton.html" method="post">

		<p>
			Employee Name : <input type="text" name="employeeName" value="${empName}"/>
		</p> 

		<p>
			Employee Department : <input type="text" name="employeeDepartment" value="${empDep}"/>
		</p>
		<p>
			Employee Designation : <input type="text" name="employeeDesignation" value="${empDes}"/>

		</p>
		<p>
			Employee Salary : <input type="text" name="employeeSalary" value="${empSal}"/>

		</p>

		<input type="submit" value="Update" />
	</form>
	
	<h2>${msg}</h2>

	<form action="/SpringMVCA5/index.html" method="get">
		<input type="submit" value="Homepage" />
	</form>
</body>
</html>