<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title></title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<script type="text/javascript" src="js/main.js"></script>
</head>
<body>


							
	<h1>Thank you for considering us! What would you like to enroll as?</h1>
	<form action="/consider" method="POST">
	
		<input type="checkbox" name="teacher" value="teacher" >
		<label for="teacher"> Teacher</label><br>
		<input type="checkbox"  name="student" value="student">
		<label for="student"> Student</label><br>
	
	</form>
	
	
</body>
</html>