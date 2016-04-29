<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
	<head>
		<title>Login Page</title>
	</head>
   <body>

      <form action="${pageContext.request.contextPath}/login" method="POST">
         <div>Username : <input type="text" placeholder="Enter Your Username" name="username" autofocus/></div><br>
         <div>Password:  <input type="password" placeholder="Enter Your Password" name="password" autofocus required/></div>
         <input type="submit" value="submit" />
      </form>

   </body>

</html>
