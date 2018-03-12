package com.neusoft.ehr.factory;

import com.neusoft.ehr.dao.UserDAO;
import com.neusoft.ehr.daoimpl.UserDAOImpl;




public class UserDAOFactory {

	private UserDAOFactory(){}
	private static UserDAO ud = new UserDAOImpl();
	public static UserDAO getUserDAOInstance()
	{
		return ud;//使用单态设计
	}
	
}
