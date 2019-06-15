<%@page language="java" contentType="text/html;charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>Ticket Details</title>

<style type="text/css">
hr {
	margin-top: 100px;
}

body {
	background-image: url("/CRP/images/back.jpg");
	background-size: 1400px 700px;
	background-repeat: no-repeat;
}

tr:first-child {
	font-weight: bold;
	background-color: #C6C9C4;
}
input[type=submit] {
	background-color: #C6C9C4;
	border: none;
	color: white;
	padding: 6px 28px;
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
		<form
			action="/CustomerRepresentativePortal/updateticketcomment/${ticketId}"
			method="get">


			<h3>Ticket Details</h3>

			<table>

				<tr>
					<th scope="col">Id</th>
					<th scope="col">Raised For</th>
					<th scope="col">Raised By</th>
					<th scope="col">Issue</th>
					<th scope="col">status</th>

				</tr>


				<tr>

					<th scope="row">${ticketId}</th>
					<td>${raisedFor}</td>
					<td>${raisedBy}</td>
					<td>${issue}</td>
					<td><textarea rows="2" cols="50" class="statusform-area"
							placeholder="${status}" name="status" value=""></textarea></td>
				</tr>

			</table>

			<h3>Add Comment:</h3>

			<textarea rows="5" cols="100" class="form-area"
				placeholder=" Type Issue here" name="comments" value=""></textarea>

			<br> <input type="submit" class="btnSubmitIssue" value="Submit" />

		</form>
	</center>
	<hr>
</body>
</html>
