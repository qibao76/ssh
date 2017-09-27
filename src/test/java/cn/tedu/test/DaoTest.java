package cn.tedu.test;

import java.sql.Timestamp;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.dao.UserDao;
import cn.tedu.entity.User;

public class DaoTest {
	ClassPathXmlApplicationContext ctx;
	UserDao dao;
	
	@Before 
	public void init(){
		ctx = new ClassPathXmlApplicationContext(
		"conf/spring-pool.xml",
		"conf/spring-hibernate.xml");
		dao = ctx.getBean(
			"userDao",UserDao.class);
	}
	
	@After
	public void destory(){
		ctx.close();
	}

	@Test
	public void testSave(){
		long now = System.currentTimeMillis();
		User user=new User(8, "熊大", 
			8, 200.0, new Timestamp(now));
		dao.saveUser(user); 
	}
	
	@Test
	public void testFindAllUsers(){
		List<User> list=dao.findAllUsers();
		for (User user : list) {
			System.out.println(user); 
		}
	}
}











