package com.neusoft.ehr.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neusoft.ehr.entity.Post;
import com.neusoft.ehr.entity.Staff;
import com.neusoft.ehr.service.PostService;
import com.neusoft.ehr.service.StaffService;

public class PostchServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String seq = request.getParameter("seq");
        StaffService ss = new StaffService();
        Staff s = new Staff();
        s = ss.findBySeq(seq);
        
        PostService ps = new PostService();
        Post p = ps.findByPostId(s.getPostId());
        s.setPostName(p.getPost_name());
        HttpSession session = request.getSession();
        session.setAttribute("staff", s);
        request.getRequestDispatcher("/servlet/station_change.jsp").forward(request, response);
	}

}
