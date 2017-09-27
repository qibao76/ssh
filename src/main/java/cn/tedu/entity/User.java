package cn.tedu.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class User implements Serializable{
	private static final long serialVersionUID = -7677661768006650066L;
	
	private Integer id;
	private String name;
	private Integer age;
	private Double salary;
	private Timestamp hiredate;
	
	public User() {
	}

	public User(Integer id, String name, Integer age, Double salary, Timestamp hiredate) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.hiredate = hiredate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Timestamp getHiredate() {
		return hiredate;
	}

	public void setHiredate(Timestamp hiredate) {
		this.hiredate = hiredate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + ", salary=" + salary + ", hiredate=" + hiredate
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
