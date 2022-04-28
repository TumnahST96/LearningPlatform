<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page isErrorPage="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>student register</title>
	
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/main.js"></script>
</head>
<body>
	<div>
		<nav class="navbar navbar-dark bg-dark">
            <h3>Welcome to LearningPlatform!</h3>
            <div>
                <form class="form-inline d-flex">
    		 		<input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
    				<button class="btn btn-outline-success my-2 ms-2 my-sm-0" type="submit">Search</button>
  				</form>            
            </div>

        </nav>	
	</div>

    <div class="container"> <!-- Beginning of Container -->
        
	<div>
		<h1>All Courses</h1>
		
		<p>Search Source:</p>
		<a href="/dashboard">Back to dashBoard</a>
		<br>
				
		<div >
			<table class = "table table-dark table-striped table-hover">
				<thead>
					<tr>
						<th class = "align-middle">Course</th>
						<th class = "align-middle">Instructor</th>
						<th class = "align-middle">Credit</th>
						<th class = "align-middle">Cost</th>
						<th class = "align-middle">Current Students</th>
						<th class = "align-middle">Required</th>
						<th class = "align-middle">Action</th>
					</tr>
				</thead>
				
				<tbody>
					<c:forEach var = "i" items = "${allCourses}">
						<tr>
							<td><p> <a href="/oneCourse/${i.id}">
							<c:out value = "${i.title }"></c:out></a>
							</p></td>
							<td><p> <c:out value = "${i.teacher.firstName}"></c:out></p></td>
							<td><p> <c:out value = "${i.credit }"></c:out></p></td>
							<td><p> <c:out value = "${i.price }"></c:out></p></td>
							<td><p> <c:out value = "Students"></c:out></p></td>
							
							<td><p> <c:out value = "${i.required }"></c:out></p></td>
							
							<td>
								<c:if test="${user.role == 'student'}">	
									<c:if test="${!fn:contains(i.students, user)}"><a href="/student/enroll/${i.id}" class="btn btn-success mt-2">Join</a></c:if>
									<c:if test="${fn:contains(i.students, user)}"><a href="/student/quit/${i.id}" class="btn btn-danger mt-2">Quit</a></c:if>
								</c:if>	
								<c:if test="${user.role == 'teacher' }"><a href="" class="btn btn-success mt-2">Teacher button</a></c:if>						
							</td>
							
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		
		<c:if test="${user.role == 'teacher'}">	<a href="/new_course" class="btn btn-success mt-2">Add a new course</a></c:if>
		
	
	</div>
	
    </div> <!-- End of Container -->
</body>
</html>