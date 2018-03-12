package com.neusoft.ehr.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.ehr.comm.MyTools;
import com.neusoft.ehr.entity.*;
import com.neusoft.ehr.service.DepchService;
import com.neusoft.ehr.service.DeptService;
import com.neusoft.ehr.service.StaffService;

public class DepchangeServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//取值
		String empseq = request.getParameter("empseq");//员工编号
		String empname = MyTools.toChinese(request.getParameter("empname"));//员工姓名
		String type = MyTools.toChinese(request.getParameter("type"));//调转类型
		String date = request.getParameter("date");//调转日期
        String reason = MyTools.toChinese(request.getParameter("reason"));//调转原因
		String depchdep = MyTools.toChinese(request.getParameter("depchdep"));//调转后部门
		String ps = MyTools.toChinese(request.getParameter("ps"));//备注
		String mode = MyTools.toChinese(request.getParameter("mode"));
		//调动业务层
		DepchService dcs = new DepchService();
		StaffService ss = new StaffService();
		DeptService ds = new DeptService();
		Staff s = ss.findBySeq(empseq);
		Dept d1 = ds.selebyname(depchdep);
		//取得原部门
		String old_dep=s.getDepSeq();
		Dept d2 = ds.findbyid(old_dep);
		int old_depid = d2.getDep_id();
		String old_name = d2.getDep_name();
		//取得现部门
	    int depch_depid = d1.getDep_id();
	    String depch_name = d1.getDep_name();
		//调转部门
		s.setDepSeq(d1.getDep_seq());
		s.setDepName(d1.getDep_name());
		ss.update(s);
		//创建新的部门调转记录
		Depch dc = new Depch();
		dc.setOld_name(old_name);
		dc.setDepch_name(depch_name);
		dc.setOld_depid(old_depid);
		dc.setDepch_depid(depch_depid);
		dc.setDepch_class(type);
		dc.setDepch_yy(reason);
		dc.setDepch_reviews(ps);
		dc.setDepch_time(date);
		dc.setDepch_mode(mode);
		dc.setEmp_id(s.getEmpId());
		dc.setEmp_name(s.getEmpName());
		dc.setEmp_seq(empseq);
		//System.out.println(empseq);
		dcs.Depch(dc);
		request.getRequestDispatcher("/DepChFindServlet.action?seq=&name=&depname=&postname=").forward(request, response);
	}

}
