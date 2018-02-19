

package com.wipro.pos.controller;


import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet Filter implementation class SessionFilter
 */
@WebFilter("*.htm")
public class SessionFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public SessionFilter () {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @see Filter#destroy()
	 */
	@Override
	public void destroy () {
		// TODO Auto-generated method stub
	}
	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	@Override
	public void doFilter (final ServletRequest request, final ServletResponse response, final FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session = httpRequest.getSession();
		String uri = httpRequest.getRequestURI();
		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex + 1); // execute an action
		System.out.println("url::" + action);
		System.out.println(session.getAttribute("userID"));
		if (!action.equals("login.htm") && !action.equals("Registration.htm") && !action.equals("Aboutus.htm")
				&& !action.equals("Contactus.htm") && session.getAttribute("userID") == null) {
			session.setAttribute("Session", "Your Session Expired,Please Login ");
			System.out.println("session expired");
			RequestDispatcher dispatch = httpRequest.getRequestDispatcher("/index.jsp");
			dispatch.include(httpRequest, httpResponse);
			httpResponse.sendRedirect("index.jsp");
		} else {
			chain.doFilter(request, response);
		}
	}
	/**
	 * @see Filter#init(FilterConfig)
	 */
	@Override
	public void init (final FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
}
