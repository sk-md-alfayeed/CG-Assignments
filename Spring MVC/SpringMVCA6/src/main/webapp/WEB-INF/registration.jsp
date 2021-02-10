<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<body>
	<h1>Registration</h1>

	<form:errors path="customer.*" />

	<form action="/SpringMVCA6/submitRegister.html" method="post">

		<p>
			Username : <input type="text" name="username" />
		</p>

		<p>
			Password : <input type="text" name="password" />
		</p>
		<p>
			Email : <input type="text" name="email" />

		</p>
		<p>
			Contact : <input type="text" name="contact" />

		</p>

		<p>
			City : <select name="city">
				<option value="Pune">Pune</option>
				<option value="Mumbai">Mumbai</option>
				<option value="Delhi">Delhi</option>
			</select>

		</p>
		<p>
			ZipCode : <input type="text" name="zipcode" />

		</p>

		<input type="submit" value="Register" />
	</form>

	<h2>${msg}</h2>
</body>
</html>