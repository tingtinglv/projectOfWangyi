package com.neusoft.ehr.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neusoft.ehr.entity.User;
import com.neusoft.ehr.service.UserService;

public class UserUnloginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int uid = Integer.parseInt((String)request.getParameter("uid"));
		User u = new User();
		u.setUid(uid);
		u.setState("unlogin");
		UserService us = new UserService();
		us.updateState(u);
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect("/neusoft/login.jsp");
		
	}

}
