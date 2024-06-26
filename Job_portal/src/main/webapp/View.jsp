<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.DAO.*, com.Bean.*,java.util.*" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin:View job</title>
<!--all file links  -->
<%@include file="Components\alllinks.jsp" %>
</head>
<body style="background-color: #f0f1f2">
<%@include file="Components\navbar.jsp" %>
<c:if test="${ empty user || user.getRole()!='admin' }">
<c:redirect url="signin.jsp"></c:redirect>            
</c:if>

 <header class="bg-dark text-white py-4">
    <div class="container text-center">
      <h1 class="mb-0">Job Listings</h1>
    </div>
  </header>
  <div class="container mt-4">
    <div class="row">
     <c:if test="${not empty msg }" >
                            <div class="alert alert-success" role="alert">
                             ${msg}
                              
                             </div>
                            <c:remove var="msg"/>
                            </c:if>
    <%
    ViewJobDAO views = new ViewJobDAO();
    ArrayList<JobBean>jobs = views.retrive();
    for(JobBean job : jobs)
    {%>
      
       
      <div class="col-md-6">
        <div class="card   mb-4">
          <div class="card-body">
            <h5 class="card-title text-capitalize"><%=job.getTitle() %></h5>
            <p class="card-text">Location: <%=job.getLocation() %>,&nbsp;<%=job.getCatagory() %>,&nbsp;<span class="card-title"><%=job.getStatus() %></span></p>
            <p class="card-text">Description: <%=job.getDescriPtion() %></p>
            <!-- Edit and Delete Buttons -->
            <div class="d-flex justify-content-between align-items-center">
              <div class="btn-group">
                <a href="edit_job.jsp?id=<%=job.getId() %>" class="btn btn-sm btn-outline-secondary" role="button">Edit</a>
                <a href="delete?id=<%=job.getId() %>" class="btn btn-sm btn-outline-secondary" role="button">Delete</a>
              </div>
              <small class="text-muted">Date:<%=job.getpDate() %></small>
            </div>
          </div>
          <div class="p-3">
            <a href="#" class="btn btn-primary">Apply Now</a>
          </div>
        </div>
      </div>
      
    
    <% }
    %>
     </div>
    <!-- More job listings here -->
  </div>
</body>
</html>