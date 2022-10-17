package com.microservices.order;

import com.microservices.order.Document.Order;
import com.microservices.order.Enpoints.OrderEndpoints;
import com.microservices.order.Model.Product;
import com.microservices.order.Repository.OrderRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.client.*;
import reactor.core.publisher.Mono;

import java.util.logging.Logger;

import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderApplicationTests {


	@Autowired
	OrderEndpoints endpoints;

	@Autowired
	OrderRepository repository;

    @Autowired
    WebClient.Builder webClientBuilder;

    private final Logger logger=Logger.getLogger(OrderApplicationTests.class.getName());

	@Test
	public void contextLoads() {
	}


	public void givenOrderId_whenGetOrderById_thenCorrectOrder(){


		//WebTestClient client=WebTestClient.bindToRouterFunction(endpoints.orderRouterFunction()).build();




		//Product product=new Product("1","now");
		//BDDMockito.given(repository.findById("1")).willReturn(Mono.just(order));

			Mono<Product> productMono=webClientBuilder.build().get().uri("http://product-service/product/1").retrieve().bodyToMono(Product.class);

		logger.info(productMono.toString() +"test is running");
		System.out.print(productMono.toString());
		//given(webClientBuilder.build().get().uri("http://product-service/product/1").retrieve().bodyToMono(Product.class))
          //      .getMock();




        /*
                .uri("/order/1").exchange()
				.expectStatus()
				.isOk()
				.expectBody(Order.class)
				.isEqualTo(order);*/

	}

}

