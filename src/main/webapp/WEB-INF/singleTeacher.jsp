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
	<title>Single teacher</title>
	
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/main.js"></script>
</head>
<body>
	<div class="container-sm">
		<div class="header">
			<h1>Teacher/Student information</h1>
		</div>
		
		<a href="/dashboard">Back to dashBoard</a>
		<div class="mt-3">
			<div>
				<div>img here</div>
				<p>Professor ${user.firstName } ${user.lastName }</p>
				<p>${user.email}</p>
				<p>${user.education}</p>
				<p>${user.major}</p>
			</div>	
			
			<div>
				<div>course img</div>
				<p>Machine learnign</p>
			</div>	
			
			<div>
				<div>course img</div>
				<p>Linear Algebra</p>
			</div>	
			
			
		</div>
	</div>
</body>
</html>