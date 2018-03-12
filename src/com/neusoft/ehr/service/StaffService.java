package com.neusoft.ehr.service;

import java.util.ArrayList;
import java.util.List;

import com.neusoft.ehr.comm.Page;
import com.neusoft.ehr.dao.StaffDAO;
import com.neusoft.ehr.entity.Staff;
import com.neusoft.ehr.factory.StaffDAOFactory;

public class StaffService {
	//增加
	public boolean add(Staff s){
		StaffDAO sd= StaffDAOFactory.getStaffDAOInstance();
		boolean judge = sd.add(s);
		return judge;
	}
	//修改
	public boolean update(Staff s){
		StaffDAO sd = StaffDAOFactory.getStaffDAOInstance();
		boolean judge = sd.update(s);
		return judge;
	}
	//按员工id查询
	public Staff findById(int sId){
		Staff s = new Staff();
		StaffDAO sd = StaffDAOFactory.getStaffDAOInstance();
		s = sd.findById(sId);
		return s;
	}
	//按员工编号查找
	public Staff findBySeq(String empSeq){
		Staff s = new Staff();
		StaffDAO sd = StaffDAOFactory.getStaffDAOInstance();
		s = sd.findBySeq(empSeq);
		return s;
	}
	//查寻所有员工
	public List<Staff> findAll(){
		List<Staff> staffList = new ArrayList<Staff>();
		StaffDAO sd = StaffDAOFactory.getStaffDAOInstance();
		staffList = sd.findAll();
		return staffList;
	}
	//查询总记录条数
	public int findAllCount(){
		StaffDAO sd = StaffDAOFactory.getStaffDAOInstance();
		int count = sd.findAllCount();
		return count;
	}
	/*
	 * 可按照 员工编号、员工姓名、部门名称、岗位名称分页查询，若后四个参数都为null或“”则为分页全查
	 */
	public List<Staff> find(Page page,String empSeq,String empName,String depName,String postName){
		List<Staff> staffList = new ArrayList<Staff>();
		StaffDAO sd = StaffDAOFactory.getStaffDAOInstance();
		staffList = sd.find(page,empSeq,empName,depName,postName);
		return staffList;
	}
}
