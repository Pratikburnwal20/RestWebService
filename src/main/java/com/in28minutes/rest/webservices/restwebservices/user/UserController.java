package com.in28minutes.rest.webservices.restwebservices.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.in28minutes.rest.webservices.restwebservices.dto.ResponseClass;
import com.in28minutes.rest.webservices.restwebservices.dto.SuccessResponse;
import com.in28minutes.rest.webservices.restwebservices.expection.BadRequest;
import com.in28minutes.rest.webservices.restwebservices.expection.UserDefineException;

@RestController
public class UserController {
	
	@Autowired
	private UserService uservice;
	
	@GetMapping(path="/users")
	public List<User> findAll()
	{
		return uservice.findAll();
	}
	
	@GetMapping(path="/users/{uid}")
	public User findone(@PathVariable int uid)
	{
		return uservice.findone(uid);
	}
	
	@PostMapping(path="/users")
	public ResponseEntity<ResponseClass> saveuser(@Valid @RequestBody User user)
	{
		if(user.getUname()==null||user.getUname()==""||user.getDob()==null||user.getDob().toString()=="")
		{
			throw new BadRequest("User Name can not be blank or null");
		}
		User savedUser=uservice.saveUser(user);
		
		URI location=ServletUriComponentsBuilder
				      .fromCurrentRequest()
				      .path("/{uId}")
				      .buildAndExpand(savedUser.getUid())
				      .toUri();
		
		 //return new ResponseEntity<User>(savedUser,HttpStatus.CREATED);
	   SuccessResponse<User> body =
			   					new SuccessResponse<User>(201,
			   												savedUser,
			   													"User Created",location.toString());
	   return new ResponseEntity<ResponseClass>(body,HttpStatus.CREATED);
		
	   
	  // return ResponseEntity.created(location).build();

		
	}

	@DeleteMapping("/users/{uid}")
	public User deleteUser(@PathVariable int uid)
	{
		User us = uservice.deleteUser(uid);
		if(us==null)
			throw new UserDefineException("User Id "+uid +" Not Found");
		return us;
	}
	
	
}
