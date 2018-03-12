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
import com.neusoft.ehr.comm.PageUtil;
import com.neusoft.ehr.dao.FiredDAO;
import com.neusoft.ehr.entity.Fired;
import com.neusoft.ehr.entity.Probation;

public class FiredDAOImpl implements FiredDAO{
	Connection conn=DBUtils.getConn();
	PreparedStatement pstmt;
	ResultSet rs;
	public boolean add(Fired f) {
		// TODO Auto-generated method stub.
		String sql="insert into Fired(fired_date,fired_type,fired_traced,human_resource,fired_memo,emp_id)values(?,?,?,?,?,?)";
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setDate(1,f.getFiredDate());
			pstmt.setString(2, f.getFiredType());
			pstmt.setString(3, f.getFiredTraced());
			pstmt.setString(4, f.getHumanResource());
			pstmt.setString(5, f.getFiredMemo());
			pstmt.setInt(6, f.getEmpId());
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
		finally
		{
			DBUtils.dbclose(null,pstmt, conn);
		}
	}

	public boolean del(int empId) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

	public boolean update(Fired f) {
		// TODO Auto-generated method stub
		return false;
	}
	

	public List<Fired> find(Page page, String empSeq, String empName,
			String depName, String postName, String startDate, String endDate,String firedType) {
		// TODO Auto-generated method stub
		String sql= "select fired_id,emp_seq,emp_name,dep_seq,dep_name,post_seq,post_name," +
		"fired_date,fired_type,fired_traced,human_resource,fired_memo " +
		"from fired f,employee e,department d,post p " +
		"where f.emp_id=e.emp_id and e.dep_id=d.dep_id and e.post_id=p.post_id ";
		String sqlCount= "select count(*) from fired f,employee e,department d,post p " +
		"where f.emp_id=e.emp_id and e.dep_id=d.dep_id and e.post_id=p.post_id ";
		//sqlCount用于查询总数
		if(startDate!=null&&!startDate.equals("")&&endDate!=null&&!endDate.equals("")){
			Date start =Date.valueOf(startDate);
			Date end = Date.valueOf(endDate);
			sql= sql +"and check_time between "+start+" and "+end+" ";
			sqlCount = sqlCount+ "and check_time between "+start+" and "+end+" ";
		}
		if(empSeq!=null&&!empSeq.equals("")){
			sql= sql +"and emp_seq='"+empSeq+"' ";
			sqlCount = sqlCount+ "and emp_seq='"+empSeq+"' ";
		}
		if(empName!=null&&!empName.equals("")){
			sql = sql + "and emp_name like '%"+empName+ "%' ";
			sqlCount = sqlCount+ "and emp_name like '%"+empName+ "%' ";
		}
		if(depName!=null&&!depName.equals("")){
			sql = sql + "and dep_name like '%"+depName+"%' ";
			sqlCount = sqlCount+ "and dep_name like '%"+depName+"%' ";
		}
		if(postName!=null&&!postName.equals("")){
			sql = sql + "and post_name like '%"+postName+"%'";
			sqlCount = sqlCount+ "and post_name like '%"+postName+"%'";
		}
		if(firedType!=null&&!firedType.equals("")){
			sql = sql + "and fired_type='"+firedType+"'";
			sqlCount = sqlCount+ "and fired_type='"+firedType+"'";
		}
		sql=sql+"limit ?,?;";
		sqlCount = sqlCount + ";";
		
		try {
			//修改总页数和总记录数
			if(page.getBeginIndex()==0){
				pstmt= conn.prepareStatement(sqlCount);
				rs = pstmt.executeQuery();
				int count = 0;
				if(rs.next()){
					count=rs.getInt(1);
				}
				page.setTotalCount(count);
				page.setTotalPage(PageUtil.getTotalPage(page.getEveryPage(), count));
				rs = null;
			}
			pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, page.getBeginIndex());
			pstmt.setInt(2, page.getEveryPage());
			rs = pstmt.executeQuery();
			List<Fired> fList = new ArrayList<Fired>();
			while(rs.next()){
				Fired f = new Fired();
				f.setFiredId(rs.getInt("fired_id"));
				f.setEmpSeq(rs.getString("emp_seq"));
				f.setEmpName(rs.getString("emp_name"));
				f.setDepSeq(rs.getString("dep_seq"));
				f.setDepName(rs.getString("dep_name"));
				f.setPostSeq(rs.getString("post_seq"));
				f.setPostName(rs.getString("post_name"));
				f.setFiredDate(rs.getDate("fired_date"));
				f.setFiredType(rs.getString("fired_type"));
				f.setFiredTraced(rs.getString("fired_traced"));
				f.setHumanResource(rs.getString("human_resource"));
				f.setFiredMemo(rs.getString("fired_memo"));
				fList.add(f);
			}
			return fList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		finally{
			DBUtils.dbclose(null,pstmt, conn);
		}
	}

	public List<Fired> findByDate(Date start, Date end) {
		// TODO Auto-generated method stub
		return null;
	}

	public Fired findById(int empId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Fired> findByType(String str) {
		// TODO Auto-generated method stub
		return null;
	}

	public int findAllCount() {
		// TODO Auto-generated method stub
		String sql="select count(*) from fired;";
		try{
			int count=0;
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()){
				count=rs.getInt(1);
			}
			return count;
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		finally{
			DBUtils.dbclose(null,pstmt, conn);
		}
	}

}
