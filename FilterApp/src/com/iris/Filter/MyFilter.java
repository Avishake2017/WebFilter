package com.iris.Filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


@WebFilter("/index.html")
public class MyFilter implements Filter {

   
	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		System.out.println("Inside filter");
	if(id<=0) {
		RequestDispatcher rd = request.getRequestDispatcher("index.html");
		out.println("Invalid ID Enter Again");
		rd.include(request, response);
			}
	else {
		chain.doFilter(request, response);
	}		
	
	if(name.equals("")) {
		RequestDispatcher rd = request.getRequestDispatcher("index.html");
		out.println("Invalid Name Enter Again");
		rd.include(request, response);
	}
	else {
		chain.doFilter(request, response);
	}
}


	public void init(FilterConfig fConfig) throws ServletException {
	
	}

}
