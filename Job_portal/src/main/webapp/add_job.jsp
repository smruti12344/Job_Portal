<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <!--all file links  -->
<%@include file="Components\alllinks.jsp" %>
</head>
<body>
<%@include file="Components\navbar.jsp" %>
<c:if test="${ empty user || user.getRole()!='admin' }">
<c:redirect url="signin.jsp"></c:redirect>            
</c:if>
    <div class="container mt-3">
        <div class="row">
            <div class="col-mid-6 justify-content-center">
                <div class="card">
                    <div class="card-body">
                       
                        <div class="text-center text-success">
                            <i class="bi bi-person-bounding-box "></i>
                            
                            <c:if test="${not empty msg }" >
                            <div class="alert alert-success" role="alert">
                             ${msg}
                              
                             </div>
                            <c:remove var="msg"/>
                            </c:if>
                            <h2 >add jobs</h2>
                        </div>
                        <form action="addJob" method="post">
                            <div class="form-group">
                                <label for="title">Enter Title</label>
                                <input type="text" class="form-control" id="title" name="title" required>
                            </div>
                            <div class="row mt-2">
                                <div class="col ">
                                <label for="location">Location</label>
                                <select name="loc" id="location" class="form-select">
                                    <option value="" selected>Select one</option>
                                    <option value="Odisha">Odisha</option>
                                    <option value="Hydrabad">Hydrabad</option>
                                    <option value="Mumbai">Mumbai</option>
                                    <option value="Banglore">Banglore</option>
                                    <option value="Chennai">Chennai</option>
                                </select>
                                </div>
                                <div class="col">
                                    <label for="Catagory">Catagory</label>
                                    <select name="catagory" id="Catagory" class="form-select">
                                        <option selected>Select one</option>
                                        <option value="IT">IT</option>
                                        <option value="Devloper">Devloper</option>
                                        <option value="Banking">Banking</option>
                                        <option value="Enginner">Engineer</option>
                                        <option value="DigitalMarketing">Digital Marketing</option>
                                    </select>
                                </div>
                                <div class="col">
                                    <label for="Status">Status</label>
                                    <select name="status" id="Status" class="form-select">
                                        <option  selected >Select one</option>
                                        <option value="active">active</option>
                                        <option value="Inactive">Inactive</option>
                                        
                                    </select>
                                </div>
                            </div>
                            <div class="form-group ">
                                <label for="desc">Enter Description</label>
                                <textarea class="form-control" name="desc" id="desc"  rows="10"></textarea>
                            </div>
                            <div class="mt-1 ">
                                <button class="btn btn-success">Publish</button>
                            </div>
                        </form>
                       
                        
                       
                        
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>