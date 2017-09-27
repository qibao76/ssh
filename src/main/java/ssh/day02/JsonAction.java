package ssh.day02;

public class JsonAction {
	private String name;
	private int age;
	private String[] names;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String[] getNames() {
		return names;
	}
	public void setNames(String[] names) {
		this.names = names;
	}
	
	public String execute(){
		System.out.println("Json Result");
		name = "Tom";
		age = 10;
		names = new String[]{"Andy","Mac"};
		return "success";
	}
	
}





