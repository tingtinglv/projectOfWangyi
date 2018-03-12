package com.neusoft.ehr.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neusoft.ehr.entity.Dept;
import com.neusoft.ehr.entity.Post;
import com.neusoft.ehr.service.DeptService;
import com.neusoft.ehr.service.PostService;

public class StaffEntryInfoServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6467249275810072981L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DeptService ds = new DeptService();
		PostService ps = new PostService();
		List<Dept> depList = ds.findall();
		List<Post> postList = ps.findAllPost();
		request.setAttribute("depList", depList);
		request.setAttribute("postList", postList);
		request.getRequestDispatcher("/servlet/staff_entry_info.jsp").forward(request, response);
	}
}
