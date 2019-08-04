package com.Iris.GetConfigandContext;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ConfigContext")
public class ConfigContext extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html,charset=UTF-8");
		PrintWriter out = response.getWriter();
		ServletContext ctx = getServletContext();
		
		String s1= ctx.getInitParameter("name");
		String s2 = ctx.getInitParameter("lname");
		
		out.println("Hi");
		out.println(s1+" "+ s2);
		
		ServletConfig cg = getServletConfig();
		out.println(cg.getInitParameter("email"));
		out.println(cg.getInitParameter("worksfor"));
		
		//out.println(s3+" "+s4);
		}
}
