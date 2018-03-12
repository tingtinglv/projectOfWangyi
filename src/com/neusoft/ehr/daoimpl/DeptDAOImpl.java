package com.neusoft.ehr.daoimpl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neusoft.ehr.comm.*;
import com.neusoft.ehr.dao.DeptDAO;
import com.neusoft.ehr.entity.Dept;

public class DeptDAOImpl implements DeptDAO{
    Connection conn=DBUtils.getConn();
    PreparedStatement pstmt;
    ResultSet rs;
	//新增
	public void add(Dept d) {
		// TODO Auto-generated method stub
		String sql = "insert into department(dep_seq,dep_name,dep_type,dep_tel,dep_desc,dep_updep,dep_date) values(?,?,?,?,?,?,?)";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, d.getDep_seq());
			pstmt.setString(2, d.getDep_name());
			pstmt.setString(3, d.getDep_type());
			pstmt.setString(4, d.getDep_tel());
			pstmt.setString(5, d.getDep_desc());
			pstmt.setString(6, d.getDep_updep());
			pstmt.setString(7, d.getDep_date());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//删除
	public void dele(Dept d) {
		// TODO Auto-generated method stub
		String sql = "delete from department where dep_seq = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,d.getDep_seq());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//通过编号查找
	public Dept findbyid(String id) {
		// TODO Auto-generated method stub
		String sql = "select * from department where dep_seq = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				Dept d = new Dept();
				d.setDep_id(rs.getInt("dep_id"));
				d.setDep_seq(rs.getString("dep_seq"));
				d.setDep_name(rs.getString("dep_name"));
				d.setDep_type(rs.getString("dep_type"));
				d.setDep_tel(rs.getString("dep_tel"));
				d.setDep_desc(rs.getString("dep_desc"));
				d.setDep_updep(rs.getString("dep_updep"));
				d.setDep_date(rs.getString("dep_date"));
				return d;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
//通过名字查找
	public List<Dept> findbyname(String name) {
		// TODO Auto-generated method stub
		List<Dept> l = new ArrayList<Dept>();
		String sql = "select * from department where dep_name = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			if(rs.next()){
				Dept d = new Dept();
				d.setDep_id(rs.getInt("dep_id"));
				d.setDep_seq(rs.getString("dep_seq"));
				d.setDep_name(rs.getString("dep_name"));
				d.setDep_type(rs.getString("dep_type"));
				d.setDep_tel(rs.getString("dep_tel"));
				d.setDep_desc(rs.getString("dep_desc"));
				d.setDep_updep(rs.getString("dep_updep"));
				d.setDep_date(rs.getString("dep_date"));
				l.add(d);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}
//部门调动使用
	public Dept selebyname(String name) {
		// TODO Auto-generated method stub
		Dept d = new Dept();
		String sql = "select * from department where dep_name = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			if(rs.next()){	
			    d.setDep_id(rs.getInt("dep_id"));
				d.setDep_seq(rs.getString("dep_seq"));
				d.setDep_name(rs.getString("dep_name"));
				d.setDep_type(rs.getString("dep_type"));
				d.setDep_tel(rs.getString("dep_tel"));
				d.setDep_desc(rs.getString("dep_desc"));
				d.setDep_updep(rs.getString("dep_updep"));
				d.setDep_date(rs.getString("dep_date"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d;
	}
//通过类型查找
	public List<Dept> findbytype(String type) {
		// TODO Auto-generated method stub
		List<Dept> l = new ArrayList<Dept>();
		String sql = "select * from department where dep_type = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, type);
			rs = pstmt.executeQuery();
			if(rs.next()){
				Dept d = new Dept();
				d.setDep_seq(rs.getString("dep_seq"));
				d.setDep_name(rs.getString("dep_name"));
				d.setDep_type(rs.getString("dep_type"));
				d.setDep_tel(rs.getString("dep_tel"));
				d.setDep_desc(rs.getString("dep_desc"));
				d.setDep_updep(rs.getString("dep_updep"));
				d.setDep_date(rs.getString("dep_date"));
				l.add(d);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}
//修改
	public void update(Dept d) {
		// TODO Auto-generated method stub
		String sql="update department set dep_seq = ?,dep_name = ?,dep_tel = ?,dep_type = ?,dep_desc = ?,dep_updep = ?,dep_date = ? where dep_seq = ?";
        try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, d.getDep_seq());
			pstmt.setString(2, d.getDep_name());
			pstmt.setString(3, d.getDep_tel());
			pstmt.setString(4, d.getDep_type());
			pstmt.setString(5, d.getDep_desc());
			pstmt.setString(6, d.getDep_updep());
			pstmt.setString(7, d.getDep_date());
			pstmt.setString(8, d.getDep_seq());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//模糊查询
	public List<Dept> findbylike(String str) {
		// TODO Auto-generated method stub
		List<Dept> l = new ArrayList<Dept>();
		String sql = "select * from department where dep_name like ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+str+"%");
			rs = pstmt.executeQuery();
			while(rs.next()){
				Dept d = new Dept();
				d.setDep_seq(rs.getString("dep_seq"));
				d.setDep_name(rs.getString("dep_name"));
				d.setDep_type(rs.getString("dep_type"));
				d.setDep_tel(rs.getString("dep_tel"));
				d.setDep_desc(rs.getString("dep_desc"));
				d.setDep_updep(rs.getString("dep_updep"));
				d.setDep_date(rs.getString("dep_date"));
				l.add(d);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}
//全查
	public List<Dept> findall() {
		// TODO Auto-generated method stub
		List<Dept> l = new ArrayList<Dept>();
		String sql = "select * from department";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Dept d = new Dept();
				d.setDep_seq(rs.getString("dep_seq"));
				d.setDep_name(rs.getString("dep_name"));
				d.setDep_type(rs.getString("dep_type"));
				d.setDep_tel(rs.getString("dep_tel"));
				d.setDep_desc(rs.getString("dep_desc"));
				d.setDep_updep(rs.getString("dep_updep"));
				d.setDep_date(rs.getString("dep_date"));
				l.add(d);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}
	//用分页实现全查
    public List<Dept> findall(Page page){
    	String sql = "select * from department limit ?,?";
    	List<Dept> l = new ArrayList<Dept>(); 
    	try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,page.getBeginIndex());
			pstmt.setInt(2,page.getEveryPage());
			rs = pstmt.executeQuery();
			while(rs.next()){
				Dept d = new Dept();
				d.setDep_seq(rs.getString("dep_seq"));
				d.setDep_name(rs.getString("dep_name"));
				d.setDep_type(rs.getString("dep_type"));
				d.setDep_tel(rs.getString("dep_tel"));
				d.setDep_desc(rs.getString("dep_desc"));
				d.setDep_updep(rs.getString("dep_updep"));
				d.setDep_date(rs.getString("dep_date"));
				l.add(d);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
    }
    //查询总数
    public int findallcount(){
    	int count = 0;
    	String sql = "select count(*) from department";
    	try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()){
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return count;
    }
    //分页模糊查询
	public List<Dept> findbylike(String str, Page page) {
		// TODO Auto-generated method stub
		List<Dept> l = new ArrayList<Dept>();
		String sql = "select * from department where dep_name like ? limit ?,?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+str+"%");
			pstmt.setInt(2,page.getBeginIndex());
			pstmt.setInt(3,page.getEveryPage());
			rs = pstmt.executeQuery();
			while(rs.next()){
				Dept d = new Dept();
				d.setDep_seq(rs.getString("dep_seq"));
				d.setDep_name(rs.getString("dep_name"));
				d.setDep_type(rs.getString("dep_type"));
				d.setDep_tel(rs.getString("dep_tel"));
				d.setDep_desc(rs.getString("dep_desc"));
				d.setDep_updep(rs.getString("dep_updep"));
				d.setDep_date(rs.getString("dep_date"));
				l.add(d);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}
	//分页按类型查询
	public List<Dept> findbytype(String type, Page page) {
		// TODO Auto-generated method stub
		List<Dept> l = new ArrayList<Dept>();
		String sql = "select * from department where dep_type = ? limit ?,?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, type);
			pstmt.setInt(2,page.getBeginIndex());
			pstmt.setInt(3,page.getEveryPage());
			rs = pstmt.executeQuery();
			if(rs.next()){
				Dept d = new Dept();
				d.setDep_seq(rs.getString("dep_seq"));
				d.setDep_name(rs.getString("dep_name"));
				d.setDep_type(rs.getString("dep_type"));
				d.setDep_tel(rs.getString("dep_tel"));
				d.setDep_desc(rs.getString("dep_desc"));
				d.setDep_updep(rs.getString("dep_updep"));
				d.setDep_date(rs.getString("dep_date"));
				l.add(d);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}
	//模糊查询部门数
	public int findbylikecount(String str) {
		// TODO Auto-generated method stub
		int count = 0;
    	String sql = "select count(*) from department where dep_name like ? ";
    	try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, "%"+str+"%");
			rs=pstmt.executeQuery();
			if(rs.next()){
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return count;
	}
	//按类型查询部门数
	public int findbytypecount(String type) {
		// TODO Auto-generated method stub
		int count = 0;
    	String sql = "select count(*) from department where dep_type = ? ";
    	try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, type);
			rs=pstmt.executeQuery();
			if(rs.next()){
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return count;	}
	
	//真正的查询。。。
	public List<Dept> select(String seq, String name, String type, Page page) {
		// TODO Auto-generated method stub
		List<Dept> l = new ArrayList<Dept>();
		String sql = "select * from department where dep_seq like ? and dep_name like ? and dep_type like ? limit ?,?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+seq+"%");
			pstmt.setString(2, "%"+name+"%");
			pstmt.setString(3, "%"+type+"%");
			pstmt.setInt(4,page.getBeginIndex());
			pstmt.setInt(5,page.getEveryPage());
			rs = pstmt.executeQuery();
			while(rs.next()){
				Dept d = new Dept();
				d.setDep_seq(rs.getString("dep_seq"));
				d.setDep_name(rs.getString("dep_name"));
				d.setDep_type(rs.getString("dep_type"));
				d.setDep_tel(rs.getString("dep_tel"));
				d.setDep_desc(rs.getString("dep_desc"));
				d.setDep_updep(rs.getString("dep_updep"));
				d.setDep_date(rs.getString("dep_date"));
				l.add(d);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}
	public int selectcount(String seq, String name, String type) {
		// TODO Auto-generated method stub
		int count = 0;
    	String sql = "select count(*) from department where dep_seq like ? and dep_name like ? and dep_type like ? ";
    	try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, "%"+seq+"%");
			pstmt.setString(2, "%"+name+"%");
			pstmt.setString(3, "%"+type+"%");
			rs=pstmt.executeQuery();
			if(rs.next()){
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return count;
	}
}
