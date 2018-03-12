package com.neusoft.ehr.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neusoft.ehr.comm.MyTools;
import com.neusoft.ehr.entity.User;
import com.neusoft.ehr.service.UserService;

public class UserRegistServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String reguname =request.getParameter("reguname");
		String regpwd = request.getParameter("regpwd");
		String question =MyTools.toChinese(request.getParameter("question"));
		String answer = MyTools.toChinese(request.getParameter("answer"));
		String email = request.getParameter("email");
		UserService us = new UserService();
		User u = new User();
		u.setUname(reguname);
		u.setPwd(regpwd);
		u.setQuestion(question);
		u.setAnswer(answer);
		u.setEmail(email);
		u.setType("manager");
		u.setActiveState("unactive");
		boolean result = us.register(u);
		if(result == true)
		{
			request.setAttribute("regresult", "success");
		}
		else 
		{
			request.setAttribute("regresult", "fail");
		}
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

}
