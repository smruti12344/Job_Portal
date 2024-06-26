<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign in</title>
<!--all file links  -->
<%@include file="Components\alllinks.jsp" %>
</head>
<body>
<%@include file="Components\navbar.jsp" %>
   <div class="container mt-5">
        <div class="row justify-content-center">
         
            <div class="col-md-4">
                <div class="card">
                    <div class="card-body">
                        <h2 class="text-center"><i class="bi bi-person-circle me-2"></i>Login</h2>
                   <c:if test="${not empty msg }" >
                            
                       <h5 class="text-danger text-center">${msg}</h5>      
                              
                             </div>
                            <c:remove var="msg"/>
                            </c:if>
                   
                    
                        <form action="login" method="post" class="p-3">
                            <div class="form-group p-2">
                                <label for="username" class="form-label">Username</label>
                                <input type="email" class="form-control" placeholder="xyz@gmail.com" id="username" name="username" required>
                            </div>
                            <div class="form-group p-2">
                                <label for="password" class="form-label">Password</label>
                                <input type="password" class="form-control" id="password" name="password" required>
                            </div>
                            
                            <button type="submit" class="btn btn-primary btn-block w-100">Login</button>
                            <a href="signup.jsp" >Register</a>
                        </form>
                         </div>
                    
                </div>
            </div>
        </div>
    </div>
</body>
</html>