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
					
					<form:label class="col-sm-2 col-form-label" path="description">Description: </form:label>
					<form:errors path="description" class="text-danger"></form:errors>
					<form:input type="text" class="form-control" path="description"></form:input>	
					
					<form:label class="col-sm-2 col-form-label" path="origin">Origin: </form:label>
					<form:errors path="origin" class="text-danger"></form:errors>
					<form:input type="text" class="form-control" path="origin"></form:input>		
					
					<form:label class="col-sm-2 col-form-label" path="meaning">Meaning: </form:label>
					<form:errors path="meaning" class="text-danger"></form:errors>
					<form:textarea type="text" class="form-control" path="meaning"></form:textarea>
					
					<a href="/home" class="btn btn-info mt-2">Cancel</a>				
					<input type="submit" class="btn btn-success ms-2 mt-2" value="Submit" />
				
				</form:form>		
			</div>		
	</div>
</body>
</html>