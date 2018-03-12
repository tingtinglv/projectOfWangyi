package com.neusoft.ehr.factory;
import com.neusoft.ehr.dao.PostDAO;
import com.neusoft.ehr.daoimpl.PostDAOImp;


public class PostDAOFactory {
	public static PostDAO getPostDAOInstance(){
		return new PostDAOImp();
		
	}
}
