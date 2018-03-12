package com.neusoft.ehr.comm;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AdminFilter implements Filter {

	public void destroy() {
		System.out.println("admin Filter has destoryed");
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("admin Filter is working");
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession(true);
		String uidstr = (String)session.getAttribute("uid");
		String uname = (String)session.getAttribute("uname");
		String type  = (String)session.getAttribute("usertype");
		if(uidstr!=null&&!"".equals(uidstr)&&uname!=null&&!"".equals(uname)&&type!=null&&!"".equals(type))
		{
			if(type.equals("admin"))
			{
				chain.doFilter(request, response);
			}
			else
			{
				req.getRequestDispatcher("/illegal.jsp").forward(request, response);
			}
		}
		else
		{
			req.getRequestDispatcher("/illegal.jsp").forward(request, response);
		}
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("admin Filter has inited");
		
	}

}
