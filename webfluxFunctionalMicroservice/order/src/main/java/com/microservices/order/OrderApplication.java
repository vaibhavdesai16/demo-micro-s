package com.microservices.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.client.*;

@SpringBootApplication
@EnableWebFlux
@EnableMongoRepositories
@EnableDiscoveryClient
public class OrderApplication {


	public static void main(String[] args) {

	    SpringApplication.run(OrderApplication.class, args);


	}

	@Bean
    @LoadBalanced
	WebClient.Builder loadBalancedWebClientBuilder(){

	    return WebClient.builder();

    }

}

