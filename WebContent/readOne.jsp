<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="Stylesheet" href="css/bootstrap.min.css">
<link rel="Stylesheet" href="css/style.css">
</head>
<body>
	<h2>Read One Employee</h2>
	<form class="form-group" action="readOneServlet" method="POST">
		<p>
		<label for="txtIdEmployee">Employee ID</label>
		<input class="form-control" type="text" id="txtIdEmployee" name="txtIdEmployee" placeholder="1">
		</p>
		<input class="btn btn-info" type="submit" value="Submit">
	</form>
	<a class="btn btn-info" href="index.jsp">Return</a>
	<script src="js/jquery-3.4.1.min.js"></script>
	<script src="js/popper.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/script.js"></script>
</body>
</html>