package com.neusoft.ehr.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.neusoft.ehr.comm.DBUtilTest;
import com.neusoft.ehr.comm.DBUtils;
import com.neusoft.ehr.comm.Page;
import com.neusoft.ehr.dao.UserDAO;
import com.neusoft.ehr.entity.User;



public class UserDAOImpl implements UserDAO {
	//connection 两种， 挂载在服务器的连接池 和直接连接的jdbc
	private Connection conn = DBUtils.getConn();
	//private Connection conn =  DBUtilTest.getConn();
	private PreparedStatement pstmt;
	private ResultSet rs; 
	
	
	public boolean add(User u) {
		String sql = "insert into user(uname,pwd,type,question,answer,registDate,activestate,email) values(?,?,?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, u.getUname());
			pstmt.setString(2, u.getPwd());
			pstmt.setString(3, u.getType());
			pstmt.setString(4, u.getQuestion());
			pstmt.setString(5, u.getAnswer());
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String resultDate=sdf.format(date.getTime());
			pstmt.setString(6,resultDate);
			pstmt.setString(7,u.getActiveState());
			pstmt.setString(8, u.getEmail());
			int judgenum =  pstmt.executeUpdate();
			//System.out.println(judgenum);
			if(judgenum!=0)
				return true;
			return false;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean del(int uid) {
		String sql = "delete from user where uid = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, uid);
			int judgenum = pstmt.executeUpdate();
			if(judgenum!=0)
				return true;
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	
	}
	
	
	
	public User findbyuname(String str)
	{
		String sql = "select * from user where uname = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,str);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				int uid = rs.getInt("uid");
				String uname = rs.getString("uname");
				String pwd = rs.getString("pwd");
				String type = rs.getString("type");
				String question =rs.getString("question");
				String answer = rs.getString("answer");
				String state = rs.getString("state");
				Date date = rs.getDate("registDate");
				String activestate = rs.getString("activestate");
				String email = rs.getString("email");
				User u = new User();
				
				u.setUid(uid);
				u.setUname(uname);
				u.setPwd(pwd);
				u.setType(type);
				u.setQuestion(question);
				u.setAnswer(answer);
				u.setState(state);
				u.setRegistDate(date);
				u.setActiveState(activestate);
				u.setEmail(email);
				return u;
			}
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public List<User> findalluser(Page page)
	{
		String sql = "select * from user where type='manager' limit ?,?";
		List<User> userlist = new ArrayList<User>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, page.getBeginIndex());
			pstmt.setInt(2, page.getEveryPage());
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				try {
					int uid = rs.getInt("uid");
					String uname = rs.getString("uname");
					String pwd = rs.getString("pwd");
					String type = rs.getString("type");
					String question =rs.getString("question");
					String answer = rs.getString("answer");
					String state = rs.getString("state");
					String resultDate = rs.getString("registDate");
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
					Date date = sdf.parse(resultDate);
					String activestate = rs.getString("activestate");
					String email = rs.getString("email");
					User u = new User();
					u.setUid(uid);
					u.setUname(uname);
					u.setPwd(pwd);
					u.setType(type);
					u.setQuestion(question);
					u.setAnswer(answer);
					u.setState(state);
					u.setRegistDate(date);
					u.setActiveState(activestate);
					u.setEmail(email);
					userlist.add(u);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
			return userlist;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public List<User> findByCondition(Page page,int startYear,int startMonth,int startDay,int endYear,int endMonth,int endDay,
			String userName,String userActiveState,String timeType)
	{
		String sql = "select * from user where ";
				 //where type='manager' limit ?,?";
		String conditions[] = new String[5];//用于存放所有的条件
		String condition="";//用于存放合成的总条件
		int i=0;
		if(!"".equals(timeType))
		{
			if(startYear!=0 && startMonth!=0 && startDay!=0)
			{
				conditions[i]=" registDate>='"+startYear+"-"+startMonth+"-"+startDay+" 00:00:00'";
				i++;
			}
			if(endYear!=0 && endMonth!=0 && endDay!=0)
			{
				conditions[i]=" registDate<='"+endYear+"-"+endMonth+"-"+endDay+" 23:59:59'";
				i++;
			}
		}
		if(!"".equals(userName))
		{
			conditions[i]=" uname='"+userName+"'";
			i++;
		}
		if(!"".equals(userActiveState))
		{
			conditions[i]=" activestate='"+userActiveState+"'";
			i++;
		}
		//条件中加入type='manager',排除管理员
		conditions[i]=" type='manager'";
		i++;
		for(int j=0;j<i;j++)
		{
			if(j==0)
			{
				condition+=conditions[j];
			}
			else
			{
				condition+=" and "+conditions[j];
			}
		}
		
		
		List<User> userlist = new ArrayList<User>();
		try {
			sql+=condition;
			sql+=" limit ?,? ";
			//System.out.println(sql);
			pstmt = conn.prepareStatement(sql);
			//pstmt.setString(1,condition);
			pstmt.setInt(1, page.getBeginIndex());
			pstmt.setInt(2, page.getEveryPage());
			//System.out.println(page.getBeginIndex()+" "+page.getEveryPage());
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				try {
					int uid = rs.getInt("uid");
					String uname = rs.getString("uname");
					String pwd = rs.getString("pwd");
					String type = rs.getString("type");
					String question =rs.getString("question");
					String answer = rs.getString("answer");
					String state = rs.getString("state");
					String resultDate = rs.getString("registDate");
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
					Date date = sdf.parse(resultDate);
					String activestate = rs.getString("activestate");
					String email = rs.getString("email");
					User u = new User();
					u.setUid(uid);
					u.setUname(uname);
					u.setPwd(pwd);
					u.setType(type);
					u.setQuestion(question);
					u.setAnswer(answer);
					u.setState(state);
					u.setRegistDate(date);
					u.setActiveState(activestate);
					u.setEmail(email);
					userlist.add(u);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
			//System.out.println("daoimp:"+userlist.size());
			return userlist;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public int findCountByCondition(int startYear,int startMonth,int startDay,int endYear,int endMonth,int endDay,
			String userName,String userActiveState,String timeType)
	{
		String sql = "select count(*) from user where "; //where type='manager' limit ?,?";
		String conditions[] = new String[5];//用于存放所有的条件
		String condition="";//用于存放合成的总条件
		int i=0;
		if(!"".equals(timeType))
		{
			if(startYear!=0 && startMonth!=0 && startDay!=0)
			{
				conditions[i]=" registDate>='"+startYear+"-"+startMonth+"-"+startDay+" 00:00:00'";
				i++;
			}
			if(endYear!=0 && endMonth!=0 && endDay!=0)
			{
				conditions[i]=" registDate<='"+endYear+"-"+endMonth+"-"+endDay+" 23:59:59'";
				i++;
			}
		}
		if(!"".equals(userName))
		{
			conditions[i]=" uname='"+userName+"'";
			i++;
		}
		if(!"".equals(userActiveState))
		{
			conditions[i]=" activestate='"+userActiveState+"'";
			i++;
		}
		conditions[i]=" type='manager'";
		i++;
		for(int j=0;j<i;j++)
		{
			//System.out.println(j+conditions[j]);
			if(j==0)
			{
				condition+=conditions[j];
			}
			else
			{
				condition+=" and "+conditions[j];
			}
		}
		
		int count=0;
	
			try {
				sql+=condition;
				//System.out.println(sql);
				pstmt = conn.prepareStatement(sql);
				//pstmt.setString(1,condition);
				rs = pstmt.executeQuery();
				if(rs.next()){
					count=rs.getInt(1);
				}
				return count;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return count;
			}
			
			
			
			
		
	}
	

	public List<User> findalluser() {
		String sql = "select * from user where type='manager' ";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<User> userlist = new ArrayList<User>();
			while(rs.next())
			{
				try {
					int uid = rs.getInt("uid");
					String uname = rs.getString("uname");
					String pwd = rs.getString("pwd");
					String type = rs.getString("type");
					String question =rs.getString("question");
					String answer = rs.getString("answer");
					String state = rs.getString("state");
					String resultDate = rs.getString("registDate");
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
					Date date = sdf.parse(resultDate);
					String activestate = rs.getString("activestate");
					String email = rs.getString("email");
					User u = new User();
					u.setUid(uid);
					u.setUname(uname);
					u.setPwd(pwd);
					u.setType(type);
					u.setQuestion(question);
					u.setAnswer(answer);
					u.setState(state);
					u.setRegistDate(date);
					u.setActiveState(activestate);
					u.setEmail(email);
					userlist.add(u);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
			return userlist;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public List<User> findbylike(String str) {
		
		String sql = "select * from user where uname like ? and type='manager'";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+str+"%");
			rs = pstmt.executeQuery();
			List<User> userlist = new ArrayList<User>();
			while(rs.next())
			{
				try {
					int uid = rs.getInt("uid");
					String uname = rs.getString("uname");
					String pwd = rs.getString("pwd");
					String type = rs.getString("type");
					String question =rs.getString("question");
					String answer = rs.getString("answer");
					String state = rs.getString("state");
					String resultDate = rs.getString("registDate");
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
					Date date = sdf.parse(resultDate);
					String activestate = rs.getString("activestate");
					String email = rs.getString("email");
					User u = new User();
					u.setUid(uid);
					u.setUname(uname);
					u.setPwd(pwd);
					u.setType(type);
					u.setQuestion(question);
					u.setAnswer(answer);
					u.setState(state);
					u.setRegistDate(date);
					u.setActiveState(activestate);
					u.setEmail(email);
					userlist.add(u);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
			return userlist;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
	}

	public User findbyuserid(int uid) {
		String sql = "select * from user where uid =? and type='manager'";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,uid);
			rs = pstmt.executeQuery();
			User u = new User();
			if(rs.next())
			{
				String uname = rs.getString("uname");
				String pwd = rs.getString("pwd");
				String type = rs.getString("type");
				String question =rs.getString("question");
				String answer = rs.getString("answer");
				String state = rs.getString("state");
				String resultDate = rs.getString("registDate");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
				Date date = sdf.parse(resultDate);
				String activestate = rs.getString("activestate");
				String email = rs.getString("email");
				
				u.setUid(uid);
				u.setUname(uname);
				u.setPwd(pwd);
				u.setType(type);
				u.setQuestion(question);
				u.setAnswer(answer);
				u.setState(state);
				u.setRegistDate(date);
				u.setActiveState(activestate);
				u.setEmail(email);
				return u;
			}
			else
				return null;
			
		}
		catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

	public boolean update(User u) {//更新密码
		String sql = "Update user set pwd = ? where uname =?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, u.getPwd());
			pstmt.setString(2, u.getUname());
			int judgenum =  pstmt.executeUpdate();
			if(judgenum!=0)
				return true;
			return false;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean updateActiveState(String activeState,int uid)
	{
		String sql = "Update user set activeState = ? where uid = ?";
		try {
			pstmt =conn.prepareStatement(sql);
			pstmt.setString(1, activeState);
			pstmt.setInt(2, uid);
			int judgenum =pstmt.executeUpdate();
			/*User u = new User();
			u = findbyuserid(uid);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
			String resultDate=sdf.format(u.getRegistDate());
			System.out.println(resultDate);*/
			if(judgenum!=0)
			{
				return true;
			}
			else
			{
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		
	}
	public User login(User u) {
		// TODO Auto-generated method stub
		String sql="select * from user where uname=? and pwd=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,u.getUname());
			pstmt.setString(2,u.getPwd());
			rs=pstmt.executeQuery();
			if(rs.next()){
				int uid = rs.getInt("uid");
				String uname = rs.getString("uname");
				String pwd = rs.getString("pwd");
				String type = rs.getString("type");
				String question =rs.getString("question");
				String answer = rs.getString("answer");
				String state = rs.getString("state");
				String resultDate = rs.getString("registDate");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
				Date date = sdf.parse(resultDate);
				String activestate = rs.getString("activestate");
				String email = rs.getString("email");
				u.setUid(uid);
				u.setUname(uname);
				u.setPwd(pwd);
				u.setType(type);
				u.setQuestion(question);
				u.setAnswer(answer);
				u.setState(state);
				u.setRegistDate(date);
				u.setActiveState(activestate);
				u.setEmail(email);
				return u;
			}
			else
			{
				return null;
			}
		}
		catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public boolean updateState(User u)
	{
		String sql = "Update user set state = ? where uid =?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, u.getState());
			pstmt.setInt(2, u.getUid());
			int judgenum =  pstmt.executeUpdate();
			if(judgenum!=0)
				return true;
			return false;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	public int findlAllCount(){
		int count=0;
		String sql="select count(*) from user where type='manager'";
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()){
				count=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}//method.
	
}
