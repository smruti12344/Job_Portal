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
@WebServlet("/delete")
public class DeleteJobServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			res.setContentType("text/html");
			//set-type
			JobBean job = new JobBean();
			//obj-userBean-set data-from web
			job.setId(Integer.parseInt(req.getParameter("id")));
			HttpSession session = req.getSession();
			int k=new DeleteJobDAO().deleteJob(job);
			if(k>0) {
				session.setAttribute("msg", "job removed Sucessfully..");
				RequestDispatcher rd=req.getRequestDispatcher("View.jsp");
				rd.include(req, res);
				
			}else {
				session.setAttribute("msg","Something wrong on Server");
				res.sendRedirect("View.jsp");
			}
			

		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
