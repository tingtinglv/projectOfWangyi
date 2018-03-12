package com.neusoft.ehr.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.ehr.comm.MyTools;
import com.neusoft.ehr.comm.Page;
import com.neusoft.ehr.comm.PageUtil;
import com.neusoft.ehr.entity.Probation;
import com.neusoft.ehr.service.ProbationService;

public class StaffPassedServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2106448880785772436L;
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
        ProbationService ps = new ProbationService();
        Page page = PageUtil.createPage(10, ps.findAllCount(), curPage);//设置分页
        String empSeq = request.getParameter("empSeq");
        String empName =MyTools.toChinese(request.getParameter("empName"));
        String depName = MyTools.toChinese(request.getParameter("depName"));
        String postName = MyTools.toChinese(request.getParameter("postName"));
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        List<Probation> pbList = ps.find(page, empSeq, empName, depName, postName, startDate, endDate, "bwtcheck","转正");
        request.setAttribute("pbList", pbList);
        request.setAttribute("page", page);
        request.setAttribute("curPage", curPage);
        request.setAttribute("empSeq", empSeq);
        request.setAttribute("empName", empName);
        request.setAttribute("depName", depName);
        request.setAttribute("postName", postName);
        request.setAttribute("startDate", startDate);
        request.setAttribute("endDate", endDate);
        request.getRequestDispatcher("/servlet/staff_passed.jsp").forward(request, response);
	}

}
