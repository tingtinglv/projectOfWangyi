package com.neusoft.ehr.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neusoft.ehr.comm.Page;
import com.neusoft.ehr.comm.PageUtil;
import com.neusoft.ehr.entity.Post;
import com.neusoft.ehr.entity.Postch;
import com.neusoft.ehr.entity.Staff;
import com.neusoft.ehr.service.PostService;
import com.neusoft.ehr.service.PostchService;
import com.neusoft.ehr.service.StaffService;

public class PostChangedServlet extends HttpServlet {


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
		PostchService ps = new PostchService();
		Page page = PageUtil.createPage(5, ps.findAllCount(), currentPage);
		List<Postch> post_list = ps.findAllPostch(page);
		StaffService ss = new StaffService();
		PostService posts = new PostService();
		if(post_list.size()>0){
		    Iterator it = post_list.iterator();
		    while(it.hasNext()){
		        Postch p = (Postch)it.next();
		        Staff s = ss.findById(p.getEmp_id());
		        p.setEmp_name(s.getEmpName());
		        Post post = posts.findByPostId(p.getOld_postid());
		        p.setOld_postname(post.getPost_name());
		        post = posts.findByPostId(p.getPostch_postid());
		        p.setPostch_postname(post.getPost_name());
		        }
		    }
		HttpSession session = request.getSession();
		session.setAttribute("postchList", post_list);
		session.setAttribute("page", page);
		request.setAttribute("page",page);
		request.getRequestDispatcher("/servlet/station_changed.jsp").forward(request, response);
	}

}
