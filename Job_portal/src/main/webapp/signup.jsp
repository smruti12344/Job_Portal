<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="Components\alllinks.jsp" %>
</head>
<body>
<%@include file="Components\navbar.jsp" %>

  <div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card">
                <div class="card-body">
                    <h2 class="text-center"><i class="bi bi-person-circle me-2"></i>Sign Up</h2>
                </div>
                
                <c:if test="${not empty msg }">
                  <h4 class="text-center text-success">${msg}</h4>
                  <c:remove var="msg"/>
                </c:if>
                <div class="card-body">
                    <form action="register" method="post">
                        <div class="mb-3">
                            <label for="username" class="form-label">Username</label>
                            <input type="text" class="form-control" id="username" name="username" placeholder="Enter your username" required>
                        </div>
                        <div class="mb-3">
                            <label for="email" class="form-label">Email address</label>
                            <input type="email" class="form-control" id="email" name="email" placeholder="name@example.com" required>
                        </div>
                        <div class="mb-3">
                            <label for="password" class="form-label">Password</label>
                            <input type="password" class="form-control" id="password" name="password" placeholder="Enter your password" required>
                        </div>
                        <div class="mb-3">
                            <label for="confirm-password" class="form-label">Confirm Password</label>
                            <input type="password" class="form-control" id="confirm-password" name="confirm-password" placeholder="Confirm your password" required>
                        </div>
                        <div class="mb-3">
                            <label for="qualification" class="form-label">Qualification</label>
                            <input type="text" class="form-control" id="qualification" name="qualification" placeholder="Enter your qualification" required>
                        </div>
                        <div class="mb-3">
                            <label for="qualification" class="form-label">Role</label>
                            <select  class="form-control" id="role" name="role" placeholder="Select role" required>
                             <option value="admin">Admin</option>
                             <option value="user">User</option>
                            </select>
                        </div>
                        <button type="submit" class="btn btn-success w-100">Sign Up</button>
                        <div class="text-center mt-3">
                            <a href="signin.jsp">Already have an account? Sign in</a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
  </div>



</body>
</html>