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
import com.neusoft.ehr.service.StaffService;

public class DepChFindServlet extends HttpServlet {
        
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            doPost(request,response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        //取值
		String seq = request.getParameter("seq");
        String name = MyTools.toChinese(request.getParameter("name"));
        String depname = MyTools.toChinese(request.getParameter("depname"));
        String postname = MyTools.toChinese(request.getParameter("postname"));
		//处理
        int currentPage = 0;
        String currentPagestr = request.getParameter("currentPage");
        if(currentPagestr == null || "".equals(currentPagestr)){
        	currentPage = 1;
        }else{
        	currentPage=Integer.parseInt(currentPagestr);
        }
        StaffService ss = new StaffService();
        Page page = PageUtil.createPage(10, ss.findAllCount(), currentPage);
        List list = ss.find(page, seq, name, depname, postname);
        HttpSession session = request.getSession();
        session.setAttribute("findList", list);
        //request.setAttribute("deptList", list);
        session.setAttribute("page", page);
        session.setAttribute("findseq",seq);
        session.setAttribute("findname", name);
        session.setAttribute("finddepname", depname);
        session.setAttribute("findpostname", postname);
        request.getRequestDispatcher("/servlet/department_change.jsp").forward(request, response);
        
        
	}

}
