package com.sl.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
//@ComponentScan({"com.sl.entity","com.sl.repositry", "com.sl.controller.rest"})
@SpringBootApplication
public class SpringBootRestApiServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestApiServerApplication.class, args);
	}

}
