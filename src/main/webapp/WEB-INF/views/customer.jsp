<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${customer.custFirstName} Profile</title>
</head>
<body>
	<ul><li>${customer.custFirstName}</li></ul>
	<ul><li>${customer.custLastName}</li></ul>
	<form action="/CustomerRepresentativePortal/raiseTicket" method="post">
		<input type="text" name="customerID" value="${customer.custId}" hidden>
		<input type="submit" value="Raise Ticket">
	</form>
	<form action="/CustomerRepresentativePortal/exploreplans" method="get">
		<input type="text" name="customerID" value="${customer.custId}" hidden>
		<input type="submit" value="Explore Plans">
	</form>
	<form action="/CustomerRepresentativePortal/cancelplan/${customer.custId}" method="get">
		<input type="submit" value="Cancel Plan">
	</form>
	<form action="/CustomerRepresentativePortal/updateplan/${customer.custId}" method="get">
		<input type="submit" value="Update Plan">
	</form>
  	<c:if test="${not empty NoUserFoundInREQUEST}">
  		<p>No customer found while raising request please relogin</p>
	</c:if>
</body>
</html>