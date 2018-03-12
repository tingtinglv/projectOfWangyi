package com.neusoft.ehr.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.ehr.comm.MyTools;
import com.neusoft.ehr.comm.Page;
import com.neusoft.ehr.comm.PageUtil;
import com.neusoft.ehr.entity.Staff;
import com.neusoft.ehr.service.StaffService;

public class StaffFireServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2243424020509156705L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int curPage = 0;
        String currentPagestr = request.getParameter("curPage");
        if(currentPagestr == null || "".equals(currentPagestr)){
        	curPage = 1;
        }else{
        	curPage=Integer.parseInt(currentPagestr);
        }
        StaffService ss= new StaffService();
        Page page = PageUtil.createPage(10, ss.findAllCount(), curPage);//设置分页
        String empSeq = request.getParameter("empSeq");
        String empName =MyTools.toChinese(request.getParameter("empName"));
        String depName = MyTools.toChinese(request.getParameter("depName"));
        String postName = MyTools.toChinese(request.getParameter("postName"));
        List<Staff> staffList = ss.find(page,empSeq,empName,depName,postName);//分页查询
        request.setAttribute("staffList", staffList);
        request.setAttribute("page", page);
        request.setAttribute("curPage", curPage);
        request.setAttribute("empSeq", empSeq);
        request.setAttribute("empName", empName);
        request.setAttribute("depName", depName);
        request.setAttribute("postName", postName);
        request.getRequestDispatcher("/servlet/staff_fire.jsp").forward(request, response);
	}

}
