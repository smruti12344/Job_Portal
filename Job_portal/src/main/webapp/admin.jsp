<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:if test="${not empty user }">
       <title>${user.getRole()} page</title>     
        </c:if>

<!--all file links  -->
<%@include file="Components\alllinks.jsp" %>
<style type="text/css">
.bgm-img{
background: url("https://cdn.dribbble.com/users/1946759/screenshots/4596801/media/14aa3cda26d947ab3c73298d9c335c16.png?resize=400x300&vertical=center");
	width:95%;
	height:90vh;
	background-repeat:no-repeat;
	background-size:cover;

}
h1{
color:black;
}
</style>
</head>
<body>
<%@include file="Components\navbar.jsp" %>
<div class="container-fluid bgm-img mt-2">
 <div class="text-center">
   <h1 class="p-4">
   <c:if test="${not empty user }">
      <i class="bi bi-pc-display-horizontal me-3">Welcome&nbsp; ${user.getRole() }&nbsp;${user.getName() }</i>
     
        </c:if>
   
   </h1>
 </div>
 </div>
</body>
</html>