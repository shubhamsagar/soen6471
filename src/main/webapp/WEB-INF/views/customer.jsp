<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${customer.custFirstName}Profile</title>
<style type="text/css">
hr {
	margin-top: 100px;
}

body {
	background-image: url("/CRP/images/back.jpg");
	background-size: 1400px 700px;
	background-repeat: no-repeat;
}

.type1 {
	background-color: #C6C9C4;
	border: none;
	color: white;
	padding: 12px 28px;
	text-decoration: none;
	margin: 3px 1px;
	cursor: pointer;
	margin-left: 1200px;
}

.type2 {
	background-color: #C6C9C4;
	border: none;
	color: white;
	padding: 12px 28px;
	text-decoration: none;
	margin: 3px 1px;
	cursor: pointer;
	margin-left: 1200px;
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
					<input type="submit" value="Main Page" class="type1">
				</form>
			</th>
			<th>
				<form action="/CustomerRepresentativePortal/logout" method="get">
					<input type="submit" value="Logout" class="type2">
				</form>
			</th>
		</tr>
	</table>
	<hr>
	<br>
	<br>
	<center>
		<table border=1>
			<tr style="text-align: center">
				<td>ID</td>
				<td>FirstName</td>
				<td>LastName</td>
				<td>Phone</td>
				<td>Email</td>
				<td>Address</td>
				<td>Plan</td>
			</tr>
			<tr>
				<th>${customer.custId}</th>
				<th>${customer.custFirstName}</th>
				<th>${customer.custLastName}</th>
				<th>${customer.phoneNumber}</th>
				<th>${customer.custEmail}</th>
				<th>${customer.custAddress}</th>
				<th>${customer.custPlan}</th>
			</tr>
		</table>
		<br>

		<table>
			<tr>
				<th>
					<form action="/CustomerRepresentativePortal/raiseTicket"
						method="post">
						<input type="text" name="customerID" value="${customer.custId}"
							hidden> <input type="submit" value="Raise Ticket">
					</form>
				</th>
				<th>
					<form action="/CustomerRepresentativePortal/exploreplans"
						method="get">
						<input type="text" name="customerID" value="${customer.custId}"
							hidden> <input type="submit" value="Explore Plans">
					</form>
				</th>
				<th>
					<form
						action="/CustomerRepresentativePortal/cancelplan/${customer.custId}"
						method="get">
						<input type="submit" value="Cancel Plan">
					</form>
				</th>
				<th>
					<form
						action="/CustomerRepresentativePortal/updateplan/${customer.custId}"
						method="get">
						<input type="submit" value="Update Plan">
					</form>
				</th>
				<th>
					<form
						action="/CustomerRepresentativePortal/viewticketsforuser/${customer.custId}"
						method="get">
						<input type="submit" value="View Tickets">
					</form>
				</th>

			</tr>
		</table>
		<br>




		<c:if test="${not empty NoUserFoundInREQUEST}">
			<p>No customer found while raising request please relogin</p>
		</c:if>
	</center>
	<hr>
</body>
</html>