package com.neusoft.ehr.service;

import java.util.ArrayList;
import java.util.List;

import com.neusoft.ehr.comm.Page;
import com.neusoft.ehr.dao.FiredDAO;
import com.neusoft.ehr.dao.ProbationDAO;
import com.neusoft.ehr.entity.Fired;
import com.neusoft.ehr.factory.FiredDAOFactory;
import com.neusoft.ehr.factory.ProbationDAOFactory;

public class FiredService {
	//增加
	public boolean add(Fired f){
		FiredDAO fd = FiredDAOFactory.getFiredDAOInstance();
		boolean judge = fd.add(f);
		return judge;
	}
	//查询总记录条数
	public int findAllCount(){
		FiredDAO fd = FiredDAOFactory.getFiredDAOInstance();
		int count = fd.findAllCount();
		return count;
	}
	
	/*
	 * 可按照 员工编号、员工姓名、部门名称、岗位名称分页查询，若后四个参数都为null或“”则为分页全查
	 */
	public List<Fired> find(Page page,String empSeq,String empName,String depName,String postName,String startDate,String endDate,String firedType){
		List<Fired> fList = new ArrayList<Fired>();
		FiredDAO fd = FiredDAOFactory.getFiredDAOInstance();
		fList = fd.find(page, empSeq, empName, depName, postName, startDate, endDate,firedType);
		return fList;
	}
}
