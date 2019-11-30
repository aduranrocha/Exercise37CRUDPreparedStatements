<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Employee</title>
<link rel="Stylesheet" href="css/bootstrap.min.css">
<link rel="Stylesheet" href="css/style.css">
</head>
<body>
	<h2>Read One Employee</h2>
	<form class="form-group" action="updateServlet" method="POST">
		<p>
			<label for="txtIdEmployee">Id Employee:</label>
			<input class="form-control" type="text" id="txtIdEmployee" name="txtIdEmployee">
		</p>
		<p>
			<label for="txtNameEmployee">Name Employee:</label>
			<input class="form-control" type="text" id="txtNameEmployee" name="txtNameEmployee">
		</p>
		<p>
			<label for="txtAgeEmployee">Age Employee:</label>
			<input class="form-control-range" type="range" id="txtAgeEmployee" name="txtAgeEmployee" min="18" max="100" step="1">
		</p>
		<p>
			<label for="txtAddressEmployee">Address Employee:</label>
			<input class="form-control" type="text" id="txtAddressEmployee" name="txtAddressEmployee">
		</p>
		<p>
			<label for="txtSalaryEmployee">Salary Employee:</label>
			<input class="form-control" type="text" id="txtSalaryEmployee" name="txtSalaryEmployee">
		</p>
		<p>
			<label for="txtDepartmentEmployee">Department Employee:</label>
			<input class="form-control" type="text" id="txtDepartmentEmployee" name="txtDepartmentEmployee">
		</p>
		<input type="submit" value="Update Employee">
	</form>
	<a class="btn btn-info" href="index.jsp">Return</a>
	<script src="js/jquery-3.4.1.min.js"></script>
	<script src="js/popper.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/script.js"></script>
</body>
</html>