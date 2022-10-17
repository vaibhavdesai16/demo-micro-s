package com.microservices.order.Functionals;

import com.microservices.order.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.*;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Mono;

import java.util.logging.Logger;

import static org.springframework.web.reactive.function.BodyInserters.*;
import static org.springframework.web.reactive.function.server.ServerResponse.*;

@Component
public class OrderHandler {

    private static final Logger logger= Logger.getLogger(OrderHandler.class.getName());

    @Autowired
    WebClient.Builder webClientBuilder;

    public Mono<ServerResponse> getProduct(ServerRequest request){

        logger.info("Get Product for ID "+request.pathVariable("id"));
        return webClientBuilder.build().get().uri("http://product-service/product/1").retrieve().bodyToMono(Product.class).
        flatMap(person ->
                ok().contentType(MediaType.APPLICATION_JSON).body(fromObject(person)))
                .switchIfEmpty(ServerResponse.notFound().build());
    }


}
