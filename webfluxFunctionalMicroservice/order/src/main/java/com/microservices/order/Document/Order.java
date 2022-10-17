package com.microservices.order.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Order")
@Data
@AllArgsConstructor
public class Order {


    @Id
    private String orderId;

    private String createdOn;


}
