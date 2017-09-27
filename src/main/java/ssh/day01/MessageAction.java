package ssh.day01;
/**
 * 测试: 从控制器向浏览器传送数据 
 */
public class MessageAction {
	private String message;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String execute(){
		message = "Hello World!";
		return "success";
	}
}


