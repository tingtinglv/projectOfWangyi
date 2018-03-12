package com.neusoft.ehr.service;

import java.util.ArrayList;
import java.util.List;

import com.neusoft.ehr.comm.Page;
import com.neusoft.ehr.dao.ProbationDAO;
import com.neusoft.ehr.entity.Probation;
import com.neusoft.ehr.factory.ProbationDAOFactory;

public class ProbationService {
	//增加
	public boolean add(Probation p){
		ProbationDAO pd = ProbationDAOFactory.getProbationDAOInstance();
		boolean judge = pd.add(p);
		return judge;
	}
	//修改
	public boolean update(Probation p){
		ProbationDAO pd = ProbationDAOFactory.getProbationDAOInstance();
		boolean judge = pd.update(p);
		return judge;
	}
	//按试用期员工编号查找
	public Probation findBySeq(String empSeq){
		Probation p = new Probation();
		ProbationDAO pd = ProbationDAOFactory.getProbationDAOInstance();
		p = pd.findBySeq(empSeq);
		return p;
	}
	//查寻所有试用期员工
	public List<Probation> findAll(){
		List<Probation> pbList = new ArrayList<Probation>();
		ProbationDAO pd = ProbationDAOFactory.getProbationDAOInstance();
		pbList = pd.findAll();
		return pbList;
	}
	//查询总记录条数
	public int findAllCount(){
		ProbationDAO pd = ProbationDAOFactory.getProbationDAOInstance();
		int count = pd.findAllCount();
		return count;
	}
	/*
	 * 可按照 员工编号、员工姓名、部门名称、岗位名称分页查询，若后四个参数都为null或“”则为分页全查
	 */
	public List<Probation> find(Page page,String empSeq,String empName,String depName,String postName,String startDate,String endDate,String flag,String result){
		List<Probation> pbList = new ArrayList<Probation>();
		ProbationDAO pd = ProbationDAOFactory.getProbationDAOInstance();
		pbList = pd.find(page,empSeq,empName,depName,postName,startDate,endDate,flag,result);
		return pbList;
	}
}
