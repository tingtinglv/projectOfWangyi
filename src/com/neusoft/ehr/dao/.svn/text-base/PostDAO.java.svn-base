package com.neusoft.ehr.dao;
/*吕文龙 2014-7-10
 * 接口*/
import java.util.List;

import com.neusoft.ehr.comm.Page;
import com.neusoft.ehr.entity.Post;

public interface PostDAO {
	//添加岗位
	public void add(Post post);
	//删除岗位
	public void del(Post post);
	//更新岗位
	public void update(Post post);
	//查看某一岗位
	public Post findByPostId(int id);
	//全查岗位
	public List<Post> findAllPost();
	//按条件模糊查询。
	public List<Post> findByLike(String str);
	//按岗位名称查询
	public Post findByName(String str);
	//分页全查
	public List<Post> findAllPost(Page page);
	//岗位总记录数
	public int findAllCount();
	//查询
	public List<Post> find(String seq,String name,String type,Page page);
	//查询记录数
	public int count(String seq,String name,String type);
	//
	public Post findBySeq(String str);
}
