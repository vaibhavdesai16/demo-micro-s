package com.microservice.product.Handlers;

import com.microservice.product.Document.Product;
import com.microservice.product.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Mono;
import static org.springframework.web.reactive.function.BodyInserters.fromObject;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

import java.util.logging.Logger;

@Component
public class ProductHandler {

    @Autowired
    private ProductRepository repository;

    private static final Logger logger= Logger.getLogger(ProductHandler.class.getName());

public Mono<ServerResponse> getProduct(ServerRequest request){

    logger.info("Get Product for ID "+request.pathVariable("id"));

    Mono<Product> p=repository.findByProductName("name");



    logger.info(p.toString());

    Mono<ServerResponse> m=p.flatMap(person ->
            ok().contentType(MediaType.APPLICATION_JSON).body(fromObject(person)))
            .switchIfEmpty(ServerResponse.notFound().build());
    return m;
}


}
