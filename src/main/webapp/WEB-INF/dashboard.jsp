<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
        <h1>Welcome back!</h1>
        <br>
        <a href = "/dashboard">Home</a>
        <a href = "/my_courses">In Progress</a>
        <a href = "/CourseComplete">Completed</a>
		
		<a href="/my_information">My information</a>
        <a href = "/logout">Logout</a>	
        

        <div >


                <tbody>
                    <c:forEach var = "i" items = "${allCourses}">
                        <tr>
                            <td><p> <a href="/oneCourse/${i.id }">
                            <c:out value = "${i.title }"></c:out></a>
                            </p></td>


                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>


    </div>
        <div>
    		<a  href="/courses" class="btn btn-primary mt-5" >Show me All courses!</a>
        </div>

    </div> <!-- End of Container -->
</body>
</html>