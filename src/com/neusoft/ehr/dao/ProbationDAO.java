package com.neusoft.ehr.dao;

import java.sql.Date;
import java.util.List;

import com.neusoft.ehr.comm.Page;
import com.neusoft.ehr.entity.Probation;

public interface ProbationDAO {
	public boolean add(Probation p);
	public boolean del(int empId);
	public boolean update(Probation p);
	public Probation findBySeq(String empSeq);
	public List<Probation> findByResult(String result);
	public List<Probation> findAll();
	public List<Probation> findByDate(Date startDate,Date endDate);
	public int findAllCount();
	public List<Probation> find(Page page,String empSeq,String empName,String depName,String postName,String startDate,String endDate,String falg,String result);
}
