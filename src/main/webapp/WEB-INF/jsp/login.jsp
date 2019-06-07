<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body {
	background-image: url("/CollegeProject/images/callcenter.jpg");
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
</style>
</head>
<body>
<a href="CustomerWelcome.jsp">Welcome</a>
<a href="CustomerLogin.jsp">Login</a>
<h1><center>Login</center></h1>
<form action="">
<center><table>
				<tr>
					<th>LoginId*</th>
					<td><input type="text" name="login" size=30><font
						color="red"></font></td>
				</tr>
				<tr>
					<th>Password*</th>
					<td><input type="password" name="password" size=30><font
						color="red"></font></td>
				</tr>
				<tr>
					
					<td><input type="submit" name="operation" value="SignIn"></td>
				</tr>
				<tr>								
					<td><b><a href="" >Forget my password</a></b>&nbsp;</td>
				</tr>
			</table></center></form>
</body>
</html>