package com.microservices.order.Enpoints;




import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;


import com.microservices.order.Document.Order;
import com.microservices.order.Functionals.OrderHandler;
import com.microservices.order.Model.Product;
import com.microservices.order.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.*;
import org.springframework.web.reactive.function.client.*;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Mono;

import java.util.logging.Logger;

@Configuration
public class OrderEndpoints {

    @Autowired
    OrderRepository repository;

    @Autowired
    WebClient.Builder webClientBuilder;

    @Autowired
    private OrderHandler orderHandler;

    private static final Logger logger= Logger.getLogger(OrderEndpoints.class.getName());

    @Bean
    public RouterFunction<ServerResponse> orderRouterFunction(){

        return route().GET("/order/{id}",accept(MediaType.APPLICATION_JSON),orderHandler::getProduct)
                .after((request,response) ->logResponse(response))
                .build();
/*
                and(route(GET("/order"), (ServerRequest serverRequest) -> {

                    Mono<Product> product= webClientBuilder.build().get().uri("http://product-service/product/1").retrieve().bodyToMono(Product.class);
                    if(product != null)
                    Logger.getLogger(this.getClass().getName()).info(product.toString());
                    else Logger.getLogger(this.getClass().getName()).info("RETURNED NULL");
                    return null;
                }));*/


    }
    ServerResponse logResponse(ServerResponse response){
        logger.info(response.toString());
        return response;
    }



}
