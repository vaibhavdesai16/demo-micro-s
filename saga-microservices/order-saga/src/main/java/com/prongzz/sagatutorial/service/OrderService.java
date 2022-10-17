package com.prongzz.sagatutorial.service;

import com.prongzz.sagatutorial.entity.Order;
import reactor.core.publisher.Mono;

public interface OrderService {
  Mono<Order> saveOrder(Order order);
}
