<%@page import="com.DB.*" %>
<%@page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="Components\alllinks.jsp" %>
<style type="text/css">
.bgm-img{
background: url("image/img1.jpg");
	width:100%;
	height: 80vh;
	background-repeat:no-repeat;
	background-size:cover;

}
</style>
</head>
<body>
<%@include file="Components\navbar.jsp" %>


 <div class="container-fluid bgm-img mt-2">
 <div class="text-center">
   <h1 class="text-white  p-4">
    <i class="bi bi-journal me-1"></i>Online Job Portal
   </h1>
 </div>
 </div>
 <footer>
 <%@include file="Components\footer.jsp" %>
 </footer>
</body>
</html>