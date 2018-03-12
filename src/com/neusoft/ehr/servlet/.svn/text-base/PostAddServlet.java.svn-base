package com.neusoft.ehr.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neusoft.ehr.entity.Post;
import com.neusoft.ehr.service.PostService;

public class PostAddServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2520209547822136494L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String post_seq = request.getParameter("post_seq");
		String post_name = request.getParameter("post_name");
		String post_org = request.getParameter("post_org");
		String post_type = request.getParameter("post_type");
		PostService ps = new PostService();
		Post p = ps.findBySeq(post_seq);
		String flag = "fail";
		HttpSession session = request.getSession();
		if(p.getPost_name()!=null){
			session.setAttribute("flag", flag);
			request.getRequestDispatcher("/servlet/station_add.jsp").forward(request, response);
		}
		else{
			flag="success";
			session.setAttribute("flag", flag);
			Post post = new Post();
			post.setPost_seq(post_seq);
			post.setPost_name(post_name);
			post.setPost_org(post_org);
			post.setPost_type(post_type);
			ps.add(post);
			session.setAttribute("postR", "ture");
			request.getRequestDispatcher("/PostFindServlet.action").forward(request, response);
		}
	}

}
