<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.asa.CRP.commons.SearchBy"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%    pageContext.setAttribute("searchParameters", SearchBy.values()); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CR Logged In</title>
</head>
<body>

<form action="customersearch" method="get">
<tr>
					<th></th>
					<td colspan="2"><input type="submit" value="Search Customer" name="operation"> &nbsp; </td>
				</tr>
				<tr>
					<th></th>
	</form> 
	<form action="deletecustomer" method="get">
<tr>
					<th></th>
					<td colspan="2"><input type="submit" value="Delete customer" name="operation"> &nbsp;</td>
				</tr>
				<tr>
					<th></th>
				
	</form> 

<form action="addcustomer" method="get">
<tr>
					<th></th>
					<td colspan="2"><input type="submit" value="Add customer" name="operation"> &nbsp;</td>
				</tr>
				<tr>
					<th></th>
				
	</form> 
</body>
</html>