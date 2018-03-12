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
import com.neusoft.ehr.entity.Probation;
import com.neusoft.ehr.entity.Staff;
import com.neusoft.ehr.service.FiredService;
import com.neusoft.ehr.service.ProbationService;
import com.neusoft.ehr.service.StaffService;

public class StaffReviewServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3749838225184861857L;

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
        ProbationService ps = new ProbationService();
        Page page = PageUtil.createPage(10, ps.findAllCount(), curPage);//设置分页
        String empSeq = request.getParameter("empSeq");
        String modalEmpSeq = request.getParameter("modalEmpSeq");
        String delayDate = MyTools.toChinese(request.getParameter("delayDate"));
        String reviews = MyTools.toChinese(request.getParameter("reviews"));
        String remark = MyTools.toChinese(request.getParameter("remark"));
        String empName =MyTools.toChinese(request.getParameter("empName"));
        String depName = MyTools.toChinese(request.getParameter("depName"));
        String postName = MyTools.toChinese(request.getParameter("postName"));
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        String dateFlag = request.getParameter("dateFlag");
        String result = MyTools.toChinese(request.getParameter("result"));
        Probation pb= ps.findBySeq(modalEmpSeq);
        if(!delayDate.equals("")&&delayDate!=null&&result.equals("延期"))
        	pb.setEndDate(Date.valueOf(delayDate));
        if(!delayDate.equals("")&&delayDate!=null&&result.equals("转正"))
        	pb.setCheckTime(Date.valueOf(delayDate));
        pb.setRemark(remark);
        pb.setResult(result);
        pb.setReviews(reviews);
        pb.setResult(result);
        if(result.equals("转正")){
        	StaffService ss = new StaffService();
            Staff s = ss.findBySeq(modalEmpSeq);
            s.setType(result);
            ss.update(s);
        }
        boolean judge = ps.update(pb);
        List<Probation> pbList = ps.find(page, empSeq, empName, depName, postName, startDate, endDate, dateFlag,result);
        request.setAttribute("pbList", pbList);
        request.setAttribute("page", page);
        request.setAttribute("curPage", curPage);
        request.setAttribute("empSeq", empSeq);
        request.setAttribute("empName", empName);
        request.setAttribute("depName", depName);
        request.setAttribute("postName", postName);
        request.setAttribute("startDate", startDate);
        request.setAttribute("endDate", endDate);
        request.setAttribute("dateFlag", dateFlag);
        request.setAttribute("result",result);
        request.getRequestDispatcher("/servlet/staff_probation.jsp").forward(request, response);
	}
}
