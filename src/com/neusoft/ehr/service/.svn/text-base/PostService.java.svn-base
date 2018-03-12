package com.neusoft.ehr.service;

import java.util.ArrayList;
import java.util.List;

import com.neusoft.ehr.comm.Page;
import com.neusoft.ehr.dao.PostDAO;
import com.neusoft.ehr.entity.Post;
import com.neusoft.ehr.factory.PostDAOFactory;



public class PostService {
	//按名字查找
	public Post findByName(String str){
		PostDAO pd= PostDAOFactory.getPostDAOInstance();
		Post postList = pd.findByName(str);
		return postList;
	}
	//添加岗位
	public void add(Post post){
		PostDAO pd= PostDAOFactory.getPostDAOInstance();
		pd.add(post);
	}
	//删除岗位
	public void del(Post post){
		PostDAO pd= PostDAOFactory.getPostDAOInstance();
		pd.del(post);
	}
	//查询所有岗位
	public List<Post> findAllPost(){
		PostDAO pd= PostDAOFactory.getPostDAOInstance();
		List<Post> list = pd.findAllPost();
		return list;
	}
	//分页查询所有岗位
	public List<Post> findAllPost(Page page){
		PostDAO pd= PostDAOFactory.getPostDAOInstance();
		List<Post> list = pd.findAllPost(page);
		return list;
	}
	//分页的条件查找方法
	public List<Post> find(String seq,String name,String type,Page page){
		PostDAO pd= PostDAOFactory.getPostDAOInstance();
		List<Post> list = pd.find(seq, name, type, page);
		return list;
	}
	//查询所有条目
	public int findAllCount(){
		PostDAO pd= PostDAOFactory.getPostDAOInstance();
		int count = pd.findAllCount();
		return count;
	}
	//按ID查询
	public Post findByPostId(int id){
		PostDAO pd= PostDAOFactory.getPostDAOInstance();
		Post post = pd.findByPostId(id);
		return post;
	}
	//更新
	public void update(Post post){
		PostDAO pd= PostDAOFactory.getPostDAOInstance();
		pd.update(post);
	}
	//查询记录数
	public int count(String seq, String name, String type){
		PostDAO pd= PostDAOFactory.getPostDAOInstance();
		int count = pd.count(seq, name, type);
		return count;
	}
	//按岗位编号查询
	public Post findBySeq(String str){
		PostDAO pd= PostDAOFactory.getPostDAOInstance();
		Post post = pd.findBySeq(str);
		return post;
	}
}
