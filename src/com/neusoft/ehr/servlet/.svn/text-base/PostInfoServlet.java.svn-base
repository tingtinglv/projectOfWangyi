package com.neusoft.ehr.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neusoft.ehr.comm.Page;
import com.neusoft.ehr.comm.PageUtil;
import com.neusoft.ehr.entity.Dept;
import com.neusoft.ehr.entity.Post;
import com.neusoft.ehr.service.DeptService;
import com.neusoft.ehr.service.PostService;

public class PostInfoServlet extends HttpServlet {


	/**
	 * 
	 */
	private static final long serialVersionUID = -6235644516378691881L;


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
		Page page = PageUtil.createPage(5, ps.findAllCount(), currentPage);
		List<Post> post_list = ps.findAllPost(page);
		session.setAttribute("postList", post_list);
		request.setAttribute("page",page);
		request.getRequestDispatcher("/servlet/station_info.jsp").forward(request, response);
	}

}
