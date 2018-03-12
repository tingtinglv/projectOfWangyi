package com.neusoft.ehr.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neusoft.ehr.comm.Page;
import com.neusoft.ehr.comm.PageUtil;
import com.neusoft.ehr.service.DeptService;

public class DeptInfoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            doPost(request,response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            int currentPage = 0;
            String currentPagestr = request.getParameter("currentPage");
            if(currentPagestr == null || "".equals(currentPagestr)){
            	currentPage = 1;
            }else{
            	currentPage=Integer.parseInt(currentPagestr);
            }
            DeptService ds = new DeptService();
            Page page = PageUtil.createPage(10, ds.findallcount(), currentPage);
            List list = ds.findall(page);
            HttpSession session = request.getSession();
            session.setAttribute("deptList", list);
            //request.setAttribute("deptList", list);
            session.setAttribute("page", page);
            request.getRequestDispatcher("/servlet/department_info.jsp").forward(request, response);
	}

}



























