package com.neusoft.ehr.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neusoft.ehr.comm.DBUtils;
import com.neusoft.ehr.comm.Page;
import com.neusoft.ehr.comm.PageUtil;
import com.neusoft.ehr.dao.StaffDAO;
import com.neusoft.ehr.entity.Staff;

public class StaffDAOImpl implements StaffDAO{
	Connection conn=DBUtils.getConn();
	PreparedStatement pstmt;
	ResultSet rs;
	public boolean add(Staff s) {
		// TODO Auto-generated method stub
		String sql="insert into employee(emp_seq,emp_name,emp_sex,emp_birth,emp_card,start_date,job_date," +
				"emp_forms,emp_origin,polit_status,nation,native_place,emp_tel,email,stature,blood_type ,marriage," +
				"birthplace,domicile_place,education,degree,school,major,grad_date,type,dep_id,post_id) "+
				"values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,s.getEmpSeq());
			pstmt.setString(2,s.getEmpName());
			pstmt.setString(3,s.getEmpSex());
			pstmt.setDate(4,s.getEmpBirth());
			pstmt.setString(5,s.getEmpCard());
			pstmt.setDate(6,s.getStartDate());
			pstmt.setDate(7,s.getJobDate());
			pstmt.setString(8,s.getEmpForms());
			pstmt.setString(9, s.getEmpOrigin());
			pstmt.setString(10,s.getPolitStatus());
			pstmt.setString(11,s.getNation());
			pstmt.setString(12,s.getNativePlace());
			pstmt.setString(13,s.getEmpTel());
			pstmt.setString(14,s.getEmail());
			pstmt.setString(15,s.getStature());
			pstmt.setString(16,s.getBloodType());
			pstmt.setString(17,s.getMarriage());
			pstmt.setString(18,s.getBirthplace());
			pstmt.setString(19,s.getDomicilePlace());
			pstmt.setString(20,s.getEducation());
			pstmt.setString(21,s.getDegree());
			pstmt.setString(22,s.getSchool());
			pstmt.setString(23,s.getMajor());
			pstmt.setDate(24,s.getGradDate());
			pstmt.setString(25,s.getType());
			pstmt.setInt(26,s.getDepId());
			pstmt.setInt(27,s.getPostId());
			
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

	public boolean update(Staff s) {
		// TODO Auto-generated method stub
		String sql="update employee set emp_seq=?,emp_name=?,emp_sex=?,emp_birth=?,emp_card=?,start_date=?,job_date=?," +
		"emp_forms=?,emp_origin=?,polit_status=?,nation=?,native_place=?,emp_tel=?,email=?,stature=?,blood_type=? ,marriage=?," +
		"birthplace=?,domicile_place=?,education=?,degree=?,school=?,major=?,grad_date=?,type=?,dep_id=?,post_id=? "+
		"where emp_id=?;";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,s.getEmpSeq());
			pstmt.setString(2,s.getEmpName());
			pstmt.setString(3,s.getEmpSex());
			pstmt.setDate(4,s.getEmpBirth());
			pstmt.setString(5,s.getEmpCard());
			pstmt.setDate(6,s.getStartDate());
			pstmt.setDate(7,s.getJobDate());
			pstmt.setString(8,s.getEmpForms());
			pstmt.setString(9, s.getEmpOrigin());
			pstmt.setString(10,s.getPolitStatus());
			pstmt.setString(11,s.getNation());
			pstmt.setString(12,s.getNativePlace());
			pstmt.setString(13,s.getEmpTel());
			pstmt.setString(14,s.getEmail());
			pstmt.setString(15,s.getStature());
			pstmt.setString(16,s.getBloodType());
			pstmt.setString(17,s.getMarriage());
			pstmt.setString(18,s.getBirthplace());
			pstmt.setString(19,s.getDomicilePlace());
			pstmt.setString(20,s.getEducation());
			pstmt.setString(21,s.getDegree());
			pstmt.setString(22,s.getSchool());
			pstmt.setString(23,s.getMajor());
			pstmt.setDate(24,s.getGradDate());
			pstmt.setString(25,s.getType());
			pstmt.setInt(26,s.getDepId());
			pstmt.setInt(27,s.getPostId());
			pstmt.setInt(28, s.getEmpId());
			
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
	public Staff findById(int sid) {
		// TODO Auto-generated method stub
		String sql="select * from employee where emp_id=?";
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sid);
			rs=pstmt.executeQuery();
			Staff s =new Staff();
			if(rs.next()){
				s.setEmpId(rs.getInt("emp_Id"));
				s.setEmpSeq(rs.getString("emp_seq"));
				s.setEmpName(rs.getString("emp_name"));
				s.setEmpSex(rs.getString("emp_sex"));
				s.setEmpBirth(rs.getDate("emp_birth"));
				s.setEmpCard(rs.getString("emp_card"));
				s.setStartDate(rs.getDate("start_date"));
				s.setJobDate(rs.getDate("job_date"));
				s.setEmpForms(rs.getString("emp_forms"));
				s.setEmpOrigin(rs.getString("emp_origin"));
				s.setPolitStatus(rs.getString("polit_status"));
				s.setNation(rs.getString("nation"));
				s.setNativePlace(rs.getString("native_place"));
				s.setEmpTel(rs.getString("emp_tel"));
				s.setEmail(rs.getString("email"));
				s.setStature(rs.getString("stature"));
				s.setBloodType(rs.getString("blood_type"));
				s.setMarriage(rs.getString("marriage"));
				s.setBirthplace(rs.getString("birthplace"));
				s.setDomicilePlace(rs.getString("domicile_place"));
				s.setEducation(rs.getString("education"));
				s.setDegree(rs.getString("degree"));
				s.setSchool(rs.getString("school"));
				s.setMajor(rs.getString("major"));
				s.setGradDate(rs.getDate("grad_date"));
				s.setType(rs.getString("type"));
				s.setDepId(rs.getInt("dep_id"));
				s.setPostId(rs.getInt("post_id"));
			}
			return s;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		finally
		{
			DBUtils.dbclose(null,pstmt, conn);
		}
	}
	
