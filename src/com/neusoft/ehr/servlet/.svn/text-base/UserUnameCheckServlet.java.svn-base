package com.neusoft.ehr.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.ehr.comm.MyTools;
import com.neusoft.ehr.entity.User;
import com.neusoft.ehr.service.UserService;

public class UserUnameCheckServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		
		response.setContentType("text/xml;charset=UTF-8");
		PrintWriter out=response.getWriter(); 
		String uname=request.getParameter("uname"); 
		System.out.println("进入UnameCheckServlet"+uname);
		UserService us  = new UserService();
		User u = us.findbyuname(uname);
		if(u!=null)
		{
			 
				out.print("<response>");
				out.print("<state>success</state>");
				out.print("<question>"+u.getQuestion()+"</question>");
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
