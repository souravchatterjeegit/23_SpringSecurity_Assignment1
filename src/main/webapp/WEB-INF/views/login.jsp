<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
                <form action="/23_SpringSecurity_Assignment1/login" method="post">
                	<c:if test="${param.error != null}">          
        				<div class="alert mt-3 alert-primary" role="alert">
            				Invalid username and password.  
        				</div>  
    				</c:if>  
    				<c:if test="${param.logout != null}">         
        				<div class="alert mt-3 alert-primary" role="alert">  
            				You have been logged out.  
        				</div>  
    				</c:if>
                    <div class="row form-group mt-3">
                        <label class="col-md-12 control-lable" style="text-align:center"><h3>Please enter Details</h3></label>
                    </div>
                    <div class="row form-group">
                        <label class="col-md-3 control-lable" style="text-align:right" for="username">Username*:</label>
                        <div class="col-md-8">
                            <input type="text" name="username" id="username" class="form-control input-sm" required/>        
                        </div>
                    </div>
                    <div class="row form-group">
                        <label class="col-md-3 control-lable" style="text-align:right" for="password">Password*:</label>
                        <div class="col-md-8">
                            <input type="password" name="password" id="password" class="form-control input-sm" required/>
                            
                        </div>
                    </div>
                    
                    <div class="row">
                        <div class="col-md-3"></div>
                        <div class="col-md-8">
                            <input type="Submit" class="btn btn-success" value="Log In"> 
                            <a class="btn btn-danger" href="/23_SpringSecurity_Assignment1/createUser">Create User</a>          
                        </div>
                    </div>
                </form>
                <div class="row form-group"></div>        
            </div>
        </div>
    </div>
</body> 

</html>