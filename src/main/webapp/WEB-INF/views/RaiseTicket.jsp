<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>RaiseTicket</title>
<style type="text/css">
hr {
	margin-top: 100px;
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

body {
	background-image: url("/CRP/images/back.jpg");
	background-size: 1400px 700px;
	background-repeat: no-repeat;
}
textarea {
	width: 500px;
	height: 150px;
	padding: 12px 20px;
	box-sizing: border-box;
	border: 2px solid #ccc;
	border-radius: 4px;
	background-color: #f8f8f8;
	font-size: 16px;
	resize: none;
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
	<form action="/CustomerRepresentativePortal/raiseNewTicket/${customer.custId}"  method="post">
	<center>
		<table>
				<tr>
					<th>Issue </th>
					<td><input type="text" name="issue" size=30><font
						color="red" required></font></td>
				</tr>
				<tr>
					
					<td><input type="submit" name="operation" value="Submit" ></td>
				</tr>
				
			</table></center></form>
		<br>

	</center>
	<hr>
</body>
</html>