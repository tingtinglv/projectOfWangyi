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

public class UserListServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*UserService us = new UserService();
		List<User> userlist = us.findalluser();
		HttpSession session = request.getSession(true);
		session.setAttribute("userlist", userlist);
		request.getRequestDispatcher("/admin.jsp").forward(request, response);*/
		
		int startYear,startMonth,startDay,endYear,endMonth,endDay;//定义各时间
		int currentPage;
		String userName = request.getParameter("userName");//用户账号
		String userActiveState = request.getParameter("userActiveState");//用户授权状态
		String startYearstr = request.getParameter("startYear");//开始年份
		String startMonthstr = request.getParameter("startMonth");//开始月份
		String startDaystr = request.getParameter("startDay");//开始日期
		
		String endYearstr = request.getParameter("endYear");
		String endMonthstr = request.getParameter("endMonth");
		String endDaystr = request.getParameter("endDay");
		
		String currentPagestr = request.getParameter("currentPageNum");
		
		String timeType = request.getParameter("timeType");
		
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
		
		
		
		/* int currentPage=0;
		String currentPagestr = request.getParameter("currentPage");
		if(currentPagestr==null||"".equals(currentPagestr))
		{
			currentPage=1;
		}
		else
		{
			currentPage=Integer.parseInt(currentPagestr);
		}  此处用于确定currentPage 的值*/		
		UserService us = new UserService();
		int totalCount = us.findCountByCondition(startYear, startMonth, startDay, endYear, endMonth, endDay, userName, userActiveState, timeType);
		Page page = PageUtil.createPage(5, totalCount, currentPage);
		request.setAttribute("page",page);
		/*以下将按照页号进行查找*/
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
