package com.neusoft.ehr.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neusoft.ehr.comm.MyTools;
import com.neusoft.ehr.comm.Page;
import com.neusoft.ehr.comm.PageUtil;
import com.neusoft.ehr.service.DepchService;

public class ReportDepchServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//È¡Öµ
		String syear = request.getParameter("syear");  
		String smonth = request.getParameter("smonth"); 
		String sday = request.getParameter("sday");
		String sdate = syear+"-"+smonth+"-"+sday;
		
		String eyear = request.getParameter("eyear"); 
		String emonth = request.getParameter("emonth"); 
		String eday = request.getParameter("eday");
		String edate = eyear+"-"+emonth+"-"+eday;
		
		String empseq = request.getParameter("empseq"); 
		String empname = MyTools.toChinese(request.getParameter("empname")); 
		String type = MyTools.toChinese(request.getParameter("type")); 
		//²Ù×÷
		DepchService dcs = new DepchService();
		int currentPage = 0;
        String currentPagestr = request.getParameter("currentPage");
        if(currentPagestr == null || "".equals(currentPagestr)){
        	currentPage = 1;
        }else{
        	currentPage=Integer.parseInt(currentPagestr);
        }
        Page page = PageUtil.createPage(10, dcs.selecount(sdate, edate, empname, empseq, type), currentPage);
		List list = dcs.sele(sdate, edate, empname, empseq, type, page);
		HttpSession session = request.getSession(true);
		session.setAttribute("page", page);
		session.setAttribute("findList", list);
	    session.setAttribute("syear", syear);
	    session.setAttribute("smonth", smonth);
	    session.setAttribute("sday", sday);
	    session.setAttribute("eyear", eyear);
	    session.setAttribute("emonth", emonth);
	    session.setAttribute("eday", eday);
	    session.setAttribute("empseq", empseq);
	    session.setAttribute("empname", empname);
	    session.setAttribute("type", type);
	    request.getRequestDispatcher("/servlet/staff_depch_report.jsp").forward(request, response);
		
	}

}
