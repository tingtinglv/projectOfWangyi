package com.neusoft.ehr.dao;

import java.util.List;

import com.neusoft.ehr.comm.Page;
import com.neusoft.ehr.entity.User;



public interface UserDAO {

	public boolean add(User u);
	public boolean del(int uid);
	public boolean update(User u);
	public User findbyuserid(int uid);
	public List<User> findalluser();
	public List<User> findalluser(Page page);
	public List<User> findbylike(String str);
	public User findbyuname(String str);
	public User login(User u);
	public boolean updateState(User u);
	public boolean updateActiveState(String activeState,int uid);
	public int findlAllCount();
	public List<User> findByCondition(Page page,int startYear,int startMonth,int startDay,int endYear,int endMonth,int endDay,
			String userName,String userActiveState,String timeType);
	public int findCountByCondition(int startYear,int startMonth,int startDay,int endYear,int endMonth,int endDay,
			String userName,String userActiveState,String timeType);
}
