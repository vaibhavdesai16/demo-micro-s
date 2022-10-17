package com.poc.r2dbc.demo.service;

import com.poc.r2dbc.demo.domain.Product;
import com.poc.r2dbc.demo.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.LocalDateTime;

@SpringBootTest
class ProductServiceImplTest {

    @Mock
    ProductRepository productRepository;

    @InjectMocks
    ProductServiceImpl productService;

    @BeforeEach
    void setUp() {
        Product product=new Product(1L,"p1","d1", LocalDateTime.of(2021,3,3,12,12));
        Mono<Product> mockProduct= Mono.just(product) ;
        Mockito.when(productRepository.findById(1L)).thenReturn(mockProduct);
        Mockito.when(productRepository.findById(2L)).thenReturn(Mono.empty());
        Mockito.when(productRepository.save(product)).thenReturn(mockProduct);

    }

    @Test
    void givenProductToSave_ShouldReturn_SavedProduct() {
        Product product=new Product(1L,"p1","d1", LocalDateTime.of(2021,3,3,12,12));
        StepVerifier.create(productService.saveProduct(product)).expectNext(product).verifyComplete();
    }

    @Test
    void givenPresentProductId_ShouldReturn_ValidProduct() {
        Product expectedResult=new Product(1L,"p1","d1", LocalDateTime.of(2021,3,3,12,12));
        StepVerifier.create(productService.getProductById(1L)).expectNext(expectedResult).verifyComplete();
    }

    @Test
    void givenNonPresentId_ShouldReturn_EmptyProductMono(){
        StepVerifier.create(productService.getProductById(2L)).expectNextCount(0).verifyComplete();
    }

}