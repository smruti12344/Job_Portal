package com.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Bean.JobBean;
import com.DAO.*;
@SuppressWarnings("serial")
@WebServlet("/updateJob")
public class UpdateJobServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		try {
			res.setContentType("text/html");
			//set-type
			JobBean job = new JobBean();
			//obj-userBean-set data-from web
			job.setId(Integer.parseInt(req.getParameter("jobid")));
			job.setTitle(req.getParameter("title"));
			job.setDescriPtion(req.getParameter("desc"));
			job.setCatagory(req.getParameter("catagory"));
			job.setStatus(req.getParameter("status"));
			job.setLocation(req.getParameter("loc"));
			HttpSession session = req.getSession();
			int k=new UpdateJobDAO().updateJob(job);
			if(k>0) {
				session.setAttribute("msg", "job Update Sucessfully..");
				RequestDispatcher rd=req.getRequestDispatcher("View.jsp");
				rd.forward(req, res);
				
			}else {
				session.setAttribute("msg","Something wrong on Server");
				res.sendRedirect("edit_job.jsp");
			}
			

		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	}


