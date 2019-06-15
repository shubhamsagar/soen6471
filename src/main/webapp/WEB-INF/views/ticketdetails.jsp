<%@page language="java" contentType="text/html;charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>Ticket Details</title>
    
   <style>
   .main{
       overflow: hidden;
       background-color: antiquewhite;
   	padding-top:50px;
       height: 750px;
   }

   .table{
       margin-left: 160px;
       margin-top: 50px;
       width: 50px;
       background-color: cornsilk;
   }

   .staticComment{
       margin-left: 160px;
       margin-top: 50px;
   }

   .tableDetails{
   	width: 1150px;
   }

   .comments{
   	margin-left: 160px;
   }

   .addComment{
   	margin-left: 162px;

   }

   .form-group{
   	margin-left:160px;
   }

   .form-area{
   	width: 960px;
       height: 150px;
       border-radius: 0.5rem;
       color: black;
       background-color: beige
   }

   .btnSubmitIssue{
   	margin-left:500px;
       border-radius: 0.5rem;
       color: black;
       background-color: beige
   }
   </style>

  <link rel="stylesheet" href ="tickdetail.css">
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
  </head>
  <body>
   <form action="/CustomerRepresentativePortal/updateticketcomment/${ticketId}" method="get">
  
	<div class="main">
		<div class="heading" style="text-align:center">
			<h3>Ticket Details</h3>
		</div>
		<div class="tableDetails">
			<table class="table">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">Raised For</th>
					<th scope="col">Raised By</th>
					<th scope="col">Issue</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<!-- Put data Dynamically here-->
					<th scope="row">${ticketId}</th>
					<td>${raisedFor}</td>
					<td>${raisedBy}</td>
					<td>${issue}</td>
				</tr>
			</tbody>
			</table>
		</div>
		<div class="addComment">
			<div class="header">
				<h5>Add Comment:</h5>
			</div>
			<div class="form-group">
				<textarea rows="5" cols="100" class="form-area" placeholder=" Type Issue here" name="comments" value=""></textarea>
			</div>

			<div class="form-group3">
				<input type="submit" class="btnSubmitIssue" value="Submit" />
			</div>
		</div>
	</div>
	</form>
  </body>
</html>
