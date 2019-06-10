<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
hr{
margin-top:100px;
}
</style>
</head>
<body>
<a href="CustomerWelcome.jsp">Welcome</a>
<a href="CustomerLogin.jsp">Login</a>
<hr><br>
<center><font face="Lucida Calligraphy" size=5>Create User</font><br><br>
<table>
                <tr>
                    <th>First Name*</th>
                    <td><input type="text" name="First_Name"></td>
                </tr>
                <tr>
                    <th>Last Name*</th>
                    <td><input type="text" name="Last_Name"></td>
                </tr>
                <tr>
                <th>UserName*</th>
                <td><input type="text" name="User_Name"></td>
                </tr>
                <tr>
                <th>Password*</th>
                <td><input type="password" name="Password"></td>
                </tr>
                <tr>
                <th>Role*</th>
                <td><input type="text" name="cr_Role"></td>
                </tr>
                  <tr>
                   <td><input type="submit" value="Create"></td>
                </tr>                               
           
            </table></center>
            <hr>
</body>
</html>