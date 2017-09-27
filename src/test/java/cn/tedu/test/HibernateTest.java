package cn.tedu.test;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cn.tedu.entity.User;

public class HibernateTest {
	
	SessionFactory factory;
	Session session;
	
	@Before //初始化 Hibernate
	public void init(){
		Configuration cfg=new Configuration();
		//加载主配置文件
		cfg.configure("hibernate.cfg.xml");
		factory = cfg.buildSessionFactory();
		session = factory.openSession();
	}
	
	@After//Hiberbate 使用以后释放资源
	public void destory(){
		session.close();
		factory.close();
	}
	
	@Test
	public void testSaveUser(){
		Transaction tx = session.beginTransaction();
		long now=System.currentTimeMillis();
		//创建User对象,调用save()保存到数据库中
		User user=new User(
			1,"Tom",5,100.0,new Timestamp(now));
		session.save(user);
		tx.commit();
	}

	@Test
	public void testGet(){
		//测试 查询方法 get
		int id=1;
		User user=
			(User)session.get(User.class, id);
		System.out.println(user);
	}
	
	@Test
	public void testUpdate(){
		Transaction tx=session.beginTransaction();
		User user=(User)session.get(
				User.class, 1);
		user.setName("范传奇"); 
		session.update(user);
		user=(User)session.get(
				User.class, 1);
		System.out.println(user);
		tx.commit();
	}
	
	@Test
	public void testDelete(){
		Transaction tx=session.beginTransaction();
		User user=(User)session.get(
				User.class, 1);
		System.out.println(user);
		session.delete(user); 
		System.out.println(user); 
		tx.commit();
	}
	
	@Test
	public void testAddDat(){
		long now=System.currentTimeMillis();
		Transaction tx = session.beginTransaction();
		User user=new User(
			1,"Tom",20,200.0,new Timestamp(now));
		session.save(user);
		user=new User(
			2,"Jerry",5,100.0,new Timestamp(now));
		session.save(user);
		user=new User(
			3,"Mac",20,200.0,new Timestamp(now));
		session.save(user);
		tx.commit();
	}
	
	@Test
	public void testFindAll(){
		//sql: select * from t_user
		//HQL: from User
		//1. 如果是查询全部属性数据, 
		//   则可以省略select子句
		//2. 表名替换为其对应的实体类名
		//3. 列名替换为其对应的实体属性名
		
		String hql="from User";
		//利用Query接口执行HQL
		Query query=
			session.createQuery(hql);
		List<User> list=query.list();
		for (User user : list) {
			System.out.println(user); 
		}
	}
	
	@Test
	public void testFindByAge(){
		//sql: select * from t_user 
		//     where t_age=?
		//hql: from User where age=?
		String hql="from User where age=?";
		Query query=session.createQuery(hql);
		query.setInteger(0, 20);
		List<User> list=query.list();
		for (User user : list) {
			System.out.println(user); 
		}
	}
	
	@Test
	public void testFindMapList(){
		//sql: select t_id, t_name 
		//     from t_user where t_age=?
		//     order by t_name
		//hql: select new map(id as id, 
		//            name as name) 
		//     from User where age=?
		//     order by name
		String hql="select new map(id as id, "
				+ "name as name) "
				+ "from User where age=:age "
				+ "order by name";
		Query query=session.createQuery(hql);
		//按照名称替换参数
		query.setInteger("age", 20);
		List<Map<String, Object>> list=
				query.list();
		for (Map<String, Object> map : list) {
			System.out.println(map);
		}
	}
	
	@Test
	public void testSave(){
		long now=System.currentTimeMillis();
		Transaction tx=session.beginTransaction();
		User user=new User(5, "范老师",
			20, 3000.0, new Timestamp(now));
		//临时状态
		session.save(user);
		//持久状态
		user.setSalary(100.0);
		user.setAge(50);
		//清理session,执行全部SQL
		session.flush();
		tx.commit();
		//session.evict(object);
	}
	
	@Test
	public void testEvict(){
		long now=System.currentTimeMillis();
		Transaction tx=session.beginTransaction();
		User user=new User(
				6, "李老师", 20, 200.0,
				new Timestamp(now));
		session.save(user);
		//持久状态
		session.flush();//执行可能的sql
		session.evict(user);//将user从session中清除
		//游离状态
		user.setAge(50);
		session.flush();//执行可能的sql
		tx.commit();
	}
	
	@Test
	public void testLiftCircle(){
		Transaction tx=session.beginTransaction();
		User user=
			(User)session.load(User.class,1);
		System.out.println(user);
		//持久状态
		user.setAge(50);
		session.flush();
		session.clear();
		//游离状态
		user.setAge(30);
		session.flush();
		session.update(user);
		//持久状态
		session.flush();
		session.delete(user);
		//临时状态
		System.out.println(user);
		tx.commit();
	}
}
























