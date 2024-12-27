<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<link rel="stylesheet" href="pagelogin.css">
</head>
<body>
<div class="container">
  <h1>Login</h1>
  <form action="logpgs" method="post">
 
  <label for="email">Email</label>
  <input type="email" name="email" required="required"><br>
  <label for="password">Password</label>
  <input type="password" name="password" required="required"><br>
  <button type="submit">Login</button>
  </form>
    <a href="registers.jsp">Go for register</a>
  
  
  </div>
</body>
</html>