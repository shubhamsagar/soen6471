<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add customer</title>
<SCRIPT language=Javascript>
	function phoneNumber(inputText) {
		var regex = /^\d{10}$/;
		if (regex.test(inputText.phoneno.value)) {
			return true;
		} else {
			alert("Please enter a valid Phone Number");
			phoneno.value = '';
			return false;
		}
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
		<form action="addcustomerconfirmation" method="get"
			onSubmit="return phoneNumber(this)">
			<h1>Add Customer</h1>
			<table>
				<tr>
					<th>First Name*</th>
					<td><input type="text" name="firstname"
						placeholder="your first name" size=30 required></td>
				</tr>
				<tr>
					<th>Last Name*</th>
					<td><input type="text" name="lastname"
						placeholder="your last name" size=30 required></td>
				</tr>
				<tr>
					<th>Address*</th>
					<td><input type="text" name="address"
						placeholder="your address" size=30 required></td>
				</tr>
				<tr>
					<th>Phone Number*</th>
					<td><input type="text" name="phoneno"
						placeholder="your phonenumber" onpaste="return false" maxlength=10
						required></td>
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
					<td><input type="email" name="email" placeholder="your email"
						required></td>
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
</html>