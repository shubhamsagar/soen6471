<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>RaiseTicket</title>
</head>
<body>

<form action="raiseNewTicket" method="post">
	<input type="hidden" name="customerID" value="${customer.custId}">
	<input type="text" name="issue" value="">
	<input type="submit" value="Submit Ticket">
</form>

</body>
</html>