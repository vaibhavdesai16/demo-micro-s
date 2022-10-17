package com.cart.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.config.EnableWebFlux;
import reactor.core.publisher.Mono;

@SpringBootApplication
@EnableHystrix
@EnableDiscoveryClient
@EnableWebFlux
public class GatewayApplication {

	@Bean
	KeyResolver userKeyResolver() {
		return exchange -> Mono.just("fero");
	}

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);

	}

}

