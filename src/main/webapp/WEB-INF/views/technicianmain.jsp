<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.asa.CRP.commons.SearchBy"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%    pageContext.setAttribute("searchParameters", SearchBy.values()); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
    <head>
      <style>
      .body{
          overflow: hidden;
          text-align: center;
      }
      #button1{
          overflow: hidden;
          padding-top: 350px;
          width: 2000px;
          height: 754px;
          background-color: aquamarine;
      }
      .b1{
          display:flex;
          width: 25%;
          border-radius: 1rem;
          padding: 1.5%;
          border: none;
          cursor: pointer;
      }
      </style>
      <meta charset="utf-8">
      <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
      <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
      <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
      </style>
      </head>
      <body>
	  <div class="body">
      <form action="tickettech" method="get">
          <div id="button1" class="col-md-6">
            <input class="b1" type="submit" value="Manage Tickets" name="operation">
          </div>
      </form
    </div>
  </body>
</html>
