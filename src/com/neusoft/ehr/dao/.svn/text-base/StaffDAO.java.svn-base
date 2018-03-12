package com.neusoft.ehr.dao;

import java.util.List;

import com.neusoft.ehr.comm.Page;
import com.neusoft.ehr.entity.Staff;

public interface StaffDAO {
	//接口就是定义对刚才那个User实体的操作标准。
	//分成两部分，1，常规标准，2，业务标准。
		//增加用户。
		public boolean add(Staff s);
		//删除用户。
		public boolean del(int empId);
		//修改用户。
		public boolean update(Staff s);
		//查找某一个员工。
		public Staff findById(int sid);
		//按员工编号查找一个员工
		public Staff findBySeq(String empSeq);
		//全查用户。
		public List<Staff> findAll();
		//分页查询
		public List<Staff> find(Page page,String empSeq,String empName,String depName,String postName);
		//按条件模糊查询。
		public List<Staff> findByLike(String str);
		//按名字查询员工
		public List<Staff> findByName(String str);
		//查询总记录数
		public int findAllCount();
}
