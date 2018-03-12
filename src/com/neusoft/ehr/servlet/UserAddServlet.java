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
		//��һ������jspҳ����ȡ���ı����������ֵ��
		String uname=request.getParameter("uname");
		String pwd=request.getParameter("pwd");
		//�ڶ������������java���󡣽�ȡ����ֵ��䵽�����������ȥ��
		User u=new User();
		u.setUname(uname);
		u.setPwd(pwd);
		//������������ҵ��㡣
		UserService us=new UserService();
		//us.register(u);
		//���Ĳ���ת����ת�������ɹ�ҳ���ϡ���ʱ�� ��Ϊ�������� servlet���ν����ˡ�
		//request.getRequestDispatcher("/useraddok.jsp").forward(request, response);
		request.getRequestDispatcher("/servlet/register.jsp").forward(request, response);
	}

}
