
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <!-- c:out ; c:forEach ; c:if -->
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
   <!-- Formatting (like dates) -->
 <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
   <!-- form:form -->
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
   <!-- for rendering errors on PUT routes -->
 <%@ page isErrorPage="true" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Title Here</title>
  <!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
      rel="stylesheet" 
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
      crossorigin="anonymous">

</head>
<body>
    <div class="container"> <!-- Beginning of Container -->
        
	<div>
		<h1>All Courses</h1>
		
		<p>Search Source:</p>
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
					<c:forEach var = "i" items = "${allCourse }">
						<tr>
							<td><p> <a href="/oneCourse/${i.id }">
							<c:out value = "${i.title }"></c:out></a>
							</p></td>
							<td><p> <c:out value = "Instructor"></c:out></p></td>
							<td><p> <c:out value = "${i.credit }"></c:out></p></td>
							<td><p> <c:out value = "${i.price }"></c:out></p></td>
							<td><p> <c:out value = "Students"></c:out></p></td>
							
							<td><p> <c:out value = "${i.required }"></c:out></p></td>
							
							<td>
								<a class = "btn btn-success" href="/addCourse/${i.id}">Join</a> 
							</td>
							
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		
	
	</div>
	
    </div> <!-- End of Container -->
</body>
</html>