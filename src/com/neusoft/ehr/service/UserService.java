package com.neusoft.ehr.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.neusoft.ehr.comm.Page;
import com.neusoft.ehr.dao.UserDAO;
import com.neusoft.ehr.entity.User;
import com.neusoft.ehr.factory.UserDAOFactory;




public class UserService {
	// 添加 修改 查询 删除 注册 登录
	public boolean add(User u){
		UserDAO ud = UserDAOFactory.getUserDAOInstance();
		boolean judge = ud.add(u);
		return judge;
	}
	public boolean update(User u){
		UserDAO ud = UserDAOFactory.getUserDAOInstance();
		boolean judge = ud.update(u);
		return judge;
	}
	public User findbyuserid(int uid){
		User u = new User();
		UserDAO ud = UserDAOFactory.getUserDAOInstance();
		u = ud.findbyuserid(uid);
		return u; 
	}
	public User findbyuname(String str)
	{
		
		UserDAO ud=UserDAOFactory.getUserDAOInstance();
		User u=ud.findbyuname(str);
		return u;
	}
	public List<User> findalluser(){
		List<User> userlist = new ArrayList<User>();
		UserDAO ud = UserDAOFactory.getUserDAOInstance();
		userlist = ud.findalluser();
		return userlist;
	}
	public List<User> findbylike(String str){
		List<User> userlist = new ArrayList<User>();
		UserDAO ud = UserDAOFactory.getUserDAOInstance();
		userlist = ud.findbylike(str);
		return userlist;
	}
	public boolean del(int uid)
	{
		UserDAO ud = UserDAOFactory.getUserDAOInstance();
		boolean judge = ud.del(uid);
		return judge;
	}
	public boolean delbatch(List<User> userlist)
	{
		UserDAO ud = UserDAOFactory.getUserDAOInstance();
		Iterator<User> it = userlist.iterator();
		boolean judge = true;
		while(it.hasNext())
		{
			User u = it.next();
			boolean judge1 = ud.del(u.getUid());
			if(judge1==false)
				judge = false;
		}
		return judge;
	}
	//用户注册业务
	public boolean register(User u){
		UserDAO ud=UserDAOFactory.getUserDAOInstance();
		User u1=ud.findbyuname(u.getUname());
		if(u1!=null){
			return false;
		}else{
			return ud.add(u);
		}
	}//method.
	public User  login(User u)//login 的四个状态 mistake账号密码错误 unactive未激活 haslogin已登录success成功 
	{
		
		UserDAO ud = UserDAOFactory.getUserDAOInstance();
		User u1  = ud.login(u);
		return u1;
	}
	public boolean updateState(User u)
	{
		UserDAO ud = UserDAOFactory.getUserDAOInstance();
		boolean result =ud.updateState(u);
		return result;
	}
	public boolean changeActiveState(int uid)
	{
		UserDAO ud =UserDAOFactory.getUserDAOInstance();
		User u = ud.findbyuserid(uid);
		boolean result=false;
		/*System.out.println("service:uid = "+uid+" "+u.getActiveState());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
		String resultDate=sdf.format(u.getRegistDate());
		System.out.println(resultDate);*/
		//if(u!=null)
		//{
			if(u.getActiveState().equals("unactive"))
			{
				result=ud.updateActiveState("active", uid);
				System.out.println("授权");
			}
			else //if(u.getActiveState().equals("active"))
			{
				 result=ud.updateActiveState("unactive", uid);
				 System.out.println("取消授权");
			}
		//}
		return result;
	}
	public List<User> findalluser(Page page)
	{
		List<User> userlist = new ArrayList<User>();
		UserDAO ud = UserDAOFactory.getUserDAOInstance();
		userlist = ud.findalluser(page);
		return userlist;
	}
	public int findlAllCount()
	{
		UserDAO ud = UserDAOFactory.getUserDAOInstance();
		return ud.findlAllCount();
	}
	public List<User> findByCondition(Page page,int startYear,int startMonth,int startDay,int endYear,int endMonth,int endDay,
			String userName,String userActiveState,String timeType)
			{
		UserDAO ud = UserDAOFactory.getUserDAOInstance();
		List<User> userlist =ud.findByCondition(page, startYear, startMonth, startDay, endYear, endMonth, endDay, userName, userActiveState, timeType);
		//System.out.println(userlist.size());
		return userlist;
			}
	public int findCountByCondition(int startYear,int startMonth,int startDay,int endYear,int endMonth,int endDay,
			String userName,String userActiveState,String timeType)
	{
		UserDAO ud = UserDAOFactory.getUserDAOInstance();
		int count = ud.findCountByCondition(startYear, startMonth, startDay, endYear, endMonth, endDay, userName, userActiveState, timeType);
		//System.out.println(count);
		return count;
	}
	
}
