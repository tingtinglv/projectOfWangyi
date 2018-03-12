package com.neusoft.ehr.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neusoft.ehr.entity.User;
import com.neusoft.ehr.service.UserService;

public class UserLoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String pwd = request.getParameter("pwd");
		UserService us = new UserService();
		User u = new User();
		u.setPwd(pwd);
		u.setUname(uname);
		User u1 = us.login(u);
		if(u1==null)
		{
			
			request.setAttribute("logresult","mistake");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		else if(u1.getActiveState().equals("unactive"))
		{
			
			request.setAttribute("logresult","unactive");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		else if(u1.getState().equals("login"))
		{
			//已有用户登录，防止重复登录
			request.setAttribute("logresult","login");//返回已有登陆的提示
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		else
		{
			//u1.setState("login");此处用于设置登陆状态，由于技术限制，无法实现
			//us.updateState(u1);
			HttpSession session = request.getSession(true);
			session.setAttribute("uname",u1.getUname());
			session.setAttribute("uid",u1.getUid()+"");
			session.setAttribute("usertype",u1.getType());
			if(u1.getType().equals("admin"))
			{
				
				request.getRequestDispatcher("/UserListServlet.do").forward(request, response);
			}
			else 
			{
				
				request.getRequestDispatcher("/servlet/index.jsp").forward(request, response);
			}
		}
		
		
	}

}
