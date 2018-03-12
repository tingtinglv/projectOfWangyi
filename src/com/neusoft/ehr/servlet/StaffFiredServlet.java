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
import com.neusoft.ehr.entity.Fired;
import com.neusoft.ehr.service.FiredService;

public class StaffFiredServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2266130446440549797L;
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
        FiredService fs = new FiredService();
        Page page = PageUtil.createPage(10, fs.findAllCount(), curPage);//…Ë÷√∑÷“≥
        String empSeq = request.getParameter("empSeq");
        String empName =MyTools.toChinese(request.getParameter("empName"));
        String depName = MyTools.toChinese(request.getParameter("depName"));
        String postName = MyTools.toChinese(request.getParameter("postName"));
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        String firedType = MyTools.toChinese(request.getParameter("firedType"));
        List<Fired> fList = fs.find(page, empSeq, empName, depName, postName, startDate, endDate,firedType);
        request.setAttribute("fList", fList);
        request.setAttribute("page", page);
        request.setAttribute("curPage", curPage);
        request.setAttribute("empSeq", empSeq);
        request.setAttribute("empName", empName);
        request.setAttribute("depName", depName);
        request.setAttribute("postName", postName);
        request.setAttribute("startDate", startDate);
        request.setAttribute("endDate", endDate);
        request.getRequestDispatcher("/servlet/staff_fired.jsp").forward(request, response);
	}

}
