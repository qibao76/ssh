package cn.tedu.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cn.tedu.dao.PostDao;
import cn.tedu.entity.Post;

@Repository("postDao")
@Transactional
public class PostDaoImpl implements PostDao {
	
	@Resource(name="hibernateTemplate")
	private HibernateTemplate template;
	
	public List<Post> finaAllPost() {
		String hql="from Post";
		List<Post> list=(List<Post>)template.find(hql);
		return list;
	}
}








