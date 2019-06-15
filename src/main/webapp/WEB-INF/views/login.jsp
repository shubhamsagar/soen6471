<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>

</head>
<body>
	<form action="customerRepresentativeLoginCheck" method="post">		
			<h1>Login</h1>
			<table>
				<tr>
					<th>LoginId*</th>
					<td><input type="text" name="login" size=30></td>
					<c:if test="${not empty userNameError}">
						<c:if test="${userNameError eq 'true'}">
							<td>The user Name is empty</td>
						</c:if>
					</c:if>
				</tr>
				<tr>
					<th>Password*</th>
					<td><input type="password" name="password" size=30></td>
					<c:if test="${not empty userPassowrdError}">
						<c:if test="${userPassowrdError eq 'true'}">
							<td>The user password is empty</td>
						</c:if>
					</c:if>
				</tr>
				<tr>
					<th></th>
					<td colspan="2"><input type="submit" name="operation">
						&nbsp; <input type="submit" name="operation"> &nbsp;</td>
					<c:if test="${not empty userNotFoundError}">
						<c:if test="${userNotFoundError eq 'true'}">
							<td>The user was not found in the database</td>
						</c:if>
					</c:if>
				</tr>
				<tr>
					<th></th>
					<td><b>Forgot my password</b></a>&nbsp;</td>
				</tr>
			</table>
	</form>
</body>