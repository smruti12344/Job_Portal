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
@WebServlet("/register")
public class USerRegisterServlet extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	//set-content
		res.setContentType("text/html");
		
		
		//create obj of AdminBean
		UserBean ub = new UserBean();
		//get data from web and set to bean obj
		ub.setName(req.getParameter("username"));
		ub.setEmail(req.getParameter("email"));
		
		ub.setQualification(req.getParameter("qualification"));
		ub.setRole(req.getParameter("role"));
		
		HttpSession session = req.getSession();
		String cPw = req.getParameter("password");
		if(cPw.matches(req.getParameter("confirm-password"))) {
			ub.setPassWord(cPw);
		}else {
			session.setAttribute("msg","Something wrong on Server");
			res.sendRedirect("signup.jsp");
		}
		
		
		int k=new UserRegisterDAO().register(ub);
		if(k>0) {
			session.setAttribute("msg", "User Register Sucessfully..");
			RequestDispatcher rd=req.getRequestDispatcher("signup.jsp");
			rd.forward(req, res);
			
		}else {
			session.setAttribute("msg","Something wrong on Server");
			res.sendRedirect("signup.jsp");
		}
		
	}


}

