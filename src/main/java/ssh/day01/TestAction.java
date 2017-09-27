package ssh.day01;

public class TestAction {
	
	private String username;
	private Integer age;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public String execute(){
		//检查 浏览器 传递到控制器的数据
		System.out.println(username+","+age);
		return "success";
	}

}







