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

public class AuthFilter implements Filter
{

	public void destroy() {
		System.out.println("AuthFilter has destoryed");
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("AuthFilter is working");
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession();
		String uidstr = (String)session.getAttribute("uid");
		String uname = (String)session.getAttribute("uname");
		String type  = (String)session.getAttribute("usertype");
		if(uidstr!=null&&!"".equals(uidstr)&&uname!=null&&!"".equals(uname)&&type!=null&&!"".equals(type))
		{
			chain.doFilter(request, response);
			
		}
		else
		{
			req.getRequestDispatcher("/illegal.jsp").forward(request, response);
		}
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("AuthFilter has inited");
		
	}

}
