package cn.tedu.test;

import java.sql.Timestamp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.entity.PUser;
import cn.tedu.entity.Post;
import cn.tedu.entity.User;

public class ORMTestCase {
	ClassPathXmlApplicationContext ctx;
	SessionFactory factory;
	
	@Before
	public void init(){
		ctx=new ClassPathXmlApplicationContext(
			"conf/spring-pool.xml",
			"conf/spring-hibernate.xml");
		factory = ctx.getBean("sessionFactory",
				SessionFactory.class);
	}
	@After
	public void destory(){
		factory.close();
		ctx.close();
	}

	@Test
	public void testSession(){
		Session session=factory.openSession();
		User user = (User)session.get(
			User.class, 2);
		System.out.println(user);
		session.close();
	}
	
	@Test
	public void testAddPUser(){
		long now = System.currentTimeMillis();
		PUser user = new PUser(null, 
			"范传奇", "123", "范萌萌", 
			new Timestamp(now));
		Session session = factory.openSession();
		Transaction tx=session.beginTransaction();
		Object id=session.save(user);//自动生成ID
		System.out.println(id);
		System.out.println(user); 
		tx.commit();
		session.close();
	}
	
	@Test
	public void testGetPost(){
		Session session = factory.openSession();
		Post post = (Post)session.get(Post.class, 1);
		System.out.println(post); 
		session.close();
	}
	
	@Test
	public void testLazy(){
		Session session = factory.openSession();
		//第一次查询Post 只查询了Post的基本属性
		//不查询其关联的 User和Comments属性
		Post post = (Post)session.get(Post.class, 1);
//		System.out.println(post);
		System.out.println(post.getContent()); 
		//当用户访问post的user属性时候, 
		//Hibernate才开始执行SQL查询出User属性
		//这种现象称为懒惰初始化现象(按需加载)
		//其优点:可以减少SQL数量, 减少内存占用
		// 缺点: session关闭(数据库连接关闭)
		//       属性就不能再懒惰加载初始化了
		session.close();
		System.out.println(post.getUser()+"gjsdkf"); 

	}
	
}











