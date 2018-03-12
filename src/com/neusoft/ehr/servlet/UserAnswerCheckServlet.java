package com.neusoft.ehr.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.ehr.comm.MyTools;
import com.neusoft.ehr.entity.User;
import com.neusoft.ehr.service.UserService;

public class UserAnswerCheckServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	
	 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/xml;charset=UTF-8");
		PrintWriter out=response.getWriter(); 
		String uname=request.getParameter("uname"); 
		String answer = MyTools.toChinese(request.getParameter("answer"));
		String email = request.getParameter("email");
		System.out.println(answer+email);
		UserService us  = new UserService();
		User u = us.findbyuname(uname);
		if(answer.equals(u.getAnswer())&&email.equals(u.getEmail()))
		{
			 
				out.print("<response>");
				out.print("<state>success</state>");
				out.print("</response>");//返给ajaxXMLHttpRequest.response文本信息 
				//out.print("<question>"+u.getQuestion()+"</question>");
				//System.out.println(list.size());
				
		}
		else
		{
			out.print("<response>"); 
			out.print("<state>fail</state>");
			out.print("</response>");
		}
		out.close();
		
	}

}
