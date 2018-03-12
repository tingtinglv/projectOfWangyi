package com.neusoft.ehr.service;

import java.util.List;

import com.neusoft.ehr.comm.Page;
import com.neusoft.ehr.dao.DepchDAO;
import com.neusoft.ehr.entity.Depch;
import com.neusoft.ehr.factory.DepchDAOFactory;
//import com.neusoft.ehr.factory.DeptDAOFactory;

public class DepchService {
	public void Depch(Depch d){
		DepchDAO dcd = DepchDAOFactory.getDeptDAOInstance() ;
		dcd.Depch(d);
	}
	public List<Depch> sele(String sDate, String eDate,
			String empname,String empSeq, String type,Page page) {
		DepchDAO dcd = DepchDAOFactory.getDeptDAOInstance() ;
		List list = dcd.sele(sDate,eDate,empname,empSeq,type,page);
		return list;
	}
	public int selecount(String sDate, String eDate,String empname,String empSeq, String type){
		DepchDAO dcd = DepchDAOFactory.getDeptDAOInstance() ;
		int count = dcd.selecount(sDate, eDate, empname, empSeq, type);
		return count;
	}
	
}

