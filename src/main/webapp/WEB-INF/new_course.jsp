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
	<title>New Course</title>
	
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/main.js"></script>
</head>
<body>
	<div class="container-sm">
			<div>
				<h2>Add a course!</h2>
				<form:form action="/add_course" method="POST" modelAttribute="course">
							
					<form:label class="col-sm-2 col-form-label" path="title">Course Title: </form:label>
					<form:errors path="title"  class="text-danger"></form:errors>
					<form:input type="text" class="form-control" path="title"></form:input>		
					
					<form:label path="instructor">Choose Instructor:</form:label>
                	<form:errors class="alert-danger" path="instructor"/>
                	<form:select path="instructor">
                    <c:forEach items="${allTeachers}" var="instructor">
                        <form:option value="${teacher.id}" label="${teacher.firstName}">
                        </form:option> 
                    </c:forEach>
                	</form:select>
					<br>

					<form:label class="col-sm-2 col-form-label" path="credit">Credits: </form:label>
					<form:errors path="credit" class="text-danger"></form:errors>
					<form:input type="number" class="form-control" path="credit"></form:input>	
					
					<form:label class="col-sm-2 col-form-label" path="price">Cost: </form:label>
					<form:errors path="price" class="text-danger"></form:errors>
					<form:input type="number" class="form-control" path="price"></form:input>

					<form:label class="col-sm-2 col-form-label" path="description">Description: </form:label>

					<form:errors path="description" class="text-danger"></form:errors>
					<form:input type="text" class="form-control" path="description"></form:input>	


					<form:label class="col-sm-2 col-form-label" path="price">Cost: </form:label>
					<form:errors path="price" class="text-danger"></form:errors>
					<form:input type="number" class="form-control" path="price"></form:input>		

					
					<form:label class="col-sm-2 col-form-label" path="startDate">Start at: </form:label>
					<form:errors path="startDate" class="text-danger"></form:errors>
					<form:input type="date" class="form-control" path="startDate"></form:input>		

					<form:errors path="credit" class="text-danger"></form:errors>
					<form:input type="text" class="form-control" path="description"></form:input>
					
					
					
					<form:label class="col-sm-2 col-form-label" path="credit">Credit: </form:label>
					<form:errors path="credit" class="text-danger"></form:errors>
					<form:input type="number" class="form-control" path="credit"></form:input>
					
					<form:label class="col-sm-2 col-form-label" path="price">Price: </form:label>
					<form:errors path="credit" class="text-danger"></form:errors>
					<form:input type="number" class="form-control" path="price"></form:input>
					
					<form:label class="col-sm-2 col-form-label" path="required">required: </form:label>
					<form:errors path="credit" class="text-danger"></form:errors>
					<form:input type="text" class="form-control" path="required"></form:input>
						
					
					<form:label class="col-sm-2 col-form-label" path="startDate">Start at: </form:label>
					<form:errors path="startDate" class="text-danger"></form:errors>
					<form:input type="date" class="form-control" path="startDate"></form:input>	
					
					<form:label class="col-sm-2 col-form-label" path="teacher">Select Professor:</form:label>				
					<form:select path = "teacher">
	    				<c:forEach var = "i" items = "${allTeachers}">
	    				<form:option value="${i.id}">${i.firstName} ${i.lastName}</form:option>
	    				</c:forEach>	    	
	    			</form:select>

					
					<div>
						<a href="/dashboard" class="btn btn-info mt-2">Cancel</a>
									
						<input type="submit" class="btn btn-success ms-2 mt-2" value="Submit" />
					
					</div>
				
				</form:form>		
			</div>		
	</div>
</body>
</html>