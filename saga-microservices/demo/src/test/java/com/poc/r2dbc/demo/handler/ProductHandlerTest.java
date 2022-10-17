package com.poc.r2dbc.demo.handler;

import com.poc.r2dbc.demo.domain.Product;
import com.poc.r2dbc.demo.repository.ProductRepository;
import com.poc.r2dbc.demo.service.ProductService;
import com.poc.r2dbc.demo.service.ProductServiceImpl;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@AutoConfigureWebTestClient
class ProductHandlerTest {

  @Autowired
  WebTestClient webTestClient;

  @MockBean
  ProductRepository productRepository;


  @BeforeEach
  void setUp() {
    Product product=new Product(1L,"p1","d1", LocalDateTime.of(2021,3,3,12,12));
    Mono<Product> mockProduct= Mono.just(product) ;
    Mockito.when(productRepository.findById(1L)).thenReturn(mockProduct);
    Mockito.when(productRepository.save(product)).thenReturn(mockProduct);

  }

  @Test
  void saveProduct() {
    Product product=new Product(1L,"p1","d1", LocalDateTime.of(2021,3,3,12,12));

    webTestClient.post()
            .uri("/product")
            .body(Mono.just(product),Product.class)
            .exchange()
            .expectStatus().isOk()
            .expectBody()
            .jsonPath("$.name").isEqualTo("p1");

  }

  @Test
  void getProductById() {

    webTestClient.get()
            .uri("/product/1")
            .exchange()
            .expectStatus().isOk()
            .expectBody(Product.class)
            .value(product -> product.getProductId(), CoreMatchers.equalTo(1L));

  }
}