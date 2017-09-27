package cn.tedu.vo;

import java.io.Serializable;

public class UserVO implements Serializable {
 
	private static final long serialVersionUID = -3138004225815811171L;
	
	private String name;
	private Integer age;
	private Double salary;
	private String hiredate;
	
	public UserVO() {
	}

	public UserVO(String name, Integer age, Double salary, String hiredate) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.hiredate = hiredate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getHiredate() {
		return hiredate;
	}

	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}

	@Override
	public String toString() {
		return "UserVO [name=" + name + ", age=" + age + ", salary=" + salary + ", hiredate=" + hiredate + "]";
	}
	
}
