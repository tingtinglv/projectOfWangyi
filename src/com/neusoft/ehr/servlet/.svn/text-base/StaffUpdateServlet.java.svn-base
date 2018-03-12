package com.neusoft.ehr.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.ehr.comm.MyTools;
import com.neusoft.ehr.entity.Dept;
import com.neusoft.ehr.entity.Post;
import com.neusoft.ehr.entity.Probation;
import com.neusoft.ehr.entity.Staff;
import com.neusoft.ehr.service.DeptService;
import com.neusoft.ehr.service.PostService;
import com.neusoft.ehr.service.ProbationService;
import com.neusoft.ehr.service.StaffService;

public class StaffUpdateServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
/*		 String empSeq=request.getParameter("empSeq");
		 String empName=MyTools.toChinese(request.getParameter("empName"));
		 String empSex=MyTools.toChinese(request.getParameter("empSex"));
		 Date empBirth= Date.valueOf(request.getParameter("empBirth"));
		 String empCard=request.getParameter("empCard") ;
		 Date jobStartDate=Date.valueOf(request.getParameter("jobStartDate"));
		 Date jobDate = Date.valueOf(request.getParameter("jobDate"));
		 String empForms =MyTools.toChinese( request.getParameter("empForms"));
		 String empOrigin = MyTools.toChinese(request.getParameter("empOrigin"));
		 String nation = MyTools.toChinese(request.getParameter("nation"));
		 String nativePlace=MyTools.toChinese(request.getParameter("nativePlace"));
		 String politStatus = MyTools.toChinese(request.getParameter("politStatus"));
		 String empTel=MyTools.toChinese(request.getParameter("empTel"));
		 String email=MyTools.toChinese(request.getParameter("email"));
		 String stature=MyTools.toChinese(request.getParameter("stature"));
		 String bloodType=MyTools.toChinese(request.getParameter("bloodType"));
		 String marriage=MyTools.toChinese(request.getParameter("marriage"));
		 String birthplace= MyTools.toChinese(request.getParameter("birthplace"));
		 String domicilePlace = MyTools.toChinese(request.getParameter("domicilePlace"));
		 String education = MyTools.toChinese(request.getParameter("education"));
		 String degree =MyTools.toChinese(request.getParameter("degree"));
		 String school=MyTools.toChinese(request.getParameter("school"));
		 String major=MyTools.toChinese(request.getParameter("major"));
		 String type="无试用期";
		 String probation = MyTools.toChinese(request.getParameter("probation"));
		 String depSeq=MyTools.getStrInBrackets(request.getParameter("dep"), -1);
		 String postSeq=MyTools.getStrInBrackets(request.getParameter("post"), -1);
		 Date gradDate=null;
		 if(!request.getParameter("gradDate").equals(""))
		 	gradDate=Date.valueOf(request.getParameter("gradDate"));
		 
		 
		 
		//第二步，将其组成java对象。将取到的值填充到对象的属性中去。
		Staff s=new Staff();
		Probation p = new Probation();
		s.setBirthplace(birthplace);
		s.setBloodType(bloodType);
		s.setDegree(degree);
		s.setDomicilePlace(domicilePlace);
		s.setEducation(education);
		s.setEmail(email);
		s.setEmpBirth(empBirth);
		s.setEmpCard(empCard);
		s.setEmpForms(empForms);
		s.setEmpName(empName);
		s.setEmpSeq(empSeq);
		s.setEmpSex(empSex);
		s.setEmpTel(empTel);
		s.setEmpOrigin(empOrigin);
		s.setGradDate(gradDate);
		s.setJobDate(jobDate);
		s.setMajor(major);
		s.setMarriage(marriage);
		s.setNation(nation);
		s.setNativePlace(nativePlace);
		s.setPolitStatus(politStatus);
		s.setSchool(school);
		s.setStartDate(jobStartDate);
		s.setStature(stature);
		s.setType(type);
		//第三步，调用业务层。
				StaffService ss = new StaffService();
				DeptService ds = new DeptService();
				PostService ps = new PostService();
				Dept dp =ds.findbyid(depSeq);
				Post post =ps.findBySeq(postSeq);
				int depId = dp.getDep_id();
				int postId = post.getPost_id();
				s.setDepId(depId);
				s.setPostId(postId);
		boolean judge = ss.update(s);

		request.setAttribute("judge", judge);*/
		
		request.getRequestDispatcher("StaffFindServlet.action").forward(request, response);
	}
}
