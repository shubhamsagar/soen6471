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
hr {
	margin-top: 100px;
}
tr:first-child {
	font-weight: bold;
	background-color: #C6C9C4;
}

body {
	background-image: url("/CollegeProject/images/back.jpg");
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
		<form action="customersearch" method="post">
			<label for="searchby">SearchBy :</label> <select name="searchBy"
				id="searchBy">
				<c:forEach var="searchParameters" items="${searchParameters}">
					<option value="${searchParameters}">${searchParameters}</option>
				</c:forEach>
			</select> <label for="searchText">Search Term</label> <input name="SearchText"
				id="searchText"> <input type="submit" value="Submit" />
		</form>

		<c:choose>
			<c:when test="${not empty customerSearchStatus}">
				<c:choose>
					<c:when test="${customerSearchStatus eq 'RESULT_FOUND'}">
					 	<table>
							<tr>
								<td>Id</td>
								<td>FirstName</td>
								<td>LastName</td>
								<td>Email</td>
								<td>Phone</td>
							</tr>
							<c:forEach items="${customerSearchResult}" var="customers">
								<tr>
									<td><a
										href="/CustomerRepresentativePortal/customer/${customers.custId}">${customers.custId}</a></td>
									<td>${customers.custFirstName}</td>
									<td>${customers.custLastName}</td>
									<td>${customers.custEmail}</td>
									<td>${customers.phoneNumber}</td>
								</tr>
							</c:forEach>
						</table>
					</c:when>
					<c:otherwise>
						<p item= "${InvalidNumber}" > ${InvalidNumber}</p>	
					</c:otherwise>
				</c:choose>
			</c:when>
			<c:otherwise>
	        <p>${customersearchResult}</p>
			</c:otherwise>
		</c:choose>


	</center>
	<hr>
</body>
</html>