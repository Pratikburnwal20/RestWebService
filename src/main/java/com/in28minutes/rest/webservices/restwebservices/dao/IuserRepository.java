package com.in28minutes.rest.webservices.restwebservices.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in28minutes.rest.webservices.restwebservices.user.User;


public interface IuserRepository extends JpaRepository<User, Integer> {

}
