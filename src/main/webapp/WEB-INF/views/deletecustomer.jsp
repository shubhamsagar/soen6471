<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Customer</title>
</head>
<body>



<form action="searchdeletecustomer" method="post">
	<label for="phoneno">Phone No: </label>
	<input name="phoneno" id="phoneno">
	<input type="submit" value="Search"/>
</form> 
	
<c:choose>
  <c:when test="${not empty searchdeletecustomer}">
  	<c:choose>
    <c:when test = "${searchdeletecustomer eq 'RESULT_FOUND'}">
      <table>
		<tr>
			<td>FirstName</td><td>LastName</td><td>Email</td><td>Phone</td>
		</tr>
		<c:forEach items="${searchdeleteResult}" var="customers">
			<tr>
			<td><a href="deletecustomerconfirmation/${customers.custId}">${customers.custId}</a></td>
			<td>${customers.custFirstName}</td>
			<td>${customers.custLastName}</td>
			<td>${customers.custEmail}</td>
			<td>${customers.phoneNumber}</td>
			</tr>
		</c:forEach>
	  </table>
  	</c:when>
  	
  	<c:otherwise>
	    <p>No user found in search</p>
	</c:otherwise>
	</c:choose>
  </c:when>
  <c:otherwise>
    
  </c:otherwise>
</c:choose>

</body>
</html>