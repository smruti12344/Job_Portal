<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.Bean.*, com.DAO.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!--all file links  -->
<%@include file="Components\alllinks.jsp" %>
</head>
<body>
<%@include file="Components\navbar.jsp" %>
<div class="container mt-4">
        <div class="row">
            <div class="col-lg-8 offset-lg-2">
            <%
             int id = Integer.parseInt(request.getParameter("id"));
            JobBean job = new ViewJobDAO().singleJobs(id);
            %>
                <div class="card">
                    <div class="card-body">
                        <h2 class="card-title"><%=job.getTitle() %></h2>
                        <p class="card-text">Description:&nbsp; <%=job.getDescriPtion() %> </p>
                        <p class="card-text">Category: <strong><%=job.getCatagory() %></strong></p>
                        <p class="card-text">Date Posted: <strong><%=job.getpDate() %></strong></p>
                        <a href="#" class="btn btn-success">Apply Now</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>