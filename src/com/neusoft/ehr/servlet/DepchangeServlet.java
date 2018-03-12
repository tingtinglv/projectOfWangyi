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
		//ȡֵ
		String empseq = request.getParameter("empseq");//Ա�����
		String empname = MyTools.toChinese(request.getParameter("empname"));//Ա������
		String type = MyTools.toChinese(request.getParameter("type"));//��ת����
		String date = request.getParameter("date");//��ת����
        String reason = MyTools.toChinese(request.getParameter("reason"));//��תԭ��
		String depchdep = MyTools.toChinese(request.getParameter("depchdep"));//��ת����
		String ps = MyTools.toChinese(request.getParameter("ps"));//��ע
		String mode = MyTools.toChinese(request.getParameter("mode"));
		//����ҵ���
		DepchService dcs = new DepchService();
		StaffService ss = new StaffService();
		DeptService ds = new DeptService();
		Staff s = ss.findBySeq(empseq);
		Dept d1 = ds.selebyname(depchdep);
		//ȡ��ԭ����
		String old_dep=s.getDepSeq();
		Dept d2 = ds.findbyid(old_dep);
		int old_depid = d2.getDep_id();
		String old_name = d2.getDep_name();
		//ȡ���ֲ���
	    int depch_depid = d1.getDep_id();
	    String depch_name = d1.getDep_name();
		//��ת����
		s.setDepSeq(d1.getDep_seq());
		s.setDepName(d1.getDep_name());
		ss.update(s);
		//�����µĲ��ŵ�ת��¼
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
