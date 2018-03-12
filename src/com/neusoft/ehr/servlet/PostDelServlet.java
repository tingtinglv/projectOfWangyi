package com.neusoft.ehr.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.ehr.entity.Post;
import com.neusoft.ehr.service.PostService;

public class PostDelServlet extends HttpServlet {


	/**
	 * 
	 */
	private static final long serialVersionUID = 4580179364666039554L;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] pcbx = request.getParameterValues("pcbx");
		PostService ps = new PostService();
		Post post = new Post();
		for(int i = 0;i<pcbx.length;i++)
		{
			post.setPost_id(Integer.parseInt(pcbx[i]));
			ps.del(post);
		}
		request.getRequestDispatcher("/PostInfoServlet.action").forward(request, response);
	}

}
