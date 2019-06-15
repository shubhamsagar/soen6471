<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cancel Confirmation</title>
</head>
<body>
	<h1>Are you sure you want to remove the plan?</</h1>
	
<form action="searchdeletecustomer/${customers.custId}" method="post">
	<input type="submit" value="Cancel Plan"/>
</form> 
<body>
	<h2>Plans Available</h2>	
	<table>
		<tr>
			<td>ID</td><td>Plan Type</td><td>Name</td><td>Amount</td><td>Duration</td>
		</tr>
		<c:forEach items="${exploreplans}" var="pl">
			<tr>
			<td><a href="deletecustomerconfirmation/${customers.custId}">${pl.planID}</td>
			<td>${pl.planType}</td>
			<td>${pl.planName}</td>
			<td>${pl.planAmount}</td>
			<td>${pl.planDuration}</td>
		</tr>
		</c:forEach>
	</table>
	<br/>
</body>


</body>
</html>