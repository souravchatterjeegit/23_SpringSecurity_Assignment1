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
				</c:if>
                <form action="/23_SpringSecurity_Assignment1/saveBook" method="post">
                    <div class="alert mt-3 alert-primary" role="alert">
                        ${message}
                    </div>
                    <div class="row form-group mt-3">
                        <label class="col-md-12 control-lable" style="text-align:center"><h3>Please enter Details</h3></label>
                    </div>
                    <div class="row form-group">
                        <label class="col-md-3 control-lable" style="text-align:right" for="bookTitle">Book title*:</label>
                        <div class="col-md-8">
                            <input type="text" name="bookTitle" class="form-control input-sm" required/>        
                        </div>
                    </div>
                    <div class="row form-group">
                        <label class="col-md-3 control-lable" style="text-align:right" for="price">price*:</label>
                        <div class="col-md-8">
                            <input type="number" name="price" class="form-control input-sm" required/>
                            
                        </div>
                    </div>
                    <div class="row form-group">
                        <label class="col-md-3 control-lable" style="text-align:right" for="volume">volume*:</label>
                        <div class="col-md-8">
                            <input type="number" name="volume" class="form-control input-sm" required/>
                            
                        </div>
                    </div>
                    <div class="row form-group">
                        <label class="col-md-3 control-lable" style="text-align:right" for="subjectId">Subject:</label>
                        <div class="col-md-8">
                            <select name="subjectId" class="form-control input-sm" >
                            	<option value="0"></option>
                            	<c:forEach var="subject" items="${listSubject}" varStatus="status"> 
                            		<option value="${subject.subjectId}">${subject.subtitle}</option>
                            	</c:forEach>
                            </select>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-3"></div>
                        <div class="col-md-8">
                            <input type="Submit" class="btn btn-success" value="Create a Book">           
                        </div>
                    </div>
                </form>
                <div class="row form-group"></div>
                <form action="/23_SpringSecurity_Assignment1/searchBook" method="post">
                <div class="input-group mb-3">
                	
                    <div class="col-md-8">
                        <input type="text" class="form-control" placeholder="Enter for search" name="searchBox" required>
                    </div>
                    <div class="col-md-3">
                        <input type="Submit" class="btn btn-success" value="Search"/>
                        <a class="btn btn-danger" href="/23_SpringSecurity_Assignment1/books">Clear Search</a> 
                    </div>
                    
                </div>
                </form>
                <table class="table table-bordered">
                    <thead>
                        <tr> 
                        	<th class="col-xs-1">ID</th> 	
                            <th class="col-xs-2">Title</th>
                            <th class="col-xs-2">Price</th>
                            <th class="col-xs-2">Volume</th>
                            <th class="col-xs-3">Publish Date</th>
                            <th class="col-xs-2">Controls</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="book" items="${listBook}" varStatus="status">
                		<tr>
                			<td>${book.bookId}</td>
                    		<td>${book.title}</td>
                    		<td>${book.price}</td>
                    		<td>${book.volume}</td>
                    		<td>${book.publishDate}</td>
                    		<td>
                        		<a href="/23_SpringSecurity_Assignment1/deleteBook?bookId=${book.bookId}">Delete</a>
                    		</td>
                             
                		</tr>
                		</c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</body>

</html>




