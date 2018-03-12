package com.neusoft.ehr.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.ehr.entity.User;
import com.neusoft.ehr.service.UserService;



public class UserAddServlet extends HttpServlet {
 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//第一步，从jsp页面中取得文本框中输入的值。
		String uname=request.getParameter("uname");
		String pwd=request.getParameter("pwd");
		//第二步，将其组成java对象。将取到的值填充到对象的属性中去。
		User u=new User();
		u.setUname(uname);
		u.setPwd(pwd);
		//第三步，调用业务层。
		UserService us=new UserService();
		//us.register(u);
		//第四步，转发跳转，跳到成功页面上。此时， 作为控制器的 servlet责任结束了。
		//request.getRequestDispatcher("/useraddok.jsp").forward(request, response);
		request.getRequestDispatcher("/servlet/register.jsp").forward(request, response);
	}

}
