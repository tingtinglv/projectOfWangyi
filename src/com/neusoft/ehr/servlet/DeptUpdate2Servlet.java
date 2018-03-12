package com.neusoft.ehr.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.ehr.comm.MyTools;
import com.neusoft.ehr.entity.Dept;
import com.neusoft.ehr.service.DeptService;

public class DeptUpdate2Servlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取值
		//System.out.println("asd");
		String seq = request.getParameter("seq");
		String name = MyTools.toChinese(request.getParameter("name"));
		String type = MyTools.toChinese(request.getParameter("type"));
		String tel = request.getParameter("tel");
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String desc = MyTools.toChinese(request.getParameter("desc"));
		String updep = MyTools.toChinese(request.getParameter("updep"));
		String fax = request.getParameter("fax");
		//System.out.println(name);
		//将值赋给对象
		String date = year+"-"+month+"-"+day;
		Dept d = new Dept();
		d.setDep_seq(seq);
		d.setDep_name(name);
		d.setDep_type(type);
		d.setDep_tel(tel);
		d.setDep_date(date);
		d.setDep_desc(desc);
		d.setDep_updep(updep);
		d.setDep_fax(fax);
		//调动业务层
		DeptService ds = new DeptService();
		ds.update(d);
		System.out.println("asd");
		//跳转页面
		request.getRequestDispatcher("/DeptSeleServlet.action?seq=&name=&type=").forward(request, response);
	}

}
