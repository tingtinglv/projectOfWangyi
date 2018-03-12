package com.neusoft.ehr.daoimpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neusoft.ehr.comm.DBUtils;
import com.neusoft.ehr.comm.Page;
import com.neusoft.ehr.dao.DepchDAO;
import com.neusoft.ehr.entity.Depch;
import com.neusoft.ehr.entity.Postch;

public class DepchDAOImpl implements DepchDAO{
	Connection conn=DBUtils.getConn();
    PreparedStatement pstmt;
    ResultSet rs;
	public void Depch(Depch d) {
		// TODO Auto-generated method stub
		String sql = "insert into depch " +
				" (old_depid,depch_depid,depch_class,depch_yy,depch_reviews,depch_time,depch_mode,emp_id,emp_name,old_name,depch_name,emp_seq)" +
				" values(?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, d.getOld_depid());
			pstmt.setInt(2, d.getDepch_depid());
			pstmt.setString(3, d.getDepch_class());
			pstmt.setString(4, d.getDepch_yy());
			pstmt.setString(5, d.getDepch_reviews());
			pstmt.setString(6, d.getDepch_time());
			pstmt.setString(7, d.getDepch_mode());
			pstmt.setInt(8, d.getEmp_id());
			pstmt.setString(9, d.getEmp_name());
			pstmt.setString(10, d.getOld_name());
			pstmt.setString(11, d.getDepch_name());
			pstmt.setString(12, d.getEmp_seq());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Depch> sele(String sDate, String eDate,
			String empname,String empSeq, String type,Page page) {
		// TODO Auto-generated method stub
		List<Depch> list =new ArrayList<Depch>();
		Date sdate = Date.valueOf(sDate);
		Date edate = Date.valueOf(eDate);
		try {
			String sql = "select * from depch where depch_time>=? and depch_time<=? ";
			if(empname!=null&&empname!=""){
				sql=sql+" and emp_name like '%"+empname+"%'";
			}
			if(type!=null&&!type.equals("")){
				sql=sql+" and depch_mode ='"+type+"'";
			}
			if (empSeq!=null&&empSeq!=""){
				sql=sql+" and emp_seq ='"+empSeq+"'";
			}
			sql=sql+"limit ?,?";
			//System.out.println(sql);
			pstmt = conn.prepareStatement(sql);
			pstmt.setDate(1, sdate);
			pstmt.setDate(2, edate);
			pstmt.setInt(3,page.getBeginIndex());
			pstmt.setInt(4,page.getEveryPage());
			rs = pstmt.executeQuery();
			while(rs.next()){
				Depch dc = new Depch();
				dc.setOld_depid(rs.getInt("old_depid"));
				dc.setOld_name(rs.getString("old_name"));
				dc.setDepch_depid(rs.getInt("depch_depid"));
				dc.setDepch_name(rs.getString("depch_name"));
				dc.setDepch_class(rs.getString("depch_class"));
				dc.setDepch_yy(rs.getString("depch_yy"));
				dc.setDepch_reviews(rs.getString("depch_reviews"));
				dc.setDepch_time(rs.getString("depch_time"));
				dc.setDepch_mode(rs.getString("depch_mode"));
				dc.setEmp_id(rs.getInt("emp_id"));
				dc.setEmp_name(rs.getString("emp_name"));
				dc.setEmp_seq(rs.getString("emp_seq"));
				list.add(dc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
    //²éÑ¯ÊýÁ¿
	public int selecount(String sDate, String eDate,
			String empname,String empSeq, String type){
		int count=0;
		Date sdate = Date.valueOf(sDate);
		Date edate = Date.valueOf(eDate);
		try {
			String sql = "select count(*) from depch where depch_time>=? and depch_time<=? ";
			if(empname!=null&&!empname.equals("")){
				sql=sql+" and emp_name like '%"+empname+"%'";
			}
			if(type!=null&&!type.equals("")){
				sql=sql+"and depch_mode ='"+type+"' ";
			}
			if (empSeq!=null&&empSeq!=""){
				sql=sql+"and emp_seq ='"+empSeq+"' ";
			}
			pstmt = conn.prepareStatement(sql);
			pstmt.setDate(1, sdate);
			pstmt.setDate(2, edate);
			rs = pstmt.executeQuery();
			if(rs.next()){
				count = rs.getInt(1);
			}
			//System.out.println(count);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}
	

}
