package com.poc.r2dbc.demo.endpoint;

import com.poc.r2dbc.demo.handler.ProductHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
@EnableWebFlux
@RequiredArgsConstructor
public class ProductEndpoint implements WebFluxConfigurer {

    private final ProductHandler productHandler;

    @Bean
    RouterFunction<ServerResponse> productRoutes() {
        return RouterFunctions
                .route(RequestPredicates.POST("/product"), productHandler::saveProduct)
                .andRoute(RequestPredicates.GET("/product/{id}"), productHandler::getProductById);
    }

}
