package com.microservices.order.Model;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {


    private String productId;

    private String productName;

    private String createdOn;



}
