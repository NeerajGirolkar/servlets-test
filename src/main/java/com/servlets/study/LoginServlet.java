package com.servlets.study;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javax.servlet.http.Cookie;

@WebServlet(urlPatterns = {"/login"}, loadOnStartup = 1)
public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig config) throws ServletException{
		super.init(config);
		System.out.println("Loading Login Servlet");
	}
	
	@Override
	public void doPost(HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws IOException, ServletException{
		String username = httpRequest.getParameter("username");
		String password = httpRequest.getParameter("password");
		if(username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("root")){
			HttpSession session = httpRequest.getSession(false);
			if(null == session){
				session = httpRequest.getSession();
			}
			System.out.println("Login Servlet - Is Session Existing: " + session.isNew());
			session.setAttribute("user", "admin");
			session.setMaxInactiveInterval(15);
			Cookie cookie = new Cookie("UserCookie", "TestCookie");
			httpResponse.addCookie(cookie);
			httpResponse.sendRedirect("LoginSuccess.jsp");
		} else {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
            PrintWriter out= httpResponse.getWriter();
            out.println("<font color=red>Either user name or password is wrong.</font>");
            rd.include(httpRequest, httpResponse);
		}
	}
	
	@Override
	public void destroy(){
		System.out.println("Destroying Login Servlet!");
		super.destroy();
	}
}
