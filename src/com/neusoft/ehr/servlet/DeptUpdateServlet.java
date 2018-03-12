package com.neusoft.ehr.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neusoft.ehr.entity.Dept;
import com.neusoft.ehr.service.DeptService;

public class DeptUpdateServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            doPost(request,response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            String seq = request.getParameter("seq");
            DeptService ds = new DeptService();
            Dept d = new Dept();
            d = ds.findbyid(seq);
            HttpSession session = request.getSession();
            session.setAttribute("dept", d);
            request.getRequestDispatcher("/servlet/department_update.jsp").forward(request, response);
	}

}
