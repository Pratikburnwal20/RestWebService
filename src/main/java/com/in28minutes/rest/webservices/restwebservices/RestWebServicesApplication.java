package com.in28minutes.rest.webservices.restwebservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class RestWebServicesApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext=
		SpringApplication.run(RestWebServicesApplication.class, args);
		
		/*for(String nm:applicationContext.getBeanDefinitionNames())
		System.out.println(nm);*/
		
		 System.out.println("REST Web Services is UP for Git");
	}

}
