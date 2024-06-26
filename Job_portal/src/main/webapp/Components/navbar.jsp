 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ page isELIgnored="false" %>
<nav class="navbar bg-dark navbar-expand-lg border-bottom border-body bg-custom" >
  <div class="container-fluid">
    <a class="navbar-brand" href="#">JobPortal</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="index.jsp">Home</a>
        </li>
        
        <c:if test="${user.getRole() eq 'admin' }">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="admin.jsp">Admin</a>
        </li>
           <li class="nav-item">
          <a class="nav-link" href="add_job.jsp"><i class="bi bi-plus-circle-fill me-1"></i>Post jobs</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="View.jsp"><i class="bi bi-eye-fill me-1"></i>View jobs</a>
        </li>
        </c:if>
        
        <c:if test="${user.getRole() eq 'user' }">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="admin.jsp">User</a>
        </li>
  
        <li class="nav-item">
          <a class="nav-link" href="home.jsp"><i class="bi bi-eye-fill me-1"></i>View jobs</a>
        </li>
        </c:if>
        
        
        
      </ul>
      <form class="d-flex" role="search">
      <c:if test="${not empty user }">
            
      <a href="#" > <button class="btn btn-primary me-2 " type="button" data-bs-toggle="modal" data-bs-target="#exampleModal"><i class="bi bi-person-circle me-1"></i>${user.getName() }</button></a>
       <a href="logout"> <button type="button" class="btn btn-primary"><i class="bi bi-box-arrow-in-right me-1"></i>Sign out</button></a>
        </c:if>
        
      <c:if test="${ empty user }">
            
      <a href="signin.jsp" > <button class="btn btn-primary me-2 " type="button"><i class="bi bi-box-arrow-in-right me-1"></i>Sign In</button></a>
       <a href="signup.jsp"> <button type="button" class="btn btn-primary"><i class="bi bi-person-circle me-1"></i>Sign UP</button></a>
        </c:if> 
     
      </form>
    </div>
  </div>
</nav>

<!-- modal-pop -->

<!-- Modal -->
 <c:if test="${not empty user }">
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">${user.getName() }</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <h5 class="card-title">Email:${user.getEmail() }</h5>
         <p class="card-text">Qualification:${user.getQualification() }</p>
            <p class="card-text">Role:${user.getRole() }</p>
            
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#editProfileModal">edit</button>
      </div>
    </div>
  </div>
</div>

<!-- edit modal -->
<div class="modal fade" id="editProfileModal" tabindex="-1" aria-labelledby="editProfileModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="editProfileModalLabel">Edit Profile</h5>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body">
          <!-- Form for editing profile details -->
          <c:if test="${not empty msg }" >
                            
                       <h5 class="text-danger text-center">${msg}</h5>      
                              
                             </div>
                            <c:remove var="msg"/>
                            </c:if>
          <form action="update" method="post">
          <input type="hidden" name="userId" value="${user.getId() }">
            <div class="mb-3">
              <label for="editName" class="form-label">Name</label>
              <input type="text" class="form-control" id="editName" name="name" value="${user.getName() }" placeholder="Enter your name">
            </div>
            <div class="mb-3">
              <label for="editEmail" class="form-label">Email address</label>
              <input type="email" class="form-control" value="${user.getEmail() }" name="email" id="editEmail" placeholder="Enter your email">
            </div>
            <div class="mb-3">
              <label for="editQualification" class="form-label">Qualification</label>
              <input type="text" class="form-control" value="${user.getQualification() }" name="qualification"id="editLocation" placeholder="Enter your location">
            </div>
            <div class="mb-3">
              <label for="editPassword" class="form-label">New Password</label>
              <input type="password" class="form-control" value="${user.getPassWord() }" name="password" id="editLocation" placeholder="Enter your location">
            </div>
            <button type="submit" class="btn btn-primary">Save Changes</button>
          </form>
        </div>
      </div>
    </div>
  </div>

</c:if>
