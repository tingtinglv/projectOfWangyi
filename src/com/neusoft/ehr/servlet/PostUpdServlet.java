package com.neusoft.ehr.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neusoft.ehr.entity.Post;
import com.neusoft.ehr.service.PostService;

public class PostUpdServlet extends HttpServlet {


	/**
	 * 
	 */
	private static final long serialVersionUID = -5613836255099660334L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String post_id = request.getParameter("post_id");
		PostService ps = new PostService();
		int ppost_id=Integer.parseInt(post_id);
		Post post = ps.findByPostId(ppost_id);
		HttpSession session = request.getSession();
		session.setAttribute("post", post);
		request.getRequestDispatcher("/servlet/station_alter.jsp").forward(request, response);
	}

}
