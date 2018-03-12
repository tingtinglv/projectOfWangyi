package com.neusoft.ehr.dao;

import com.neusoft.ehr.comm.Page;
import com.neusoft.ehr.entity.Dept;
import java.util.List;

public interface DeptDAO {
    //增加部门
	public void add(Dept d);
	//删除部门
	public void dele(Dept d);
	//修改部门
	public void update(Dept d);
	
	//查找所有部门
	public List<Dept> findall();
	//用分页实现全查
    public List<Dept> findall(Page page);
    //查询总数
    public int findallcount();
    
	//通过编号查找部门
	public Dept findbyid(String seq);
	
	//通过名称查找部门
	public List<Dept> findbyname(String name);
	
	//通过类型查找部门
	public List<Dept> findbytype(String type);
	//分页实现通过类型查找部门
	public List<Dept> findbytype(String type,Page page);
	//查询类型查找部门数
	public int findbytypecount(String type);
	
	//模糊查询
	public List<Dept> findbylike(String str);
	//分页实现模糊查询
	public List<Dept> findbylike(String str,Page page);
	//模糊查询部门数
    public int findbylikecount(String str);
    
    //真正的查询。。。
    public List<Dept> select(String seq,String name,String type,Page page);
    //真正的个数
    public int selectcount(String seq,String name,String type);
    
    public Dept selebyname(String name);
}
