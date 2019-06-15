<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Tickets</title>

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

input[type=submit] {
	background-color: #C6C9C4;
	border: none;
	color: white;
	padding: 6px 28px;
	text-decoration: none;
	margin: 3px 1px;
	cursor: pointer;
}

hr {
	margin-top: 100px;
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
		<h2>Plans Available</h2>
		<table>
			<tr>
				<td>ID</td>
				<td>Date</td>
				<td>Issue</td>
				<td>Raised By</td>
				<td>Status</td>
			</tr>
			<c:forEach items="${viewTickets}" var="ticket">
				<tr>
					<td>${ticket.ticketId}</td>
					<td>${ticket.date}</td>
					<td>${ticket.issue}</td>
					<td>${ticket.raisedBy}</td>
					<td>${ticket.status}</td>
				</tr>
			</c:forEach>
		</table>
		<br>

		<hr>
</body>
</html>