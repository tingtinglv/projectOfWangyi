package com.neusoft.ehr.daoimpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neusoft.ehr.comm.DBUtilTest;
import com.neusoft.ehr.comm.DBUtils;
import com.neusoft.ehr.comm.Page;
import com.neusoft.ehr.dao.PostchDAO;
import com.neusoft.ehr.entity.Post;
import com.neusoft.ehr.entity.Postch;

public class PostchDAOImp implements PostchDAO{
	Connection conn=DBUtils.getConn();
	PreparedStatement pstmt;
	ResultSet rs;

	public void add(Postch postch) {
		// TODO Auto-generated method stub
		try {
			String sql = "insert into postch(old_postid,postch_postid,trance_type,reason,reviews,trantime,emp_id,trance_mode) values (?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,postch.getOld_postid());
			pstmt.setInt(2,postch.getPostch_postid()); 
			pstmt.setString(3,postch.getTrance_type());
			pstmt.setString(4,postch.getReason());
			pstmt.setString(5,postch.getReviews());
			pstmt.setDate(6,(Date)postch.getTrantime());
			pstmt.setInt(7,postch.getEmp_id());
			pstmt.setString(8,postch.getTrance_mode());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Postch> findAllPostch(Page page) {
		// TODO Auto-generated method stub
		List<Postch> list = new ArrayList<Postch>();
		String sql = "select * from postch limit ?,?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, page.getBeginIndex());
			pstmt.setInt(2, page.getEveryPage());
			rs=pstmt.executeQuery();
			while(rs.next()){
				Postch postch = new Postch();
				postch.setOld_postid(rs.getInt(2));
				postch.setPostch_postid(rs.getInt(3));
				postch.setTrance_type(rs.getString(4));
				postch.setReason(rs.getString(5));
				postch.setReviews(rs.getString(6));
				postch.setTrantime(rs.getDate(7));
				postch.setEmp_id(rs.getInt(8));
				postch.setTrance_mode(rs.getString(9));
				list.add(postch);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public int findAllCount() {
		// TODO Auto-generated method stub
		int count = 0;
		String sql = "select count(*) from postch";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()){
				count=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	public int count(String seq, String name, String type,String date1,String date2) {
		// TODO Auto-generated method stub
		int count=0;
		try {
			String sql = "select count(*) from postch p,employee s where p.emp_id=s.emp_id and ";
			if(seq!=null&&seq!=""){
				sql=sql+"s.emp_seq like '%"+seq+"%' and ";
			}
			if(name!=null&&name!=""){
				sql=sql+"s.emp_name like '%"+name+"%' and ";
			}
			if(type!=null&&type!=""){
				sql=sql+"p.trance_type like '%"+type+"%' and ";
			}
			if(date1!=""&&date1!=null){
				Date start_date = Date.valueOf(date1);
				sql=sql+"trantime > '"+start_date+"' and ";
			}
			if(date2!=""&&date2!=null){
				Date end_date = Date.valueOf(date2);
				sql=sql+"trantime < '"+end_date+"' and ";
			}
			sql=sql+"1>0 ";
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	public List<Postch> find(String seq, String name, String type, Page page,String date1,String date2) {
		// TODO Auto-generated method stub
		List<Postch> list =new ArrayList<Postch>();
		try {
			String sql = "select postch_id,old_postid,postch_postid,trance_type,reason,reviews,trantime,p.emp_id,trance_mode from postch p,employee s where p.emp_id=s.emp_id and ";
			if(seq!=null&&seq!=""){
				sql=sql+"s.emp_seq like '%"+seq+"%' and ";
			}
			if(name!=null&&name!=""){
				sql=sql+"s.emp_name like '%"+name+"%' and ";
			}
			if(type!=null&&type!=""){
				sql=sql+"p.trance_type like '%"+type+"%' and ";
			}
			if(date1!=""&&date1!=null){
				Date start_date = Date.valueOf(date1);
				sql=sql+"trantime > '"+start_date+"' and ";
			}
			if(date2!=""&&date2!=null){
				Date end_date = Date.valueOf(date2);
				sql=sql+"trantime < '"+end_date+"' and ";
			}
			sql=sql+"1>0 limit ?,?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,page.getBeginIndex());
			pstmt.setInt(2,page.getEveryPage());
			rs = pstmt.executeQuery();
			while(rs.next()){
				Postch p = new Postch();
				p.setPostch_id(rs.getInt(1));
				p.setOld_postid(rs.getInt(2));
				p.setPostch_postid(rs.getInt(3));
				p.setTrance_type(rs.getString(4));
				p.setReason(rs.getString(5));
				p.setReviews(rs.getString(6));
				p.setTrantime(rs.getDate(7));
				p.setEmp_id(rs.getInt(8));
				p.setTrance_mode(rs.getString(9));
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
