<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<style type="text/css">
body {
	background-image: url("/CRP/images/callcenter.jpg");
	background-size: 1400px 700px;
	background-repeat: no-repeat;

}
h1{ 
margin-top:200px;
margin-right:5px;
}
a{
color:black;
}
input[type=submit]{
  background-color: #C6C9C4;
  border: none;
  color: black;
  padding: 12px 28px;
  text-decoration: none;
  margin: 3px 1px;
  cursor: pointer;
 
   
}
</style>
</head>
<body>
<h1><center>Login</center></h1>
<form action="customerRepresentativeLoginCheck" method="post">	
<center><table>
				<tr>
					<th>LoginId*</th>
					<td><input type="text" name="login" size=30><font
						color="red" required></font></td>
				</tr>
				<tr>
					<th>Password*</th>
					<td><input type="password" name="password" size=30><font
						color="red" required></font></td>
				</tr>
				<tr>
					
					<td><input type="submit" name="operation" value="SignIn" ></td>
				</tr>
				
			</table></center></form>
</body>
</html>
