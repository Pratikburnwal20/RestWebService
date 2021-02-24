package com.in28minutes.rest.webservices.restwebservices.hello;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Helloword {

	@GetMapping(path="/hello")
	public String helloword()
	{
		return "Hello World";
	}
	
	@GetMapping(path="/hellobean")
	public HelloBean hellowordbean()
	{
		return new HelloBean("Hello Bean");
	}
	
	@GetMapping(path="/hellobean/{name}")
	public HelloBean hellovar(@PathVariable String name)
	{
		return new HelloBean(String.format("Hello %s", name));
	}
}
