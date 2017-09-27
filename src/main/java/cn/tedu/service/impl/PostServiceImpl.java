package cn.tedu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tedu.dao.PostDao;
import cn.tedu.entity.Post;
import cn.tedu.service.PostService;

@Service("postService")
@Transactional
public class PostServiceImpl 
	implements PostService{

	@Resource
	private PostDao postDao;
	
	public List<Post> list() {
		return postDao.finaAllPost();
 	}
}



