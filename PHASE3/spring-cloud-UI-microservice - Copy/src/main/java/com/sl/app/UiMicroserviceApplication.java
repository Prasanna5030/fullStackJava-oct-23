package com.sl.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@SpringBootApplication
public class UiMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UiMicroserviceApplication.class, args);
	}
	
	@LoadBalanced
	@Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
