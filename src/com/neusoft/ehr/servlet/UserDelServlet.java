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
import com.neusoft.ehr.entity.User;
import com.neusoft.ehr.service.UserService;

public class UserDelServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
int uid, startYear, startMonth, startDay, endYear, endMonth, endDay,currentPage;
		
		uid = Integer.parseInt(request.getParameter("uid"));
		String startYearstr= request.getParameter("startYear");
		String startMonthstr= request.getParameter("startMonth");
		String startDaystr= request.getParameter("startDay");
		String endYearstr= request.getParameter("endYear");
		String endMonthstr= request.getParameter("endMonth");
		String endDaystr= request.getParameter("endDay");
		String currentPagestr= request.getParameter("currentPage");
		String timeType = request.getParameter("timeType");
		String userActiveState = request.getParameter("userActiveState");
		String userName=request.getParameter("userName");
		
		UserService us = new UserService();
		boolean result = us.del(uid);
		if(userName==null||"".equals(userName))
		{
			userName="";
		}
		if(userActiveState==null||userActiveState.equals("none"))
		{
			userActiveState ="";
		}
		
		if(startYearstr==null||"".equals(startYearstr))
		{
			startYear=0;
		}
		else
		{
			startYear=Integer.parseInt(startYearstr);
		}
		
		if(startMonthstr==null||"".equals(startMonthstr))
		{
			startMonth=0;
		}
		else
		{
			startMonth=Integer.parseInt(startMonthstr);
		}
		
		if(startDaystr==null||"".equals(startDaystr))
		{
			startDay=0;
		}
		else
		{
			startDay=Integer.parseInt(startDaystr);
		}
		
		if(endYearstr==null||"".equals(endYearstr))
		{
			endYear=0;
		}
		else
		{
			endYear=Integer.parseInt(endYearstr);
		}
		if(endMonthstr==null||"".equals(endMonthstr))
		{
			endMonth=0;
		}
		else
		{
			endMonth=Integer.parseInt(endMonthstr);
		}
		if(endDaystr==null||"".equals(endDaystr))
		{
			endDay=0;
		}
		else
		{
			endDay=Integer.parseInt(endDaystr);
		}
		if(currentPagestr==null||"".equals(currentPagestr))
		{
			currentPage=1;
		}
		else
		{
			currentPage=Integer.parseInt(currentPagestr);
		}
		if(timeType==null||timeType.equals("notbytime"))
		{
			timeType="";
		}
		int totalCount = us.findCountByCondition(startYear, startMonth, startDay, endYear, endMonth, endDay, userName, userActiveState, timeType);
		Page page = PageUtil.createPage(5, totalCount, currentPage);
		request.setAttribute("page",page);
		List<User> userlist = us.findByCondition(page, startYear, startMonth, startDay, endYear, endMonth, endDay, userName, userActiveState, timeType);
		HttpSession session= request.getSession(true);
		session.setAttribute("userlist",userlist);
		session.setAttribute("startYear",startYear+"");
		session.setAttribute("startMonth",startMonth+"");
		session.setAttribute("startDay",startDay+"");
		session.setAttribute(" endYear", endYear+"");
		session.setAttribute("endMonth",endMonth+"");
		session.setAttribute("endDay",endDay+"");
		session.setAttribute("userName",userName);
		session.setAttribute("userActiveState",userActiveState);
		session.setAttribute("timeType",timeType);
		session.setAttribute("currentPage", page.getCurrentPage()+"");
		request.getRequestDispatcher("/servlet/admin.jsp").forward(request, response);
	}

}
