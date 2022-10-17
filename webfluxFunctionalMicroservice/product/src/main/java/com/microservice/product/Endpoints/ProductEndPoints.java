package com.microservice.product.Endpoints;


import com.microservice.product.Handlers.ProductHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.*;

import java.util.logging.Logger;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;


@Configuration
public class ProductEndPoints {

    @Autowired
    private ProductHandler productHandler;

    private static final Logger logger= Logger.getLogger(ProductEndPoints.class.getName());




    @Bean
    public RouterFunction<ServerResponse> productRouterFunction(){

        return route().GET("/product/{id}",accept(MediaType.APPLICATION_JSON),productHandler::getProduct)
                .after((request,response) ->logResponse(response))
                .build();

    }
    ServerResponse logResponse(ServerResponse response){
        logger.info(response.toString());
        return response;
    }

}
