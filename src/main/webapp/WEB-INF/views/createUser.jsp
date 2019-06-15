<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create User</title>
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
		<form action="createCustomerRepresentative" method="get">

			<font face="Lucida Calligraphy" size=5>Create User</font><br>
			<br>
			<table>
				<tr>
					<th>First Name*</th>
					<td><input type="text" name="firstName"></td>
				</tr>
				<tr>
					<th>Last Name*</th>
					<td><input type="text" name="lastName"></td>
				</tr>
				<tr>
					<th>User Name*</th>
					<td><input type="text" name="userName"></td>
				</tr>
				<tr>
					<th>Password*</th>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<th>Role*</th>
					<td><input type="text" name="crRole"></td>
				</tr>
				<tr>
					<th></th>
					<td>&nbsp;&nbsp;&nbsp; <input type="submit" value="Create"></td>
				</tr>

			</table>

		</form>
	</center>
	<hr>
</body>
</html>