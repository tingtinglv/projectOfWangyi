package com.neusoft.ehr.servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.ehr.comm.MyTools;
import com.neusoft.ehr.comm.Page;
import com.neusoft.ehr.comm.PageUtil;
import com.neusoft.ehr.entity.Fired;
import com.neusoft.ehr.entity.Staff;
import com.neusoft.ehr.service.FiredService;
import com.neusoft.ehr.service.StaffService;

public class StaffFireingServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7672033221726233655L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int curPage = 0;
        String currentPagestr = request.getParameter("curPage");
        if(currentPagestr == null || "".equals(currentPagestr)){
        	curPage = 1;
        }else{
        	curPage=Integer.parseInt(currentPagestr);
        }
        
        StaffService ss = new StaffService();
        Page page = PageUtil.createPage(10, ss.findAllCount(), curPage);//���÷�ҳ
        String empSeq = request.getParameter("empSeq");
        String modalEmpSeq = request.getParameter("modalEmpSeq");
        Date firedDate = Date.valueOf(request.getParameter("firedDate"));
        String empName =MyTools.toChinese(request.getParameter("empName"));
        String depName = MyTools.toChinese(request.getParameter("depName"));
        String postName = MyTools.toChinese(request.getParameter("postName"));
        String firedTraced =  MyTools.toChinese(request.getParameter("firedTraced"));
        String firedType=  MyTools.toChinese(request.getParameter("firedType"));
        String firedMemo=  MyTools.toChinese(request.getParameter("firedMemo"));
        String humanResource=  MyTools.toChinese(request.getParameter("humanResource"));
        String type = "��ְ";
        Staff s = ss.findBySeq(modalEmpSeq);
        s.setType(type);
        boolean judge = ss.update(s);
        FiredService fs =new FiredService();
        Fired f = new Fired();
        f.setEmpId(s.getEmpId());
        f.setFiredDate(firedDate);
        f.setFiredTraced(firedTraced);
        f.setFiredType(firedType);
        f.setFiredMemo(firedMemo);
        f.setHumanResource(humanResource);
        judge = fs.add(f);
        List<Staff> staffList = ss.find(page,empSeq,empName,depName,postName);//��ҳ��ѯ
        request.setAttribute("staffList", staffList);
        request.setAttribute("page", page);
        request.setAttribute("curPage", curPage);
        request.setAttribute("empSeq", empSeq);
        request.setAttribute("empName", empName);
        request.setAttribute("depName", depName);
        request.setAttribute("postName", postName);
        request.setAttribute("judge", judge);
        request.getRequestDispatcher("/servlet/staff_fire.jsp").forward(request, response);
	}

}
