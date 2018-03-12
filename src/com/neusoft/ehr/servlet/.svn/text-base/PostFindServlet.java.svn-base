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

public class PostFindServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2310861084661413925L;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
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
		String post_seq = request.getParameter("post_seq");
		String post_name = request.getParameter("post_name");
		String post_type = request.getParameter("post_type");
		Post post = new Post();
		post.setPost_seq(post_seq);
		post.setPost_name(post_name);
		post.setPost_type(post_type);
		String postR = (String)session.getAttribute("postR");
		if(postR!=null&&postR.equals("ture")){
			int count = ps.count("", "", "");
			Page page = PageUtil.createPage(5, count, currentPage);
			List<Post> post_list = ps.find("", "", "", page);
			session.setAttribute("post_list", post_list);
			System.out.println(post_list);
			session.setAttribute("page",page);
			session.setAttribute("postR","");
			request.getRequestDispatcher("/servlet/station_info.jsp").forward(request, response);
		}else{
		int count = ps.count(post_seq, post_name, post_type);
		Page page = PageUtil.createPage(5, count, currentPage);
		List<Post> post_list = ps.find(post_seq, post_name, post_type, page);
		session.setAttribute("post_list", post_list);
		System.out.println(post_list);
		session.setAttribute("page",page);
		request.getRequestDispatcher("/servlet/station_info.jsp").forward(request, response);
	}
	}

}
