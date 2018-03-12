package com.neusoft.ehr.service;

import java.util.List;

import com.neusoft.ehr.comm.Page;
import com.neusoft.ehr.dao.PostchDAO;
import com.neusoft.ehr.entity.Postch;
import com.neusoft.ehr.factory.PostDAOFactory;
import com.neusoft.ehr.factory.PostchDAOFactory;

public class PostchService {
	public void add(Postch postch){
		PostchDAO pd = PostchDAOFactory.getPostchDAOInstance();
		pd.add(postch);
	}
	public List<Postch> findAllPostch(Page page){
		PostchDAO pd = PostchDAOFactory.getPostchDAOInstance();
		List<Postch> list = pd.findAllPostch(page);
		return list;
	}
	public int findAllCount(){
		PostchDAO pd = PostchDAOFactory.getPostchDAOInstance();
		int count = pd.findAllCount();
		return count;
	}
	public int count(String seq, String name, String type,String date1,String date2){
		PostchDAO pd = PostchDAOFactory.getPostchDAOInstance();
		int count = pd.count(seq, name, type,date1,date2);
		return count;
	}
	public List<Postch> find(String seq, String name, String type, Page page,String date1,String date2){
		PostchDAO pd = PostchDAOFactory.getPostchDAOInstance();
		List<Postch> list = pd.find(seq, name, type, page,date1,date2);
		return list;
	}
}
