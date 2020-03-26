package com.mycompany.rest.webservices.restfulwebservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class RestfulWebServicesApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ac = SpringApplication.run(RestfulWebServicesApplication.class, args);
		for (String beanString: ac.getBeanDefinitionNames() ){
			System.out.println(beanString);
		}
	}

}
