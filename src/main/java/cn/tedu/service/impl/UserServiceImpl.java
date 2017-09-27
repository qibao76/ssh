package cn.tedu.service.impl;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tedu.dao.UserDao;
import cn.tedu.entity.User;
import cn.tedu.service.AgeIsEmptyException;
import cn.tedu.service.HiredateException;
import cn.tedu.service.NameIsEmptyException;
import cn.tedu.service.UserNotFoundException;
import cn.tedu.service.UserService;
import cn.tedu.vo.UserVO;

@Service("userService")
@Transactional
public class UserServiceImpl 
	implements UserService{

	@Resource
	private UserDao userDao;
	
	public List<User> list() {
		return userDao.findAllUsers();
	}
	
	@Transactional
	public void save(String name, 
			Integer age, Double salary, 
			String hiredate) {
		
		if(name==null||name.trim().isEmpty()){
			throw new NameIsEmptyException("不能空");
		}
		
		if(age==null){
			throw new AgeIsEmptyException("必须有年龄");
		}
		Timestamp t=null;
		try{
			Date d = DateUtils.parseDate(
				hiredate, "yyyy-MM-dd");
			t = new Timestamp(d.getTime());
		}catch(ParseException e){
			e.printStackTrace();
			throw new HiredateException("格式错误",e);
		}
		//int max = userDao.findMaxId();
		//int id = max+1;
		User user = new User(null, name, age,
			salary, t);
		userDao.saveUser(user);
	}
	
	public void save(UserVO user) {
		save(user.getName(), user.getAge(), 
		user.getSalary(), user.getHiredate());
	}
	
	public UserVO get(Integer id) {
		if(id==null){
			throw new UserNotFoundException("ID不能空");
		}
		User user = userDao.findById(id);
		if(user==null){
			throw new UserNotFoundException("没有找到");
		}
		UserVO vo = new UserVO();
		BeanUtils.copyProperties(user, vo);
		vo.setHiredate(
			DateFormatUtils.format(
			user.getHiredate(), "yyyy-MM-dd"));
		return vo;
	}
	
	public void update(UserVO user, Integer id) {
		if(user.getName()==null||
			user.getName().trim().isEmpty()){
			throw new NameIsEmptyException("名字不能空");
		}
		if(user.getAge()==null){
			throw new AgeIsEmptyException("姓名不能空");
		}
		Timestamp t = null;
		try{
			Date d = DateUtils.parseDate(
					user.getHiredate(),
					"yyyy-MM-dd");
			t=new Timestamp(d.getTime());
		}catch(ParseException e){
			e.printStackTrace();
			throw new HiredateException("格式错误!",e);
		}
		User u = new User();
		BeanUtils.copyProperties(user, u);
		u.setId(id);
		u.setHiredate(t);
		userDao.updateUser(u);
	}
}




