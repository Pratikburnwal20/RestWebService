package com.in28minutes.rest.webservices.restwebservices.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {
	
	@Autowired
	private PostService pservice;
	
	@GetMapping("/users/{uid}/posts")
	public List<Post> getallpost(@PathVariable int uid)
	{
		return pservice.getallPostbyUserId(uid);
	}

}
