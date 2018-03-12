package com.neusoft.ehr.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.neusoft.ehr.comm.Page;
import com.neusoft.ehr.dao.DeptDAO;
import com.neusoft.ehr.entity.Dept;
import com.neusoft.ehr.factory.DeptDAOFactory;

public class DeptService {
	
	
	//新增部门
	public void add(Dept d){
		DeptDAO dd = DeptDAOFactory.getDeptDAOInstance();
		dd.add(d);
	}
	
	//修改部门
	public void update(Dept d){
		DeptDAO dd = DeptDAOFactory.getDeptDAOInstance();
		dd.update(d);
	}
	
	//删除
	public void dele(Dept d){
		DeptDAO dd = DeptDAOFactory.getDeptDAOInstance();
		dd.dele(d);
	}
	
	//批量删除
	public void batchdel(List<Dept> list){
		DeptDAO dd = DeptDAOFactory.getDeptDAOInstance();
		Dept d = new Dept();
		Iterator it = list.iterator();
		while(it.hasNext()){
			String ino=(String) it.next();
			d.setDep_seq(ino);
			dd.dele(d);
		}
	}
	
	//全查
	public List<Dept> findall(Page page){
		DeptDAO dd = DeptDAOFactory.getDeptDAOInstance();
		List<Dept> l = new ArrayList<Dept>();
		l = dd.findall(page);
		return l;
	}
	//全查count
	public int findallcount(){
		DeptDAO dd = DeptDAOFactory.getDeptDAOInstance();
		int i = dd.findallcount();
		return i;
	}
	
	//通过编号查找部门
	public Dept findbyid(String seq){
		DeptDAO dd = DeptDAOFactory.getDeptDAOInstance();
		Dept d = new Dept();
		d = dd.findbyid(seq);
		return d;
	}
	
	//分页实现通过类型查找部门
	public List<Dept> findbytype(String type,Page page){
		DeptDAO dd = DeptDAOFactory.getDeptDAOInstance();
		List<Dept> l = new ArrayList<Dept>();
		l = dd.findbytype(type, page);
		return l;
	}
	//查询类型查找部门数
	public int findbytypecount(String type){
		DeptDAO dd = DeptDAOFactory.getDeptDAOInstance();
		int i = dd.findbytypecount(type);
		return i;
	}
	
	//分页实现模糊查询
	public List<Dept> findbylike(String str,Page page){
		DeptDAO dd = DeptDAOFactory.getDeptDAOInstance();
		List<Dept> l = new ArrayList<Dept>();
		l = dd.findbylike(str, page);
		return l;
	}
	//模糊查询部门数
    public int findbylikecount(String str){
    	DeptDAO dd = DeptDAOFactory.getDeptDAOInstance();
		int i = dd.findbylikecount(str);
		return i;
    }
	
    //真正的查询部门。。。
    public List<Dept> select(String seq, String name, String type, Page page){
    	DeptDAO dd = DeptDAOFactory.getDeptDAOInstance();
		List<Dept> l = new ArrayList<Dept>();
		l = dd.select(seq, name, type, page);
		return l;
    }
    //真正的查询个数。。。
    public int selectcount(String seq, String name, String type){
    	DeptDAO dd = DeptDAOFactory.getDeptDAOInstance();
		int i = dd.selectcount(seq, name, type);
		return i;
    }
    //胡大哥专用
    public List<Dept> findall(){
		DeptDAO dd = DeptDAOFactory.getDeptDAOInstance();
		List<Dept> l = new ArrayList<Dept>();
		l = dd.findall();
		return l;
	} 
    //部门调动使用
    public Dept selebyname(String name){
    	DeptDAO dd = DeptDAOFactory.getDeptDAOInstance();
		Dept d = new Dept();
		d = dd.selebyname(name);
		return d;
    }
}




























