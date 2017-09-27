package cn.tedu.dao;

import java.util.List;

import cn.tedu.entity.User;

public interface UserDao {
	void saveUser(User user);
	
	List<User> findAllUsers();

	int findMaxId(); 
	
	User findById(Integer id);
	
	void updateUser(User user);
}



