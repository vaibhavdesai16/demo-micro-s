package com.prongzz.sagatutorial.handler;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

public interface OrderHandler {
    Mono<ServerResponse> saveOrder(ServerRequest request);
}
