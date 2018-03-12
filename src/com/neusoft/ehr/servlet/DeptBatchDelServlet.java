package com.neusoft.ehr.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.ehr.entity.Dept;
import com.neusoft.ehr.service.DeptService;

public class DeptBatchDelServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            String[] cbx=request.getParameterValues("cbx");
		    //调用业务层方法
            DeptService ds = new DeptService();
            Dept d = new Dept();
            for(int i=0;i<cbx.length;i++){
            	d.setDep_seq(cbx[i]);
            	ds.dele(d);
            }
            request.getRequestDispatcher("/DeptSeleServlet.action?seq=&name=&type=").forward(request, response);
	}

}
