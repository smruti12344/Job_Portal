<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.Bean.*, com.DAO.*, java.util.*" %>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>All Jobs</title>
    <!--all file links  -->
<%@include file="Components\alllinks.jsp" %>
    <!-- Custom CSS -->
    <style>
        /* Custom styles */
        .job-card {
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
<%@include file="Components\navbar.jsp" %>
    <div class="container-fluid my-4">
        <h2 class="text-center mb-4">All Jobs</h2>


        <div class="row mt-4">
        <%
        String location = request.getParameter("loc");
        String category = request.getParameter("cat");
        
        ArrayList<JobBean>jobs=new ArrayList<JobBean>();
        if("lo".equals(location) && "ct".equals(category)){
        	jobs = new ViewJobDAO().retrive();
        }
        else if("lo".equals(location) || "ct".equals(category)){
        	
        	jobs =new ViewJobDAO().getJobByLocORCat(location, category);
        }else{
        	jobs = new ViewJobDAO().getJobByLocAndCat(location, category);
        }
        
        if(jobs!=null){
        	
        	for(JobBean activeJob : jobs)
    		{%>
    <div class="col-md-6">
    <div class="card job-card">
    <div class="card-body">
        <h5 class="card-title"><%=activeJob.getTitle() %></h5>
        <p class="card-text">Location:<%=activeJob.getLocation() %>,&nbsp;</p>
        <p class="card-text">Category:<%=activeJob.getCatagory() %></p>
        <%
           if(activeJob.getDescriPtion().length()>0 && activeJob.getDescriPtion().length()<120)
           {%>
        	   <p class="card-text">Description:<%=activeJob.getDescriPtion() %><a href="single_page.jsp?id=<%=activeJob.getId()%>">more</a></p>
          <% }
           else
           {%>
        	    <p class="card-text">Description:&nbsp;<%=activeJob.getDescriPtion().substring(0, 120) %>....<a href="single_page.jsp?id=<%=activeJob.getId()%>">more</a></p>
           <% }
        %>
        
        <a href="#" class="btn btn-primary">Apply Now</a>
    </div>
    </div>
    </div>
    <%}
        }
       
        else{
        if(jobs.isEmpty()){%>
        	System.out.println("job null"+jobs);
    	<h1 class="text-danger">jobs not found</h1>
        <% }
        else{%>
        System.out.println("job null"+jobs);
    	<h1 class="text-danger">jobs not found</h1>
        <%} 
        
    }
   		
        
        
        %>
        
        <%
        
             
        %>
           
            <!-- Add more job cards as needed -->
            
        </div>
    </div>

    <footer class="footer mt-auto py-3 bg-light ">
        <div class="container d-flex justify-content-between">
            <span class="text-muted">Contact us: example@email.com | Phone: 123-456-7890</span>
            <div class="float-right">
                <a href="#" class="text-muted">Terms of Service</a> |
                <a href="#" class="text-muted">Privacy Policy</a>
            </div>
        </div>
    </footer>
</body>
</html>







      