package com.in28minutes.rest.webservices.restwebservices.post;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in28minutes.rest.webservices.restwebservices.dao.IuserRepository;
import com.in28minutes.rest.webservices.restwebservices.expection.UserDefineException;
import com.in28minutes.rest.webservices.restwebservices.user.User;
import com.in28minutes.rest.webservices.restwebservices.user.UserService;

@Service
public class PostService {
	
	@Autowired
	private IposTreposetory pres;
	
	private UserService userservice;
	
	@Autowired
	IuserRepository userrepo;
	
	public List<Post> getallPostbyUserId(int uid)
	{
		Optional<User> us = userrepo.findById(uid);
		if(!us.isPresent())
			throw new UserDefineException("User Id "+uid+" Not Present");
		else
		return 	us.get().getPosts();
		
	}
	
	

}
