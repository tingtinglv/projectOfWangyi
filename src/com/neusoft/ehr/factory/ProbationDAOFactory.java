package com.neusoft.ehr.factory;

import com.neusoft.ehr.dao.ProbationDAO;
import com.neusoft.ehr.daoimpl.ProbationDAOImpl;

public class ProbationDAOFactory {
	public static ProbationDAO getProbationDAOInstance(){
		return new ProbationDAOImpl();
	}
}
