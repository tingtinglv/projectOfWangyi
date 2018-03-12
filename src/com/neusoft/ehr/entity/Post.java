package com.neusoft.ehr.entity;
/*吕文龙 2014-7-10
 * 岗位实体类*/
//数据的创建语句
/*create table post(post_seq int primary key auto_increment,post_id 
 * varchar(5) unique not null,post_name varchar(20) not null,
 * post_type varchar(20) not null,post_org varchar(15));*/
public class Post {
	private int post_id;//岗位id,自增
	private String post_seq;//岗位编号
	private String post_name;//岗位名称
	private String post_type;//岗位类型(管理，技术，营销，市场)
	private String post_org;//岗位编制
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int postId) {
		post_id = postId;
	}
	public String getPost_seq() {
		return post_seq;
	}
	public void setPost_seq(String postSeq) {
		post_seq = postSeq;
	}
	public String getPost_name() {
		return post_name;
	}
	public void setPost_name(String postName) {
		post_name = postName;
	}
	public String getPost_type() {
		return post_type;
	}
	public void setPost_type(String postType) {
		post_type = postType;
	}
	public String getPost_org() {
		return post_org;
	}
	public void setPost_org(String postOrg) {
		post_org = postOrg;
	}
	
}
