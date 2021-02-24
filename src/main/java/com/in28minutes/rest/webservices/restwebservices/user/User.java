package com.in28minutes.rest.webservices.restwebservices.user;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.in28minutes.rest.webservices.restwebservices.post.Post;
import com.sun.istack.NotNull;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class User {

	@Id
	@GeneratedValue
	private int uid;
	@Size(min=2,message="Name should have atleat 2 character")@NotEmpty@NotNull
	@ApiModelProperty(notes="Name should have atleat 2 character")
	private String uname;
	
	@Past
	@ApiModelProperty(notes="Should be pastdate")
	private Date dob;
	
	@OneToMany(mappedBy="user")
	private List<Post> posts;
	
	protected User()
	{
		
	}

	public User(int uid, String uname, Date dob, List<Post> posts) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.dob = dob;
		this.posts = posts;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public User(int uid, String uname, Date dob) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.dob = dob;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", dob=" + dob + "]";
	}
	
	
	
}
