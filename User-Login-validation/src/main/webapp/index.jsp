<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LOGIN PAGE</title>
</head>
<body>
<div align="center">
		<h1>Login Form</h1>
		<form method="post" action="LoginCheck">
			Enter Username: <input type="text" name="uname" required>
			<br/>
			<br/>
			Enter Your Password: <input type="password" name="pass" required>
			<br/>
			<br/>
			<input type="submit" value="LOGIN">
		</form>
	</div>
</body>
</html>