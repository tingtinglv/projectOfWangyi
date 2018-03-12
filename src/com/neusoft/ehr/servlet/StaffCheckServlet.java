package com.neusoft.ehr.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.ehr.entity.Staff;
import com.neusoft.ehr.service.StaffService;

public class StaffCheckServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7881999301554351452L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out=response.getWriter(); 
		String empSeq=request.getParameter("empSeq"); 
		StaffService ss = new StaffService();
		Staff s = ss.findBySeq(empSeq);
		if(s!=null)
		{
				out.print("<response>success</response>");
		}
		else
		{
			out.print("<response>fail</response>"); 
		}
		out.close();
	}
}
