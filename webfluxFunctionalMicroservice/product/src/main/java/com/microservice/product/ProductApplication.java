package com.microservice.product;

import com.microservice.product.Document.Product;
import com.microservice.product.Handlers.ProductHandler;
import com.microservice.product.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@EnableDiscoveryClient
@EnableMongoAuditing
@EnableReactiveMongoRepositories
@EnableWebFlux
public class ProductApplication {

	@Autowired
	static private ProductRepository repo;

	public static void addElement(){
		Product p=new Product("1","name1","now");
		repo.save(p);

	}

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);

		//addElement();



	}

}

