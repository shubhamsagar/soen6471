<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Plan</title>
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
		<form action="addPlanConfirmation" method="GET">

			<font face="Lucida Calligraphy" size=5>Add Plan</font><br>
			<br>
			<table>
				<tr>
					<th>Plan Name*</th>
					<td><input type="text" name="planName"></td>
				</tr>
				<tr>
					<th>Plan Type*</th>
					<td><input type="text" name="planType"></td>
				</tr>
				<tr>
					<th>Duration*</th>
					<td><input type="text" name="duration"></td>
				</tr>
				<tr>
					<th>Amount*</th>
					<td><input type="text" name="amount"></td>
				</tr>
				<tr>
					<th></th>
					<td>&nbsp;&nbsp;<input type="submit" value="Add"></td>
				</tr>
			</table>
	</center>
	<hr>
	</form>
</body>
</html>