package com.Servlet;

import java.io.IOException;
import com.Bean.*;
import com.DAO.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@SuppressWarnings("serial")
@WebServlet("/addJob")
public class RegisterJobServlet extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			res.setContentType("text/html");
			//set-type
			JobBean job = new JobBean();
			//obj-userBean-set data-from web
			job.setTitle(req.getParameter("title"));
			job.setDescriPtion(req.getParameter("desc"));
			job.setCatagory(req.getParameter("catagory"));
			job.setStatus(req.getParameter("status"));
			job.setLocation(req.getParameter("loc"));
			HttpSession session = req.getSession();
			int k=new JobDAO().addJob(job);
			if(k>0) {
				session.setAttribute("msg", "job post Sucessfully..");
				RequestDispatcher rd=req.getRequestDispatcher("add_job.jsp");
				rd.forward(req, res);
				
			}else {
				session.setAttribute("msg","Something wrong on Server");
				res.sendRedirect("add_job.jsp");
			}
			

		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
