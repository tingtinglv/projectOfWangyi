package com.neusoft.ehr.dao;

import java.sql.Date;
import java.util.List;

import com.neusoft.ehr.comm.Page;
import com.neusoft.ehr.entity.Fired;
import com.neusoft.ehr.entity.Probation;

public interface FiredDAO {
	public boolean add(Fired f);
	public boolean del(int empId);
	public boolean update(Fired f);
	public Fired findById(int empId);
	public List<Fired> findByDate(Date start,Date end);
	public List<Fired> findByType(String str);
	public int findAllCount();
	public List<Fired> find(Page page,String empSeq,String empName,String depName,String postName,String startDate,String endDate,String firedType);
}
