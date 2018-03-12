package com.neusoft.ehr.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neusoft.ehr.comm.MyTools;
import com.neusoft.ehr.comm.Page;
import com.neusoft.ehr.comm.PageUtil;
import com.neusoft.ehr.entity.Dept;
import com.neusoft.ehr.service.DeptService;

public class DeptSeleServlet extends HttpServlet {
    
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            //ȡֵ
		String seq = request.getParameter("seq");
		String name = MyTools.toChinese(request.getParameter("name"));
		String type = MyTools.toChinese(request.getParameter("type"));
		 int currentPage = 0;
         String currentPagestr = request.getParameter("currentPage");
         if(currentPagestr == null || "".equals(currentPagestr)){
         	currentPage = 1;
         }else{
         	currentPage=Integer.parseInt(currentPagestr);
         }
         DeptService ds = new DeptService();
         if(!seq.equals("")){
        	 Page page = PageUtil.createPage(10, 1, currentPage);
        	 Dept d = ds.findbyid(seq);
        	 List list = new ArrayList();
        	 list.add(d);
             HttpSession session = request.getSession();
             session.setAttribute("deptList", list);
             //request.setAttribute("deptList", list);
             session.setAttribute("page", page);
             session.setAttribute("seleseq",seq);
             session.setAttribute("selename", name);
             session.setAttribute("seletype", type);
         }else{
	         Page page = PageUtil.createPage(10, ds.selectcount(seq, name, type), currentPage);
	         //System.out.println(page.getTotalPage());
	         //System.out.println(ds.selectcount(seq, name, type));
	         List list = ds.select(seq, name, type, page);
	         HttpSession session = request.getSession();
	         session.setAttribute("deptList", list);
	         //request.setAttribute("deptList", list);
	         session.setAttribute("page", page);
	         session.setAttribute("seleseq",seq);
	         session.setAttribute("selename", name);
	         session.setAttribute("seletype", type);
         }
         request.getRequestDispatcher("/servlet/department_info.jsp").forward(request, response);
	}

}
