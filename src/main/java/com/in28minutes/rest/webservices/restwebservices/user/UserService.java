package com.in28minutes.rest.webservices.restwebservices.user;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in28minutes.rest.webservices.restwebservices.dao.IuserRepository;
import com.in28minutes.rest.webservices.restwebservices.expection.UserDefineException;
import com.in28minutes.rest.webservices.restwebservices.post.Post;

@Service
public class UserService {

	@Autowired
	IuserRepository userrepo;
	
	private static List<User> ulst = new ArrayList<User>();
	
	public List<User> findAll()
	{
		return userrepo.findAll();
	}
	
	public User saveUser(User user)
	{
		userrepo.save(user);
		return user;
	}
	public User findone(int uid)
	{
		Optional<User> us = userrepo.findById(uid);
		if(!us.isPresent())
			throw new UserDefineException("User Id "+uid+" Not Present");
		return us.get();
	}
	
	
	public User deleteUser(int uid)
	{
		
		Optional<User> us = userrepo.findById(uid);
		if(!us.isPresent())
			throw new UserDefineException("User Id "+uid+" Not Present");
		userrepo.deleteById(uid);
		return us.get();
	}
	
	public List<Post> getalluserpost(int uid)
	{
		Optional<User> optionaluser = userrepo.findById(uid);
		if(!optionaluser.isPresent())
			throw new UserDefineException("User Id "+uid+" Not Present");
		List<Post> op = optionaluser.get().getPosts();
	
		
		return op;
	}
}
