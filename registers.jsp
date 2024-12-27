<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register page</title>
<link rel="stylesheet" href="reg.css">
</head>
<body>
  <div class="container">
  <h1>Register</h1>
  <form action="regs" method="post">
  <label for="firstname">Firstname</label>
  <input type="text" name="firstname" required="required"><br>
  <label for="lastname">Lastname</label>
  <input type="text" name="lastname" required="required"><br>
  <label for="phnumber">Mobile-Number</label>
  <input type="number" name="phnumber" required="required"><br>
  <label for="email">Email</label>
  <input type="email" name="email" required="required"><br>
  <label for="password">Password</label>
  <input type="password" name="password" required="required"><br>
  <button type="submit">Register</button>
  </form>
    <a href="map.html">Go to Map</a>
  
  
  </div>
</body>
</html>