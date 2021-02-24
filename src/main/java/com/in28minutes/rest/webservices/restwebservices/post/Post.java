package com.in28minutes.rest.webservices.restwebservices.post;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.in28minutes.rest.webservices.restwebservices.user.User;

@Entity
public class Post {
	
	@Id
	@GeneratedValue
	private int pid;
	private String desc;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private User user;

	public Post()
	{
		
	}

	public Post(int pid, String desc, User user) {
		super();
		this.pid = pid;
		this.desc = desc;
		this.user = user;
	}


	public int getPid() {
		return pid;
	}


	public void setPid(int pid) {
		this.pid = pid;
	}


	public String getDesc() {
		return desc;
	}


	public void setDesc(String desc) {
		this.desc = desc;
	}


	


	public void setUser(User user) {
		this.user = user;
	}


	@Override
	public String toString() {
		return "Post [pid=" + pid + ", desc=" + desc + "]";
	}
	
	
	

}
