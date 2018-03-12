package com.neusoft.ehr.dao;

import java.util.List;

import com.neusoft.ehr.comm.Page;
import com.neusoft.ehr.entity.Depch;

public interface DepchDAO {
    //部门调转
	public void Depch(Depch d);
	
	//查询数目
	public int selecount(String sDate, String eDate,String empname,String empSeq, String type);
	
	//已调转部门的人员查询
	public List<Depch> sele(String s_date,String e_date,String emp_seq,String emp_name,String type,Page page);
}
