package cn.tedu.action;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.tedu.entity.User;
import cn.tedu.service.AgeIsEmptyException;
import cn.tedu.service.HiredateException;
import cn.tedu.service.NameIsEmptyException;
import cn.tedu.service.UserService;
import cn.tedu.vo.UserVO;
import sun.management.resources.agent;
 

@Controller
@Scope("prototype")
public class UserAction {
	
	@Resource 
	private UserService userService;
	
	private List<User> users = 
			new ArrayList<User>();
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	public String list(){
		Thread t = Thread.currentThread();
		System.out.println(t); 
		users = userService.list();
		return "success";
	}
	
	
	private String name;
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public String save1() throws Exception{
		Thread.sleep(5000);
		Thread t = Thread.currentThread();
		System.out.println(t+":"+name);
		return "success";
	}
	
	private UserVO user;
	public UserVO getUser() {
		return user;
	}
	public void setUser(UserVO user) {
		this.user = user;
	}
	
	//定义错误号: 1 name, 2 age, 3 salary,
	// 4 hiredate
	private int type;
	private String message;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	public String save(){
		try{
			userService.save(user);
			return "success";
		}catch(NameIsEmptyException e){
			e.printStackTrace();
			type=1;
			message = e.getMessage();
			return "error";
		}catch(AgeIsEmptyException e){
			e.printStackTrace();
			type=2;
			message = e.getMessage();
			return "error";
		}catch (HiredateException e) {
			e.printStackTrace();
			type = 4;
			message = e.getMessage();
			return "error";
		}
	}
	
	private Integer id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String edit(){
		user = userService.get(id);
		return "success";
	}
	
	public String update(){
		try {
			userService.update(user, id);
			return "success";
		} catch (NameIsEmptyException e) {
			e.printStackTrace();
			type=1;
			message = e.getMessage();
			return "error";
		} catch (AgeIsEmptyException e) {
			e.printStackTrace();
			type=2;
			message = e.getMessage();
			return "error";
		} catch (HiredateException e) {
			e.printStackTrace();
			type=4;
			message = e.getMessage();
			return "error";
		}
	}
}







