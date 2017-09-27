package ssh.day02;

import org.springframework.stereotype.Controller;

@Controller
public class TestAction {
	public String execute(){
		System.out.println("testAction");
		return "success";
	}
}
