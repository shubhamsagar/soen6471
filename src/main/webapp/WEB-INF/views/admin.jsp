<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
	integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
	crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin</title>
<style type="text/css">
hr {
	margin-top: 100px;
}
body {
	background-image: url("/CRP/images/back.jpg");
	background-size: 1400px 700px;
	background-repeat: no-repeat;
}
input[type=submit] {
	background-color: #C6C9C4;
	border: none;
	color: white;
	padding: 12px 28px;
	text-decoration: none;
	margin: 3px 1px;
	cursor: pointer;
}
</style>
</head>
<body>
	<table>
		<tr>
			<th>
				<form action="/CustomerRepresentativePortal/backtomain" method="get">
					<input type="submit" value="Main Page">
				</form>
			</th>
			<th>
				<form action="/CustomerRepresentativePortal/logout" method="get">
					<input type="submit" value="Logout">
				</form>
			</th>
		</tr>
	</table>
	<hr>
	<br>
	<br>
	
	<center>
		<i class='fas fa-users' style='font-size: 24px'>&nbsp;&nbsp;&nbsp;<font
			size=5><a href="">Create User</a></font></i><br>
		<br> <i class='fas fa-user-minus' style='font-size: 24px'>&nbsp;&nbsp;&nbsp;<font
			size=5><a href="">Delete User</a></font></i><br>
		<br> <i class='fas fa-user' style='font-size: 24px'>&nbsp;&nbsp;&nbsp;<font
			size=5><a href="">View User</a></font></i><br>
		<br> <i class='fas fa-phone' style='font-size: 24px'>&nbsp;&nbsp;&nbsp;<font
			size=5><a href="">Add Plans</a></font></i>
	</center>
	<hr>
</body>
</html>