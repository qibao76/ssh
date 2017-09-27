package cn.tedu.action;

 

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.tedu.entity.Post;
import cn.tedu.service.PostService;
import ssh.day02.JsonResult;

@Controller
@Scope("prototype")
public class PostAction 
	extends AbstractAction{
	@Resource
	private PostService postService;
	public String list(){
		List<Post> list=postService.list();
		jsonResult=new JsonResult(list);
		return JSON;
	}
}


