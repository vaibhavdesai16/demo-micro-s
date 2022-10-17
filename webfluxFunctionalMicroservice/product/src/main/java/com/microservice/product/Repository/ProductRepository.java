package com.microservice.product.Repository;

import com.microservice.product.Document.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface ProductRepository extends ReactiveMongoRepository<Product,String> {

    Mono<Product> findByProductName(String name);


}
