package com.poc.r2dbc.demo.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    private Long productId;

    private String name;

    private String description;

    private LocalDateTime createdOn;
}
