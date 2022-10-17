package com.microservices.order.Repository;

import com.microservices.order.Document.Order;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;


public interface OrderRepository extends ReactiveCrudRepository<Order,String> {
}
