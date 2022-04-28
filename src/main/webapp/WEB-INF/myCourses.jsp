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
	<title>My courses</title>
	
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/main.js"></script>
</head>
<body>
	<div class="container-sm">
		<div class="header">
			<h1>All my courses information</h1>
		</div>
		
		<a href="/dashboard">Back to dashBoard</a>
		
		<div >
			<table class = "table table-dark table-striped table-hover">
				<thead>
					<tr>
						<th class = "align-middle">Course Title:</th>
						<th class = "align-middle">Instructor</th>
						<th class = "align-middle">Credit</th>
						<th class = "align-middle">Cost</th>
						<th class = "align-middle">Required</th>
						<th class = "align-middle">Action</th>
					</tr>
				</thead>
				
				<tbody>
					<c:forEach var = "i" items = "${myCourses}">
						<tr>
							<td><p> <a href="/oneCourse/${i.id}">
							<c:out value = "${i.title}"></c:out></a>
							</p></td>
							<td><p> <c:out value = "${i.teacher.firstName}"></c:out></p></td>
							<td><p> <c:out value = "${i.credit }"></c:out></p></td>
							<td><p> <c:out value = "${i.price }"></c:out></p></td>					
							<td><p> <c:out value = "${i.required }"></c:out></p></td>							
							<td>
							</td>							
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		
		<c:if test="${user.role == 'teacher'}">	<a href="/new_course" class="btn btn-success mt-2">Add a new course</a></c:if>

	</div>
</body>
</html>