	//按员工编号查找员工
	public Staff findBySeq(String empSeq) {
		// TODO Auto-generated method stub
		String sql="select * from employee where emp_seq=?";
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, empSeq);
			rs=pstmt.executeQuery();
			Staff s =new Staff();
			if(rs.next()){
				s.setEmpId(rs.getInt("emp_Id"));
				s.setEmpSeq(rs.getString("emp_seq"));
				s.setEmpName(rs.getString("emp_name"));
				s.setEmpSex(rs.getString("emp_sex"));
				s.setEmpBirth(rs.getDate("emp_birth"));
				s.setEmpCard(rs.getString("emp_card"));
				s.setStartDate(rs.getDate("start_date"));
				s.setJobDate(rs.getDate("job_date"));
				s.setEmpForms(rs.getString("emp_forms"));
				s.setEmpOrigin(rs.getString("emp_origin"));
				s.setPolitStatus(rs.getString("polit_status"));
				s.setNation(rs.getString("nation"));
				s.setNativePlace(rs.getString("native_place"));
				s.setEmpTel(rs.getString("emp_tel"));
				s.setEmail(rs.getString("email"));
				s.setStature(rs.getString("stature"));
				s.setBloodType(rs.getString("blood_type"));
				s.setMarriage(rs.getString("marriage"));
				s.setBirthplace(rs.getString("birthplace"));
				s.setDomicilePlace(rs.getString("domicile_place"));
				s.setEducation(rs.getString("education"));
				s.setDegree(rs.getString("degree"));
				s.setSchool(rs.getString("school"));
				s.setMajor(rs.getString("major"));
				s.setGradDate(rs.getDate("grad_date"));
				s.setType(rs.getString("type"));
				s.setDepId(rs.getInt("dep_id"));
				s.setPostId(rs.getInt("post_id"));
				return s;
			}
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		finally
		{
			DBUtils.dbclose(null,pstmt, conn);
		}
	}
	public List<Staff> findByName(String str) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//全查员工
	public List<Staff> findAll() {
		String sql = "select * from staff";
		try {
			pstmt= conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<Staff> staffList = new ArrayList<Staff>();
			while(rs.next()){
				Staff s = new Staff();
				s.setEmpId(rs.getInt("emp_Id"));
				s.setEmpSeq(rs.getString("emp_seq"));
				s.setEmpName(rs.getString("emp_name"));
				s.setEmpSex(rs.getString("emp_sex"));
				s.setEmpBirth(rs.getDate("emp_birth"));
				s.setStartDate(rs.getDate("start_date"));
				s.setEmpCard(rs.getString("emp_card"));
				s.setJobDate(rs.getDate("job_date"));
				s.setEmpForms(rs.getString("emp_forms"));
				s.setEmpOrigin(rs.getString("emp_oringin"));
				s.setPolitStatus(rs.getString("polit_status"));
				s.setNation(rs.getString("nation"));
				s.setNativePlace(rs.getString("native_place"));
				s.setEmpTel(rs.getString("emp_tel"));
				s.setEmail(rs.getString("email"));
				s.setStature(rs.getString("stature"));
				s.setBloodType(rs.getString("blood_type"));
				s.setMarriage(rs.getString("marriage"));
				s.setBirthplace(rs.getString("birthplace"));
				s.setDomicilePlace(rs.getString("domicile_place"));
				s.setEducation(rs.getString("education"));
				s.setDegree(rs.getString("degree"));
				s.setSchool(rs.getString("school"));
				s.setMajor(rs.getString("major"));
				s.setGradDate(rs.getDate("grad_date"));
				s.setType(rs.getString("type"));
				s.setDepId(rs.getInt("dep_id"));
				s.setPostId(rs.getInt("post_id"));
				staffList.add(s);
			}
			return staffList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		finally{
			DBUtils.dbclose(null,pstmt, conn);
		}
	}
	
	
	//分页按照员工编号，员工姓名，部门名称，岗位名称查寻
	public List<Staff> find(Page page,String empSeq,String empName,String depName,String postName) {
		String sql = "select emp_seq,emp_name,emp_sex,degree,dep_seq,dep_name,post_seq,post_name "
			+"from employee e,department d,post p "
			+"where e.dep_id=d.dep_id and e.post_id = p.post_id and type!='离职' ";
		String sqlCount = "select count(*) from employee e,department d,post p "
			+"where e.dep_id=d.dep_id and e.post_id = p.post_id and type!='离职' ";
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
			List<Staff> staffList = new ArrayList<Staff>();
			while(rs.next()){
				Staff s = new Staff();
//				s.setEmpId(rs.getInt("emp_Id"));
				s.setEmpSeq(rs.getString("emp_seq"));
				s.setEmpName(rs.getString("emp_name"));
				s.setEmpSex(rs.getString("emp_sex"));
//				s.setEmpBirth(rs.getDate("emp_birth"));
//				s.setEmpCard(rs.getString("emp_card"));
//				s.setJobDate(rs.getDate("job_date"));
//				s.setEmpForms(rs.getString("emp_forms"));
//				s.setEmpOrigin(rs.getString("emp_origin"));
//				s.setPolitStatus(rs.getString("polit_status"));
//				s.setNation(rs.getString("nation"));
//				s.setNativePlace(rs.getString("native_place"));
//				s.setEmpTel(rs.getString("emp_tel"));
//				s.setEmail(rs.getString("email"));
//				s.setStature(rs.getString("stature"));
//				s.setBloodType(rs.getString("blood_type"));
//				s.setMarriage(rs.getString("marriage"));
//				s.setBirthplace(rs.getString("birthplace"));
//				s.setDomicilePlace(rs.getString("domicile_place"));
//				s.setEducation(rs.getString("education"));
				s.setDegree(rs.getString("degree"));
//				s.setSchool(rs.getString("school"));
//				s.setMajor(rs.getString("major"));
//				s.setGradDate(rs.getDate("grad_date"));
//				s.setType(rs.getString("type"));
//				s.setDepId(rs.getInt("dep_id"));
//				s.setPostId(rs.getInt("post_id"));
				s.setDepSeq(rs.getString("dep_Seq"));
				s.setDepName(rs.getString("dep_name"));
				s.setPostSeq(rs.getString("post_Seq"));
				s.setPostName(rs.getString("post_name"));
				staffList.add(s);
			}
			return staffList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		finally{
			DBUtils.dbclose(null,pstmt, conn);
		}
	}
	public List<Staff> findByLike(String str) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//查询数据库总记录条数
	public int findAllCount() {
		// TODO Auto-generated method stub
		String sql ="select count(*) from employee";
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
		finally
		{
			DBUtils.dbclose(null,pstmt, conn);
		}
	}
	
	
}
