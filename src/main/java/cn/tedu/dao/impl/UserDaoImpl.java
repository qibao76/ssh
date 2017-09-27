package cn.tedu.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cn.tedu.dao.UserDao;
import cn.tedu.entity.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
	
	@Resource(name="hibernateTemplate")
	private HibernateTemplate template;
	
	@Transactional
	public void saveUser(User user) {
		template.save(user);
	}

	@Transactional
	public List<User> findAllUsers() {
		String hql = "from User";
		return (List<User>)template.find(hql);
	}
	
	public int findMaxId() {
		//sql: select max(t_id) as id 
		//     from t_user
		String hql="select max(id) as id "
				+ "from User"; 
		List<Number>list=(List<Number>)
				template.find(hql);
		int id = list.get(0).intValue();
		return id;
	}
	
	public User findById(Integer id) {
		//String s=null;
		//s.length();
		return template.get(User.class, id); 
	}
	
	public void updateUser(User user) {
		template.update(user); 
	}
}







