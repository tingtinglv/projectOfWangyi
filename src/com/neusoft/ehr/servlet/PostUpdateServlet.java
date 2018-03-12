package com.neusoft.ehr.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neusoft.ehr.entity.Post;
import com.neusoft.ehr.service.PostService;

public class PostUpdateServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6656374279880176016L;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//第一步，取得表单中值
		String post_id = request.getParameter("post_id");
		String post_seq = request.getParameter("post_seq");
		String post_name = request.getParameter("post_name");
		String post_org = request.getParameter("post_org");
		String post_type = request.getParameter("post_type");
		//第二步，填充实体对象
		Post post = new Post();
		post.setPost_id(Integer.parseInt(post_id));
		post.setPost_seq(post_seq);
		post.setPost_name(post_name);
		post.setPost_org(post_org);
		post.setPost_type(post_type);
		PostService ps = new PostService();
		ps.update(post);
		HttpSession session = request.getSession();
		session.setAttribute("postR", "ture");
		request.getRequestDispatcher("/PostFindServlet.action").forward(request, response);
	}

}
