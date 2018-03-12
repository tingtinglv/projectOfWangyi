package com.neusoft.ehr.dao;

import java.util.List;

import com.neusoft.ehr.comm.Page;
import com.neusoft.ehr.entity.Post;
import com.neusoft.ehr.entity.Postch;

public interface PostchDAO {
	//添加
	public void add(Postch postch);
	//用分页实现全查
	public List<Postch> findAllPostch(Page page);
	//总记录数
	public int findAllCount();
	//查询
	public List<Postch> find(String seq,String name,String type,Page page,String date1,String date2);
	//查询记录数
	public int count(String seq,String name,String type,String date1,String date2);
}
