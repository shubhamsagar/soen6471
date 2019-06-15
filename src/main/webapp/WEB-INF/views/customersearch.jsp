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

<form action="customersearch" method="post">
	<label for="searchby">SearchBy :</label>
	<select name="searchBy" id="searchBy">
		<c:forEach var="searchParameters" items="${searchParameters}">
		    <option value="${searchParameters}">${searchParameters}</option>
		</c:forEach>
	</select>
	<label for="searchText">Search Term</label>
	<input name="SearchText" id="searchText">
	<input type="submit" value="Submit"/>
</form> 

<c:choose>
  <c:when test="${not empty customerSearchStatus}">
  	<c:choose>
    <c:when test = "${customerSearchStatus eq 'RESULT_FOUND'}">
      <table>
		<tr>
			<td>FirstName</td><td>LastName</td><td>Email</td><td>Phone</td>
		</tr>
		<c:forEach items="${customerSearchResult}" var="customers">
			<tr>
			<td><a href="customer/${customers.custId}">${customers.custId}</a></td>
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