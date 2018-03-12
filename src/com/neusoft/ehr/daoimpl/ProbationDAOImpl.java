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
import com.neusoft.ehr.dao.ProbationDAO;
import com.neusoft.ehr.entity.Probation;

public class ProbationDAOImpl implements ProbationDAO{
	Connection conn=DBUtils.getConn();
	PreparedStatement pstmt;
	ResultSet rs;
	
	//添加试用期员工
	public boolean add(Probation p) {
		// TODO Auto-generated method stub
		String sql="insert into probation(start_date,end_date,result,check_time,reviews,remark,emp_id)"
			+"values(?,?,?,?,?,?,?)";
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setDate(1,p.getStartDate());
			pstmt.setDate(2, p.getEndDate());
			pstmt.setString(3, p.getResult());
			pstmt.setDate(4, p.getCheckTime());
			pstmt.setString(5, p.getReviews());
			pstmt.setString(6,p.getRemark());
			pstmt.setInt(7, p.getEmpId());
			
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
	
	//删除试用期员工
	public boolean del(int empId) {
		// TODO Auto-generated method stub
		return false;
	}
	
	//更新试用期员工试用信息
	public boolean update(Probation p) {
		// TODO Auto-generated method stub
		String sql = "update probation set start_date=?,end_date=?,result=?,check_time=?,reviews=?,remark=? "+
		"where probation_id=?;";
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setDate(1,p.getStartDate());
			pstmt.setDate(2, p.getEndDate());
			pstmt.setString(3, p.getResult());
			pstmt.setDate(4, p.getCheckTime());
			pstmt.setString(5, p.getReviews());
			pstmt.setString(6,p.getRemark());
			pstmt.setInt(7, p.getEmpId());
			
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
	
	//查询所有试用期员工
	public List<Probation> findAll() {
		// TODO Auto-generated method stub
		String sql="select probation_id,emp_seq,emp_name,d.dep_seq,dep_name,p.post_seq,post_name,pb.start_date,end_date," +
		"result,check_time,reviews,remark,e.emp_id " +
		"from probation pb,employee e,department d,post p " +
		"where pb.emp_id=e.emp_id and e.dep_id=d.dep_id and e.post_id=p.post_id;";
		try {
			pstmt= conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<Probation> probList = new ArrayList<Probation>();
			while(rs.next()){
				Probation p = new Probation();
				p.setProbationId(rs.getInt("probation_id"));
				p.setEmpSeq(rs.getString("emp_seq"));
				p.setEmpName(rs.getString("emp_name"));
				p.setDepName(rs.getString("dep_name"));
				p.setDepSeq(rs.getString("dep_seq"));
				p.setPostName(rs.getString("post_name"));
				p.setPostSeq(rs.getString("post_seq"));
				p.setStartDate(rs.getDate("start_date"));
				p.setEndDate(rs.getDate("end_date"));
				p.setResult(rs.getString("result"));
				p.setCheckTime(rs.getDate("check_time"));
				p.setReviews(rs.getString("reviews"));
				p.setRemark(rs.getString("remark"));
				p.setEmpId(rs.getInt("e.emp_id"));
				probList.add(p);
			}
			return probList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		finally{
			DBUtils.dbclose(null,pstmt, conn);
		}
	}
	
	
	public List<Probation> findByDate(Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//通过试用期员工编号查询员工信息
	public Probation findBySeq(String empSeq) {
		// TODO Auto-generated method stub
		String sql = "select probation_id,emp_seq,emp_name,d.dep_seq,dep_name,p.post_seq,post_name,pb.start_date,end_date,pb.emp_id," +
				"result,check_time,reviews,remark " +
				"from probation pb,employee e,department d,post p " +
				"where pb.emp_id=e.emp_id and e.dep_id=d.dep_id and e.post_id=p.post_id and emp_seq="+empSeq+";";
		try {
			pstmt= conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			Probation p = new Probation();
			if(rs.next()){
				p.setProbationId(rs.getInt("probation_id"));
				p.setEmpSeq(rs.getString("emp_seq"));
				p.setEmpName(rs.getString("emp_name"));
				p.setDepName(rs.getString("dep_name"));
				p.setDepSeq(rs.getString("dep_seq"));
				p.setPostName(rs.getString("post_name"));
				p.setPostSeq(rs.getString("post_seq"));
				p.setStartDate(rs.getDate("start_date"));
				p.setEndDate(rs.getDate("end_date"));
				p.setResult(rs.getString("result"));
				p.setCheckTime(rs.getDate("check_time"));
				p.setReviews(rs.getString("reviews"));
				p.setRemark(rs.getString("remark"));
				p.setEmpId(rs.getInt("emp_id"));
				return p ;
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		finally{
			DBUtils.dbclose(null,pstmt, conn);
		}
	}
	
	//通过结果查询试用期员工
	public List<Probation> findByResult(String result) {
		// TODO Auto-generated method stub
		String sql = "select probation_id,emp_seq,emp_name,d.dep_seq,dep_name,p.post_seq,post_name,pb.start_date,end_date," +
		"result,check_time,reviews,remark " +
		"from probation pb,employee e,department d,post p " +
		"where pb.emp_id=e.emp_id and e.dep_id=d.dep_id and e.post_id=p.post_id and emp_seq="+result+";";
		try {
			pstmt= conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<Probation> probList = new ArrayList<Probation>();
			if(rs.next()){
				Probation p = new Probation();
				p.setProbationId(rs.getInt("probation_id"));
				p.setEmpSeq(rs.getString("emp_seq"));
				p.setEmpName(rs.getString("emp_name"));
				p.setDepName(rs.getString("dep_name"));
				p.setDepSeq(rs.getString("dep_seq"));
				p.setPostName(rs.getString("post_name"));
				p.setPostSeq(rs.getString("post_seq"));
				p.setStartDate(rs.getDate("start_date"));
				p.setEndDate(rs.getDate("end_date"));
				p.setResult(rs.getString("result"));
				p.setCheckTime(rs.getDate("check_time"));
				p.setReviews(rs.getString("reviews"));
				p.setRemark(rs.getString("remark"));
				p.setEmpId(rs.getInt("e.emp_id"));
				probList.add(p);
			}
			return probList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		finally{
			DBUtils.dbclose(null,pstmt, conn);
		}
	}
	
	public List<Probation> find(Page page,String empSeq,String empName,String depName,String postName,String startDate,String endDate,String flag,String result){
		String sql= "select probation_id,emp_seq,emp_name,d.dep_seq,dep_name,p.post_seq,post_name,pb.start_date,end_date," +
		"result,check_time,reviews,remark " +
		"from probation pb,employee e,department d,post p " +
		"where pb.emp_id=e.emp_id and e.dep_id=d.dep_id and e.post_id=p.post_id and result='试用' or result='延期' ";
		String sqlCount= "select count(*) from probation pb,employee e,department d,post p " +
		"where pb.emp_id=e.emp_id and e.dep_id=d.dep_id and e.post_id=p.post_id and result='试用' or result='延期' ";
		//sqlCount用于查询总数
		if(startDate!=null&&!startDate.equals("")&&endDate!=null&&!endDate.equals("")){
			Date start =Date.valueOf(startDate);
			Date end = Date.valueOf(endDate);
			if(flag.equals("start")){
				sql= sql +"and pb.start_date between "+start+" and "+end+" ";
				sqlCount = sqlCount+ "and pb.start_date between "+start+" and "+end+" ";
			}else if(flag.equals("end")){
				sql= sql +"and end_date between "+start+" and "+end+" ";
				sqlCount = sqlCount+ "and end_date between "+start+" and "+end+" ";
			}else if(flag.equals("btw")){
				sql= sql +"and start_date>"+start+" and end_date<"+end+" ";
				sqlCount = sqlCount+"and start_date>"+start+" and end_date<"+end+" ";
			}else if(flag.equals("btwcheck")){
				sql= sql +"and check_time between "+start+" and "+end+" ";
				sqlCount = sqlCount+ "and check_time between "+start+" and "+end+" ";
			}
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
			sqlCount = sqlCount+ "and post_name like '%"+postName+"%' ";
		}
		if(result!=null&&!result.equals("")){
			sql = sql + "and result ='"+result+"'";
			sqlCount = sqlCount+ "and result='"+result+"' ";
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
			List<Probation> pbList = new ArrayList<Probation>();
			while(rs.next()){
				Probation pb = new Probation();
				pb.setProbationId(rs.getInt("probation_id"));
				pb.setEmpSeq(rs.getString("emp_seq"));
				pb.setEmpName(rs.getString("emp_name"));
				pb.setDepSeq(rs.getString("dep_seq"));
				pb.setDepName(rs.getString("dep_name"));
				pb.setPostSeq(rs.getString("post_seq"));
				pb.setPostName(rs.getString("post_name"));
				pb.setStartDate(rs.getDate("start_date"));
				pb.setEndDate(rs.getDate("end_date"));
				pb.setRemark(rs.getString("remark"));
				pb.setResult(rs.getString("result"));
				pb.setReviews(rs.getString("reviews"));
				pb.setCheckTime(rs.getDate("check_time"));
				pbList.add(pb);
			}
			return pbList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		finally{
			DBUtils.dbclose(null,pstmt, conn);
		}
	}
	
	public int findAllCount() {
		// TODO Auto-generated method stub
		String sql="select count(*) from probation;";
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
