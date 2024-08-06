package com.n1b3lung0.order.controller;

import com.n1b3lung0.order.application.create.OrderCreateRequest;
import com.n1b3lung0.order.application.create.OrderCreator;
import com.n1b3lung0.order.application.find.OrderFinder;
import com.n1b3lung0.order.application.find.OrderResponse;
import com.n1b3lung0.order.domain.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final OrderCreator creator;
    private final OrderFinder finder;

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> placeOrder(@RequestBody OrderCreateRequest request) {
        Order saved = creator.placeOrder(request);
        URI location = UriComponentsBuilder.fromPath("/orders/{id}").buildAndExpand(saved.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<OrderResponse>> findAllOrders() {
        return ResponseEntity.ok(finder.findAll());
    }
}
