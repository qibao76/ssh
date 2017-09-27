package ssh.day01;

/**
 * 控制器类 
 */
public class DemoAction {
	/**
	 * 控制器 中的流程控制方法
	 * 在用户请求URL时候执行 
	 */
	public String execute(){
		System.out.println("Hello World!");
		//返回的值  success 代表jsp的视图名称
		return "success";
	}
}




