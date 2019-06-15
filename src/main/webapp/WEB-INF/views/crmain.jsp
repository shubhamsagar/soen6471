<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.asa.CRP.commons.SearchBy"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	pageContext.setAttribute("searchParameters", SearchBy.values());
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CR Logged In</title>
<style type="text/css">
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
		<table>
			<tr>
				<th>
					<form action="customersearch" method="get">


						<td colspan="2"><input type="submit" value="Search Customer"
							name="operation"> &nbsp;</td>

					</form>
				</th>
				<th>

					<form action="deletecustomer" method="get">

						<td colspan="2"><input type="submit" value="Delete customer"
							name="operation"> &nbsp;</td>
					</form>
				</th>
				<th>

					<form action="addcustomer" method="get">


						<td colspan="2"><input type="submit" value="Add customer"
							name="operation"> &nbsp;</td>

					</form>
				</th>
			</tr>
		</table>
		<br>

	</center>
	<hr>
</body>
</html>