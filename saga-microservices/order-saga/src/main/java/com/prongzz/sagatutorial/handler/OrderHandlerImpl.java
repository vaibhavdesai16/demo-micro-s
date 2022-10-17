package com.prongzz.sagatutorial.handler;

import com.prongzz.sagatutorial.entity.Order;
import com.prongzz.sagatutorial.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class OrderHandlerImpl implements  OrderHandler{

  @Autowired OrderService orderService;

  @Override
  public Mono<ServerResponse> saveOrder(ServerRequest request) {

    return ServerResponse.ok()
        .contentType(MediaType.APPLICATION_JSON)
        .body(request.bodyToMono(Order.class).flatMap(orderService::saveOrder), Order.class);
  }
}
