package com.neusoft.ehr.factory;

import com.neusoft.ehr.dao.PostchDAO;
import com.neusoft.ehr.daoimpl.PostchDAOImp;

public class PostchDAOFactory {
	public static PostchDAO getPostchDAOInstance(){
		return new PostchDAOImp();
		
	}
}
