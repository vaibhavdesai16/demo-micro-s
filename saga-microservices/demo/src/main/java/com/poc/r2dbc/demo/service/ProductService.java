package com.poc.r2dbc.demo.service;

import com.poc.r2dbc.demo.domain.Product;
import reactor.core.publisher.Mono;

public interface ProductService {
    Mono<Product> saveProduct(Product product);
    Mono<Product> getProductById(Long id);
}
