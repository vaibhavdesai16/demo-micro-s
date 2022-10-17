package com.prongzz.sagatutorial.router;

import com.prongzz.sagatutorial.handler.OrderHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.contentType;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Component
public class OrderEndpoint {

  @Autowired OrderHandler orderHandler;

  @Bean
  RouterFunction orderEndpoints() {
    return route(
        POST("/order").and(contentType(MediaType.APPLICATION_JSON)), orderHandler::saveOrder);
  }
}
