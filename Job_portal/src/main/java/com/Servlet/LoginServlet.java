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
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	@Override
protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		   //set-content
				res.setContentType("text/html");
//				
//				//create obj of AdminBean
//				
//				if(ub==null) {
//					pw.println("invalid Admin Login process..<br>");
//					RequestDispatcher rd = req.getRequestDispatcher("home.html");
//					rd.include(req, res);
//				}
//				else {
//					
//				}
		     HttpSession session = req.getSession();
		
		try {
			String user = req.getParameter("username");
			String password = req.getParameter("password");
			
//			if(user.equals("admin@gmail.com")&& password.equals("1234")) {
//				session.setAttribute("admin", user);
//				RequestDispatcher rd = req.getRequestDispatcher("admin.jsp");
//				rd.include(req, res);
//			}
			
				UserBean ub = new UserLoginDAO().login(user,password);
				if(ub!=null) {
					session.setAttribute("user", ub);
					RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
					rd.include(req, res);
				}else {
					session.setAttribute("msg", "Invalid Email & Password");
					RequestDispatcher rd = req.getRequestDispatcher("signin.jsp");
					rd.include(req, res);
					
				}
				
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
