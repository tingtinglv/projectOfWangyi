package com.neusoft.ehr.servlet;

import java.io.IOException;
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
import com.neusoft.ehr.entity.Post;
import com.neusoft.ehr.entity.Staff;
import com.neusoft.ehr.service.DeptService;
import com.neusoft.ehr.service.PostService;
import com.neusoft.ehr.service.StaffService;

public class PostStaffServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4286483941852314039L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int currentPage = 0;
		String currentPagestr = request.getParameter("currentPage");
		if(currentPagestr==null||currentPagestr.equals("")){
			currentPage = 1;
		}
		else{
			currentPage = Integer.parseInt(currentPagestr);
		}
		DeptService ds = new DeptService();
		PostService ps = new PostService();
		List<Dept> depList = ds.findall();
		List<Post> postList = ps.findAllPost();
		HttpSession session = request.getSession();
		session.setAttribute("depList", depList);
		session.setAttribute("postList", postList);
		String empSeq = request.getParameter("empSeq");
		String empName = MyTools.toChinese(request.getParameter("empName"));
		String depName = MyTools.toChinese(request.getParameter("depName"));
		String postName = MyTools.toChinese(request.getParameter("postName"));
		StaffService ss = new StaffService();
		Page page = PageUtil.createPage(5, ss.findAllCount(), currentPage);
		List<Staff> list = ss.find(page, empSeq, empName, depName, postName);
		session.setAttribute("post_staff_list", list);
		session.setAttribute("page",page);
		session.setAttribute("currentPage", currentPage);
        session.setAttribute("empSeq", empSeq);
        session.setAttribute("empName", empName);
        session.setAttribute("depName", depName);
        session.setAttribute("postName", postName);
		request.getRequestDispatcher("/servlet/station_staff_info.jsp").forward(request, response);
	}
}
