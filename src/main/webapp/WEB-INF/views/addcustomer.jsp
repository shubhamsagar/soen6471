<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add customer</title>
<SCRIPT language=Javascript>
      
      function isNumber(evt)
      {
         var charCode = (evt.which) ? evt.which : event.keyCode
         if (charCode > 31 && (charCode < 48 || charCode > 57))
            return false;

         return true;
      }
      
   </SCRIPT>
<style type="text/css">
hr {
	margin-top: 100px;
}

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
</style>

</head>
<body style="text-align: center">
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
		<form action="addcustomerconfirmation" method="get">
			<h1>Add Customer</h1>
			<table>
				<tr>
					<th>First Name</th>
					<td><input type="text" name="firstname" size=30></td>
				</tr>
				<tr>
					<th>Last Name</th>
					<td><input type="text" name="lastname" size=30></td>
				</tr>
				<tr>
					<th>Address</th>
					<td><input type="text" name="address" size=30></td>
				</tr>
				<tr>
					<th>Phone Number</th>
					<td><input type="text" name="phoneno" onkeypress="return isNumberKey(event)" onpaste="return false" maxlength=10></td>
				</tr>
				<tr>
					<label for="plan">Plan :</label>
					<select name="plan" id="plan">
						<c:forEach var="planList" items="${planList}">
							<option value="${planList.planName}">${planList.planName}</option>
						</c:forEach>
					</select>
				</tr>
				<tr>
					<th>Email</th>
					<td><input type="text" name="email" size=30></td>
				</tr>
				<tr>
					<th></th>
					<td colspan="2"><input type="submit" value="Add customer"></td>
				</tr>
			</table>
		</form>
	</center>
	<hr>
</body>