<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
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
<body style="text-align: center">
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
		<form action="addcustomerconfirmation" method="get">
			<h1>Add Customer</h1>
			<table>
				<tr>
					<th>First Name</th>
					<td><input type="text" name="firstname" size=30></td>
				</tr>
				<tr>
					<th>Last Name</th>
					<td><input type="text" name="lastname" size=30></td>
				</tr>
				<tr>
					<th>Address</th>
					<td><input type="text" name="address" size=30></td>
				</tr>
				<tr>
					<th>Phone Number</th>
					<td><input type="text" name="phoneno" size=30></td>
				</tr>
				<tr>
					<th>Plan</th>
					<td><input type="text" name="plan" size=30></td>
				</tr>
				<tr>
					<th>Email</th>
					<td><input type="text" name="email" size=30></td>
				</tr>
				<tr>
					<th></th>
					<td colspan="2"><input type="submit" value="Add customer"></td>
				</tr>
			</table>
		</form>
	</center>
	<hr>
</body>