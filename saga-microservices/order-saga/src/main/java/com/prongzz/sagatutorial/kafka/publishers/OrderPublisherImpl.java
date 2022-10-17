package com.prongzz.sagatutorial.kafka.publishers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prongzz.sagatutorial.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.kafka.sender.SenderResult;

@Service
public class OrderPublisherImpl implements OrderPublisher {

  @Autowired ReactiveKafkaProducerTemplate reactiveKafkaProducerTemplate;

  @Override
  public Mono<SenderResult> sendOrderSavedEvent(String s, Order order) {
    try {
      ObjectMapper objectMapper = new ObjectMapper();
      System.out.println("sending message");
      Mono<SenderResult> res =
          reactiveKafkaProducerTemplate.send("order-topic", objectMapper.writeValueAsString(order));
      return res;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
}
