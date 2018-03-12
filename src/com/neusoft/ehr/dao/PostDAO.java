package com.neusoft.ehr.dao;
/*������ 2014-7-10
 * �ӿ�*/
import java.util.List;

import com.neusoft.ehr.comm.Page;
import com.neusoft.ehr.entity.Post;

public interface PostDAO {
	//��Ӹ�λ
	public void add(Post post);
	//ɾ����λ
	public void del(Post post);
	//���¸�λ
	public void update(Post post);
	//�鿴ĳһ��λ
	public Post findByPostId(int id);
	//ȫ���λ
	public List<Post> findAllPost();
	//������ģ����ѯ��
	public List<Post> findByLike(String str);
	//����λ���Ʋ�ѯ
	public Post findByName(String str);
	//��ҳȫ��
	public List<Post> findAllPost(Page page);
	//��λ�ܼ�¼��
	public int findAllCount();
	//��ѯ
	public List<Post> find(String seq,String name,String type,Page page);
	//��ѯ��¼��
	public int count(String seq,String name,String type);
	//
	public Post findBySeq(String str);
}
