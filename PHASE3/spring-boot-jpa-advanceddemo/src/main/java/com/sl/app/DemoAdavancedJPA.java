package com.sl.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
//@ComponentScan("com.sl.entity")
//@ComponentScan("com.sl.repositry")
//@ComponentScan("com.sl.controller")		
@SpringBootApplication
public class DemoAdavancedJPA {

	public static void main(String[] args) {
		SpringApplication.run(DemoAdavancedJPA.class, args);
	}

}
