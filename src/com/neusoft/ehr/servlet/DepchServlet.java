package com.neusoft.ehr.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neusoft.ehr.entity.Dept;
import com.neusoft.ehr.entity.Staff;
import com.neusoft.ehr.service.DeptService;
import com.neusoft.ehr.service.StaffService;

public class DepchServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String seq = request.getParameter("seq");
        StaffService ss = new StaffService();
        Staff s = new Staff();
        s = ss.findBySeq(seq);
        //System.out.println(s.getEmpName());
        HttpSession session = request.getSession();
        session.setAttribute("staff", s);
        request.getRequestDispatcher("/servlet/department_changing.jsp").forward(request, response);
	}

}
