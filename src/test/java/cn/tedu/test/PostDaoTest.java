package cn.tedu.test;

import java.sql.Timestamp;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.dao.PostDao;
import cn.tedu.dao.UserDao;
import cn.tedu.entity.Post;
import cn.tedu.entity.User;

public class PostDaoTest {
	ClassPathXmlApplicationContext ctx;
	PostDao dao;
	
	@Before 
	public void init(){
		ctx = new ClassPathXmlApplicationContext(
		"conf/spring-pool.xml",
		"conf/spring-hibernate.xml");
		dao = ctx.getBean(
			"postDao",PostDao.class);
	}
	
	@After
	public void destory(){
		ctx.close();
	}

	@Test
	public void testFindAllPost(){
		List<Post> list=dao.finaAllPost();
		for (Post post : list) {
			System.out.println(post); 
		}
	}
}











