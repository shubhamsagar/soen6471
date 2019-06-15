<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Users</title>

<style>
body {
	background-image: url("/CRP/images/back.jpg");
	background-size: 1400px 700px;
	background-repeat: no-repeat;
}
tr:first-child {
	font-weight: bold;
	background-color: #C6C9C4;
}

hr {
	margin-top: 100px;
}

input[type=submit] {
	background-color: #C6C9C4;
	border: none;
	color: white;
	padding: 6px 28px;
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
		<h2>CustomerRepresentatives</h2>
		<table>
			<tr>
				<td>ID</td>
				<td>First Name</td>
				<td>Last Name</td>
				<td>User Name</td>
				<td>Role</td>
			</tr>
			<c:forEach items="${viewusers}" var="cr">
				<tr>
					<td>${cr.id}</td>
					<td>${cr.crFirstName}</td>
					<td>${cr.crLastName}</td>
					<td>${cr.crUserName}</td>
					<td>${cr.crRole}</td>
				</tr>
			</c:forEach>
		</table>
	</center>
	<hr>
</body>
</html>