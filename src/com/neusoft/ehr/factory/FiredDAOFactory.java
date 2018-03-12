package com.neusoft.ehr.factory;

import com.neusoft.ehr.dao.FiredDAO;
import com.neusoft.ehr.daoimpl.FiredDAOImpl;

public class FiredDAOFactory {
	public static FiredDAO getFiredDAOInstance(){
		return new FiredDAOImpl();
	}
}
