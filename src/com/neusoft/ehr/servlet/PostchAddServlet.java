package com.neusoft.ehr.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.ehr.comm.MyTools;
import com.neusoft.ehr.entity.Post;
import com.neusoft.ehr.entity.Postch;
import com.neusoft.ehr.entity.Staff;
import com.neusoft.ehr.service.PostService;
import com.neusoft.ehr.service.PostchService;
import com.neusoft.ehr.service.StaffService;

public class PostchAddServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Postch postch=new Postch();
		String empSeq = request.getParameter("empSeq");
		String empName = MyTools.toChinese(request.getParameter("empName"));
		String oldPost = MyTools.toChinese(request.getParameter("oldPost"));
		String newPost = MyTools.toChinese(request.getParameter("newPost"));
		String reason = MyTools.toChinese(request.getParameter("reason"));
		String ps = MyTools.toChinese(request.getParameter("ps"));
		String type = MyTools.toChinese(request.getParameter("type"));
		String mode = MyTools.toChinese(request.getParameter("mode"));
		String time = request.getParameter("date");
		Date trantime= Date.valueOf(time);
		//��ѯԱ����ID
		StaffService ss = new StaffService();
		Staff s = ss.findBySeq(empSeq);
		postch.setEmp_id(s.getEmpId());
		//ԭ��λ��ID
		PostService posts = new PostService();
		Post p =posts.findByName(oldPost);
		postch.setOld_postid(p.getPost_id());
		//�ָ�λ ��ID
		p =posts.findByName(newPost);
		postch.setPostch_postid(p.getPost_id());
		postch.setReason(reason);
		postch.setReviews(ps);
		postch.setTrance_type(type);
		postch.setTrantime(trantime);
		postch.setTrance_mode(mode);
		//����Postch����
		PostchService pss =new PostchService();
		pss.add(postch);
		//�޸�Ա����λ��Ϣ
		PostService pse = new PostService();
		Post post = pse.findBySeq(newPost);
		s.setPostId(p.getPost_id());
		s.setPostName(post.getPost_name());
		ss.update(s);
		//��ת
		request.getRequestDispatcher("/PostChangedServlet.action").forward(request, response);
		
	}

}
