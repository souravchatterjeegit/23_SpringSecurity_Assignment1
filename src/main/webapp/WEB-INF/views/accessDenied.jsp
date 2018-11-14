<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page session="true"%>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
        crossorigin="anonymous">        
</head>

<body>
    <div>
        <div class="row form-group"></div>
        <div class="row justify-content-center form-group">
        <div id="navDiv" class="col-md-8 col-sm-8 col-xs-8 col-xs-offset-2 col-md-offset-2 col-sm-offset-2 bg-white border rounded">
            <a href="/23_SpringSecurity_Assignment1/subjects" class="col-md-2">Subjects</a>
            <a href="/23_SpringSecurity_Assignment1/books" class="col-md-1">Books</a>
        </div>
        </div>
        <div class="row justify-content-center form-group">
            <div class="col-md-8 col-sm-8 col-xs-8 col-xs-offset-2 col-md-offset-2 col-sm-offset-2 bg-white border rounded">
                <c:if test="${pageContext.request.userPrincipal.name != null}">
					<div class="alert mt-3 alert-primary" role="alert">
						Welcome : ${pageContext.request.userPrincipal.name} | <a href="<c:url value='/logout' />"> Logout</a>
					</div>
					<br/><br/>	
				</c:if>
                <h2>${msg}</h2> 
                <br/><br/>              
            </div>
        </div>
    </div>
</body>

</html>




