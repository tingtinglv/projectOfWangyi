package com.neusoft.ehr.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.ehr.entity.User;
import com.neusoft.ehr.service.UserService;

public class UserPwdChangeServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uname = request.getParameter("pwdforuname");
		String pwd = request.getParameter("pwdforpwd");
		User u  = new User();
		u.setUname(uname);
		u.setPwd(pwd);
		UserService us = new UserService();
		boolean result = us.update(u);
		if(result)
		{
			request.setAttribute("pwdforresult", "success");
		}
		else
		{
			request.setAttribute("pwdforresult", "fail");
		}
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

}
