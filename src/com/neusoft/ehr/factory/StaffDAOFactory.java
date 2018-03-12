package com.neusoft.ehr.factory;

import com.neusoft.ehr.dao.StaffDAO;
import com.neusoft.ehr.daoimpl.StaffDAOImpl;

public class StaffDAOFactory {
	public static StaffDAO getStaffDAOInstance(){
		return new StaffDAOImpl();
	}
}
