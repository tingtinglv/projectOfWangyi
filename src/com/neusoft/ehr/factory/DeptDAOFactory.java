package com.neusoft.ehr.factory;

import com.neusoft.ehr.dao.DeptDAO;
import com.neusoft.ehr.daoimpl.DeptDAOImpl;

public class DeptDAOFactory {
    public static DeptDAO getDeptDAOInstance(){
    	return new DeptDAOImpl();
    }
}
