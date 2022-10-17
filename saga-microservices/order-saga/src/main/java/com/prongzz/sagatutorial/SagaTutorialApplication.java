package com.prongzz.sagatutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoRepositories
public class SagaTutorialApplication {

    public static void main(String[] args) {
        SpringApplication.run(SagaTutorialApplication.class, args);
    }

}
