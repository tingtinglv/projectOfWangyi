package com.neusoft.ehr.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.ehr.entity.Dept;
import com.neusoft.ehr.entity.Post;
import com.neusoft.ehr.entity.Staff;
import com.neusoft.ehr.service.DeptService;
import com.neusoft.ehr.service.PostService;
import com.neusoft.ehr.service.StaffService;

public class StaffMaintainServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8935322306999513379L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DeptService ds = new DeptService();
		PostService ps = new PostService();
		StaffService ss = new StaffService();
		String empSeq = request.getParameter("empSeq");
		List<Dept> depList = ds.findall();
		List<Post> postList = ps.findAllPost();
		Staff s = ss.findBySeq(empSeq);
		request.setAttribute("depList", depList);
		request.setAttribute("postList", postList);
		request.setAttribute("staff", s);
		request.getRequestDispatcher("/servlet/staff_info_maintain.jsp").forward(request, response);
	}

}
