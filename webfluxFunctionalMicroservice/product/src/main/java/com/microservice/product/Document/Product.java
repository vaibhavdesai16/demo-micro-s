package com.microservice.product.Document;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Product")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class Product {

    @Id
    private String productId;

    private String productName;

    private String createdOn;



}
