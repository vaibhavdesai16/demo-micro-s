package com.prongzz.sagatutorial.service;

import com.prongzz.sagatutorial.entity.Order;
import com.prongzz.sagatutorial.kafka.publishers.OrderPublisher;
import com.prongzz.sagatutorial.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

  @Autowired private OrderRepository orderRepository;

  @Autowired private OrderPublisher orderPublisher;

  @Override
  public Mono<Order> saveOrder(Order order) {

    return orderRepository
        .save(order)
        .doOnError(throwable -> System.out.println(throwable.getMessage()))
        .doOnSuccess(order1 -> orderPublisher.sendOrderSavedEvent("order-topic", order1).subscribe());

  }
}
