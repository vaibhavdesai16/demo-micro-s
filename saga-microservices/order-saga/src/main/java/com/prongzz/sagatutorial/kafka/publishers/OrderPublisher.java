package com.prongzz.sagatutorial.kafka.publishers;

import com.prongzz.sagatutorial.entity.Order;
import reactor.core.publisher.Mono;
import reactor.kafka.sender.SenderResult;

public interface OrderPublisher {
    Mono<SenderResult> sendOrderSavedEvent(String s, Order order);
}
