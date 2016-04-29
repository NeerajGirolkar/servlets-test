package com.servlets.study;

import java.io.IOException;
import java.net.MalformedURLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/hello", "/hello-servlets"},
			loadOnStartup = 1, name = "Test Servlet",
			asyncSupported = true,
			initParams =
			{
			    @WebInitParam(name = "name", value = "Neeraj"),
			    @WebInitParam(name = "city", value = "California, CA")
			})
public class MyServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	public void init(ServletConfig config) throws ServletException{
		super.init(config);
		System.out.println("Servlet init() method called!");
		System.out.println("Init Parameter Names: " + config.getInitParameterNames().nextElement());
		System.out.println("Context Path: " + config.getServletContext().getContextPath());
		System.out.println("Server Info: " + config.getServletContext().getServerInfo());
		System.out.println("Context Name: " + config.getServletContext().getServletContextName());
		System.out.println("Servlet Registration Details: " + config.getServletContext().getServletRegistration("Test Servlet").getInitParameters().toString());
		try {
			System.out.println("Path of Resource: " + config.getServletContext().getResource("index.html"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}		
	}
	
	@Override
	public void service(HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws ServletException, IOException{
		System.out.println("Servlet service() method called!");
		super.service(httpRequest, httpResponse);
	}

	@Override
	public void doGet(HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws IOException{
		String text = "<html><h1>Hello Servlet, Servlets are fun!</h1></html>" ;
		String initParamName = getInitParameter("name");
		String initParamCity = getInitParameter("city");
		
		Cookie[] cookies = httpRequest.getCookies();
		for(Cookie c : cookies){
			System.out.println("Cookie Name: " + c.getName());
			System.out.println("Cookie Value: " + c.getValue());
		}
		
		HttpSession session = httpRequest.getSession();
		System.out.println("My Servlet - Is Session Existing: " + session.isNew());
		
		httpResponse.getWriter().println(text);
		httpResponse.getWriter().println("Name = " + initParamName);
		httpResponse.getWriter().println("City = " + initParamCity);
		httpResponse.getWriter().flush();
		

	}
	
	@Override
	public void destroy(){
		System.out.println("Servlet destroy() method called!");
		super.destroy();
	}

}
