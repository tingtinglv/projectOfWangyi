package com.neusoft.ehr.daotest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.neusoft.ehr.comm.Page;
import com.neusoft.ehr.comm.PageUtil;
import com.neusoft.ehr.dao.UserDAO;
import com.neusoft.ehr.entity.User;
import com.neusoft.ehr.factory.UserDAOFactory;



public class UserDAOTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		UserDAO ud = UserDAOFactory.getUserDAOInstance();
		//add ≤‚ ‘
		/*User u = new User();
		u.setUname("zxcc8");
		u.setPwd("123456");
		u.setType("manager");
		u.setQuestion("ƒ„µƒ≥ˆ…˙µÿ");
		u.setAnswer("…¬Œ˜");
		ud.add(u);*/
		
		//findall ≤‚ ‘
		/*
		List<User> userlist = ud.findalluser();
		Iterator<User> it =  userlist.iterator();
		while(it.hasNext())
		{
			User u = new User();
			 u = it.next();
			int uid = u.getUid();
			String uname = u.getUname();
			String pwd = u.getPwd();
			String type = u.getType();
			String question =u.getQuestion();
			String answer = u.getAnswer();
			String state = u.getState();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
			String resultDate=sdf.format(u.getRegistDate());
			String activestate = u.getActiveState();
			System.out.println(uid+" "+uname+" "+pwd+" "+type+" "+question+" "+answer+" "+state+" "+resultDate+" "+activestate);
		}
		*/
		//del≤‚ ‘
		/*boolean result =ud.del(4);
		System.out.println(result);*/
		
		
		//findbylike
		/*List<User> userlist = ud.findbylike("zxcc");
		Iterator<User> it = userlist.iterator();
		while(it.hasNext())
		{
			User u = new User(); 
			u = it.next();
			int uid = u.getUid();
			String uname = u.getUname();
			String pwd = u.getPwd();
			String type = u.getType();
			String question =u.getQuestion();
			String answer = u.getAnswer();
			String state = u.getState();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
			String resultDate=sdf.format(u.getRegistDate());
			String activestate = u.getActiveState();
			System.out.println(uid+" "+uname+" "+pwd+" "+type+" "+question+" "+answer+" "+state+" "+resultDate+" "+activestate);
		}*/
		
		
		//update ≤‚ ‘
		/*User u = new User();
		u.setPwd("z4");
		u.setUname("z4");
		u.setUid(1);
		ud.update(u);*/
		
		//findbyname
		/*User u = ud.findbyuname("z4");
		int uid = u.getUid();
		String uname = u.getUname();
		String pwd = u.getPwd();
		String type = u.getType();
		String question =u.getQuestion();
		String answer = u.getAnswer();
		String state = u.getState();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
		String resultDate=sdf.format(u.getRegistDate());
		String activestate = u.getActiveState();
		System.out.println(uid+" "+uname+" "+pwd+" "+type+" "+question+" "+answer+" "+state+" "+resultDate+" "+activestate);
	*/
		
		//findbyuserid
//		User u = ud.findbyuserid(5);
		/*if(u!=null)
		{
			int uid = u.getUid();
			String uname = u.getUname();
			String pwd = u.getPwd();
			String type = u.getType();
			String question =u.getQuestion();
			String answer = u.getAnswer();
			String state = u.getState();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
			String resultDate=sdf.format(u.getRegistDate());
			String activestate = u.getActiveState();
			System.out.println(uid+" "+uname+" "+pwd+" "+type+" "+question+" "+answer+" "+state+" "+resultDate+" "+activestate);

		}
		else
		{
			System.out.println("≤ª¥Ê‘⁄");
		}*/
		
		//login
		/*User u = new User();
		u.setUname("zxcc1");
		u.setPwd("123456");
		User u1 =ud.login(u);
		if(u1!=null)
		{
			System.out.println(u1.getUid()+" "+u1.getUname()+" "+u1.getState()+" "+u1.getActiveState());
		}
		else
		{
			System.out.println("’À∫≈√‹¬Î¥ÌŒÛ");
		}*/
		
		
		
		
		// ±º‰≤‚ ‘
		/*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
		Date date = new Date();
		String resultDate=sdf.format(date);
		System.out.println(resultDate);
		System.out.println(date.getTime());
		try {
			Date date1 = sdf.parse(resultDate);
			System.out.println(date1.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		/*public List<User> findByCondition(Page page,int startYear,int startMonth,int startDay,int endYear,int endMonth,int endDay,
				String userName,String userActiveState,String timeType)  
		public int findCountByCondition(int startYear,int startMonth,int startDay,int endYear,int endMonth,int endDay,
				String userName,String userActiveState,String timeType) ≤‚ ‘*/
		
		
		/*int startYear, startMonth, startDay, endYear, endMonth, endDay;
		startYear = 2014;
		startMonth = 7;
		startDay = 19;
		endYear = 2014;
		endMonth = 7;
		endDay = 21;
		String userName = "zry";
		String userActiveState="active";
		String timeType="bytime";
		int totalCount= ud.findCountByCondition(startYear, startMonth, startDay, endYear, endMonth, endDay, userName, userActiveState, timeType);
		int currentPage=1;
		Page page = PageUtil.createPage(5, totalCount, currentPage);
		List<User> ulist = ud.findByCondition(page, startYear, startMonth, startDay, endYear, endMonth, endDay, userName, userActiveState, timeType);
		Iterator<User> it = ulist.iterator();
		while(it.hasNext())
		{
			User u = it.next();
			System.out.println(u.getUname()+" "+u.getPwd());
		}
		System.out.println("total:"+totalCount);*/
	}//main.	

}//class.
