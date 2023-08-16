package com.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class CharsetFilter
 */
@WebFilter("/*")
public class CharsetFilter extends HttpFilter implements Filter {
       
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	


	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("난 무조건 거치게 되어 있음"); //url pattern이 /* 이기 때문
		HttpServletRequest req=(HttpServletRequest) request; 
		//ServletRequest가 HttpServletRequest보다 상위에 있으므로 down casting 해줘야 함!!
		
		req.setCharacterEncoding("UTF-8");
		chain.doFilter(request, response);
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
