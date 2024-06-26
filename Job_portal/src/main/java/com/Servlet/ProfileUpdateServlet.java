package com.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Bean.*;
import com.DAO.*;
@SuppressWarnings("serial")
@WebServlet("/update")
public class ProfileUpdateServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		try {
			res.setContentType("text/html");
			//set-type
			UserBean user = new UserBean();
			//obj-userBean-set data-from web
			user.setId(Integer.parseInt(req.getParameter("userId")));
			user.setName(req.getParameter("name"));
			user.setQualification(req.getParameter("qualification"));
			user.setEmail(req.getParameter("email"));
			user.setPassWord(req.getParameter("password"));
			
			HttpSession session = req.getSession();
			int k=new ProfileUpdateDAO().updateProfile(user);
			if(k>0) {
				RequestDispatcher rd = req.getRequestDispatcher("signin.jsp");
				session.setAttribute("msg", "Profile Update Sucessfully..");
				rd.include(req, res);
				
			}else {
				RequestDispatcher rd = req.getRequestDispatcher("navbar.jsp");
				session.setAttribute("msg","Something wrong on Server");
				rd.include(req, res);
			}
			

		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
