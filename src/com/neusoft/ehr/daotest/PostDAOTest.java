package com.neusoft.ehr.daotest;
/*吕文龙 2014-7-10
 * 测试类*/
import java.util.Iterator;
import java.util.List;

import com.neusoft.ehr.comm.Page;
import com.neusoft.ehr.comm.PageUtil;
import com.neusoft.ehr.dao.PostDAO;
import com.neusoft.ehr.entity.Post;
import com.neusoft.ehr.factory.PostDAOFactory;
/*
 * private int post_seq;//岗位id,自增
	private String post_id;//岗位编号
	private String post_name;//岗位名称
	private String post_type;//岗位类型(管理，技术，营销，市场)
	private String post_org;//岗位编制*/
public class PostDAOTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PostDAO pd = PostDAOFactory.getPostDAOInstance();
		//添加岗位功能成功！
//		for(int i = 0;i < 30;i++){
//		Post post = new Post();
//		String s = String.valueOf(i);
//		post.setPost_seq(s);
//		post.setPost_name("Java程序员"+s);
//		post.setPost_type("技术");
//		post.setPost_org("10");
//		pd.add(post);}
		//删除岗位成功！
		/*Post post = new Post();
		post.setPost_id(2);
		pd.del(post);*/
		//全查成功！
		/*List<Post> list = pd.findAllPost();
		Iterator it = list.iterator();
		while(it.hasNext()){
			Post post = (Post)it.next();
			System.out.print(post.getPost_seq()+",");
			System.out.print(post.getPost_id()+",");
			System.out.print(post.getPost_name()+",");
			System.out.print(post.getPost_type()+",");
			System.out.println(post.getPost_org());
		}*/
		//按ID查询成功
		/*Post p = new Post();
		p.setPost_seq(3);
		Post post = pd.findByPostId(p.getPost_seq());
		System.out.print(post.getPost_seq()+",");
		System.out.print(post.getPost_id()+",");
		System.out.print(post.getPost_name()+",");
		System.out.print(post.getPost_type()+",");
		System.out.println(post.getPost_org());*/
		//岗位更新
		/*Post post = new Post();
		post.setPost_seq(3);
		post.setPost_id("1002");
		post.setPost_name("架构师");
		post.setPost_type("技术");
		post.setPost_org("6");
		pd.update(post);*/
		/*Post p = new Post();
		p.setPost_seq("1001");
		List<Post> list = pd.find(p);
		Iterator it = list.iterator();
		while(it.hasNext()){
			Post post = (Post)it.next();
			System.out.print(post.getPost_seq()+",");
			System.out.print(post.getPost_id()+",");
			System.out.print(post.getPost_name()+",");
			System.out.print(post.getPost_type()+",");
			System.out.println(post.getPost_org());
		}*/
		Page page = PageUtil.createPage(5, 5, 1);
		List<Post> list= pd.find("", "", "", page);
		Iterator<Post> it = list.iterator();
		while(it.hasNext()){
			Post post = (Post)it.next();
			System.out.print(post.getPost_seq()+",");
			System.out.print(post.getPost_id()+",");
			System.out.print(post.getPost_name()+",");
			System.out.print(post.getPost_type()+",");
			System.out.println(post.getPost_org());
		}
	}

}
