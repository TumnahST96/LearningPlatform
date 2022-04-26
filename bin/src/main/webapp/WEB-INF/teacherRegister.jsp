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
	<title>teacher register</title>
	
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/main.js"></script>
</head>
<body>
	<div class="container-sm">
		<div class="header">
			<h1>Welcome to the staff and admin board!</h1>
		</div>
		<div class="">
			<div>
				<form:form action="/teacher_save" method="POST" modelAttribute="teacher">
							
					<form:label class="col-sm-2 col-form-label" path="firstName">First Name: </form:label>
					<form:errors path="firstName" class="text-danger" />
					<form:input type="text" class="form-control" path="firstName"></form:input>
					
					<form:label class="col-sm-2 col-form-label" path="lastName">Last Name: </form:label>
					<form:errors path="lastName" class="text-danger" />
					<form:input type="text" class="form-control" path="lastName"></form:input>
					
					<form:label class="col-sm-2 col-form-label" path="email">Email: </form:label>
					<form:errors path="email" class="text-danger"></form:errors>
					<form:input type="text" class="form-control" path="email"></form:input>		
					
					<form:label class="col-sm-2 col-form-label" path="password">Password: </form:label>
					<form:errors path="password" class="text-danger"></form:errors>
					<form:input type="password" class="form-control" path="password"></form:input>	
					
					<form:label class="col-sm-2 col-form-label" path="confirm">Confirm: </form:label>
					<form:errors path="confirm" class="text-danger"></form:errors>
					<form:input type="password" class="form-control" path="confirm"></form:input>	
					
					<form:label class="col-sm-3 col-form-label" path="subject">What subject would you like to teach? </form:label>
					<form:errors path="subject" class="text-danger"></form:errors>
					<form:input type="text" class="form-control" path="subject"></form:input>
					
					<form:label class="col-sm-3 col-form-label" path="education">What college did you study at? </form:label>
					<form:errors path="education" class="text-danger"></form:errors>
					<form:input type="text" class="form-control" path="education"></form:input>
							
					<form:label class="col-sm-3 col-form-label" path="major">What college did you study at? </form:label>
					<form:errors path="major" class="text-danger"></form:errors>
					<form:input type="text" class="form-control" path="major"></form:input>
										
					<input type="submit" class="btn btn-success mt-5" value="Submit" />
				
				</form:form>		
			</div>		
		</div>
	</div>
</body>
</html>