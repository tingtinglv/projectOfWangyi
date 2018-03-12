package com.neusoft.ehr.daoimpl;
/*吕文龙 2014-7-10
 * 接口实现类*/
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neusoft.ehr.comm.DBUtilTest;
import com.neusoft.ehr.comm.DBUtils;
import com.neusoft.ehr.comm.Page;
import com.neusoft.ehr.dao.PostDAO;
import com.neusoft.ehr.entity.Post;
public class PostDAOImp implements PostDAO{
	Connection conn=DBUtils.getConn();
	PreparedStatement pstmt;
	ResultSet rs;

	public void add(Post post) {
		// TODO Auto-generated method stub
		try {
			String sql = "insert into post(post_seq,post_name,post_type,post_org) values (?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,post.getPost_seq()); 
			pstmt.setString(2,post.getPost_name());
			pstmt.setString(3,post.getPost_type()); 
			pstmt.setString(4,post.getPost_org());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void del(Post post) {
		// TODO Auto-generated method stub
		try {
			String sql = "delete from post where post_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, post.getPost_id()); 
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Post> findAllPost() {
		// TODO Auto-generated method stub
		List<Post> list =new ArrayList<Post>();
		try {
			String sql = "select * from post";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Post post = new Post();
				post.setPost_id(rs.getInt(1));
				post.setPost_seq(rs.getString(2));
				post.setPost_name(rs.getString(3));
				post.setPost_type(rs.getString(4));
				post.setPost_org(rs.getString(5));
				list.add(post);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	//用分页实现全查
	public List<Post> findAllPost(Page page){
		List<Post> list = new ArrayList<Post>();
		String sql = "select * from post limit ?,?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, page.getBeginIndex());
			pstmt.setInt(2, page.getEveryPage());
			rs=pstmt.executeQuery();
			while(rs.next()){
				Post post = new Post();
				post.setPost_id(rs.getInt(1));
				post.setPost_seq(rs.getString(2));
				post.setPost_name(rs.getString(3));
				post.setPost_type(rs.getString(4));
				post.setPost_org(rs.getString(5));
				list.add(post);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public List<Post> findByLike(String str) {
		// TODO Auto-generated method stub
		List<Post> list =new ArrayList<Post>();
		try {
			String sql = "select * from post where post_name='%?%'";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, str);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Post post = new Post();
				post.setPost_id(rs.getInt(1));
				post.setPost_seq(rs.getString(2));
				post.setPost_name(rs.getString(3));
				post.setPost_type(rs.getString(4));
				post.setPost_org(rs.getString(5));
				list.add(post);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public Post findByName(String str) {
		// TODO Auto-generated method stub
		List<Post> list =new ArrayList<Post>();
		Post post = new Post();
		try {
			String sql = "select * from post where post_name=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, str);
			rs = pstmt.executeQuery();
			while(rs.next()){
				post.setPost_id(rs.getInt(1));
				post.setPost_seq(rs.getString(2));
				post.setPost_name(rs.getString(3));
				post.setPost_type(rs.getString(4));
				post.setPost_org(rs.getString(5));
				list.add(post);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return post;
	}
	public List<Post> find(String seq,String name,String type,Page page){
		List<Post> list =new ArrayList<Post>();
		try {
			String sql = "select * from post where ";
			if(seq!=null&&seq!=""){
				sql=sql+"post_seq='"+seq+"' and ";
			}
			if(name!=null&&name!=""){
				sql=sql+"post_name like '%"+name+"%' and ";
			}
			if(type!=null&&type!=""){
				sql=sql+"post_type ='"+type+"' and ";
			}
			sql=sql+"1>0 limit ?,?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,page.getBeginIndex());
			pstmt.setInt(2,page.getEveryPage());
			rs = pstmt.executeQuery();
			while(rs.next()){
				Post p = new Post();
				p.setPost_id(rs.getInt(1));
				p.setPost_seq(rs.getString(2));
				p.setPost_name(rs.getString(3));
				p.setPost_type(rs.getString(4));
				p.setPost_org(rs.getString(5));
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
	public Post findByPostId(int id) {
		// TODO Auto-generated method stub
		List<Post> list =new ArrayList<Post>();
		Post post = new Post();
		try {
			String sql = "select * from post where post_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id); 
			rs = pstmt.executeQuery();
			while(rs.next()){
				
				post.setPost_id(rs.getInt(1));
				post.setPost_seq(rs.getString(2));
				post.setPost_name(rs.getString(3));
				post.setPost_type(rs.getString(4));
				post.setPost_org(rs.getString(5));
				list.add(post);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return post;
	}

	public void update(Post post) {
		// TODO Auto-generated method stub
		try {
			String sql = "update post set post_seq=?,post_name=?,post_type=?,post_org=? where post_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,post.getPost_seq()); 
			pstmt.setString(2,post.getPost_name());
			pstmt.setString(3,post.getPost_type()); 
			pstmt.setString(4,post.getPost_org());
			pstmt.setInt(5,post.getPost_id());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int findAllCount() {
		int count = 0;
		String sql = "select count(*) from post";
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

	public int count(String seq, String name, String type) {
		// TODO Auto-generated method stub
		int count=0;
		try {
			String sql = "select count(*) from post where ";
			if(seq!=null&&seq!=""){
				sql=sql+"post_seq='"+seq+"' and ";
			}
			if(name!=null&&name!=""){
				sql=sql+"post_name like '%"+name+"%' and ";
			}
			if(type!=null&&type!=""){
				sql=sql+"post_type ='"+type+"' and ";
			}
			sql=sql+" 1>0";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()){
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	public Post findBySeq(String str) {
		// TODO Auto-generated method stub
		Post post = new Post();
		try {
			String sql = "select * from post where post_seq=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, str); 
			rs = pstmt.executeQuery();
			if(rs.next()){
				
				post.setPost_id(rs.getInt(1));
				post.setPost_seq(rs.getString(2));
				post.setPost_name(rs.getString(3));
				post.setPost_type(rs.getString(4));
				post.setPost_org(rs.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return post;
	}
	
	
}
