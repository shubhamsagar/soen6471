<%@page language="java" contentType="text/html;charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
    <head>
      <meta charset="utf-8">
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
      <style>
      .bs-example{
        margin-top: 20px;
        margin-left: 250px;
        margin-right: 250px;
        margin-bottom: 50px;
        background-color: cornsilk;

      }
      .main{
      	overflow: hidden;
      	background-color: antiquewhite;
      	padding-bottom:485px;
      }
      table {
      	padding-top:50px;
        border-collapse: collapse;
        width: 50%;
      }
      th {
        height: 50px;

      }
      .heading{
      	text-align:center;
      	margin-top:50px;
      	padding-top:50px:
      }
      </style>

      <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
      <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
      <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
      </style>
      </head>
      <body>
	  <div class="main">
	  <div class="heading">
		<h3>Available Tickets</h3>
	  </div>
      <div class="bs-example">
          <table class="table table-stripe">
              <thead>
                  <tr>
                      <th>Ticket</th>
                      <th>Representative</th>
                      <th>User</th>
                      <th>Status</th>
                  </tr>
              </thead>
              <tbody>
                <c:forEach items="${tickettech}" var = "user">
                  <tr>
                      <td><a href="ticketdetails/${user.ticketId}">${user.ticketId}</a></td>
                      <td>${user.raisedBy}</td>
                      <td>${user.raisedFor}</td>
                      <td>${user.status}<td>
                  </tr>
                </c:forEach>
            </tbody>
          </table>
      </div>
	  </div>
  </body>
</html>
