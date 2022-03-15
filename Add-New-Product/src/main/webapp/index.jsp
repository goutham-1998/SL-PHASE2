<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add a new Product</title>
</head>
<body>
<div align="center">
	<h2>Add a New Product</h2>
	<form action="Product" method="get">
		Id: <input type="number" id="id" name="id" placeholder="Enter id here..." required>
		<br/>
		<br/>
		Name: <input type="text" id="name" name="name" placeholder="Enter name here..." required>
		<br/>
		<br/>
		Color: <input type="text" id="color" name="color" placeholder="Enter color here..." required>
		<br/>
		<br/>
		Price: <input type="text" id="price" name="price" placeholder="Enter number here..." required>
		<br/>
		<br/>
		<input type="submit" value="Submit">
	</form>
</div>
</body>
</html>