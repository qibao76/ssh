package cn.tedu.service;

import java.util.List;

import cn.tedu.entity.User;
import cn.tedu.vo.UserVO;

public interface UserService {
	List<User> list();
	
	void save(String name, Integer age,
		Double salary, String hiredate);

	void save(UserVO user); 
	
	UserVO get(Integer id);
	
	void update(UserVO user, Integer id);
}



