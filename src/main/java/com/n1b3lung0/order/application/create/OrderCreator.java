package com.n1b3lung0.order.application.create;

import com.n1b3lung0.order.domain.Order;
import com.n1b3lung0.order.domain.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderCreator {

    private final OrderRepository repository;

    public Order placeOrder(OrderCreateRequest request) {
        Order order = request.toOrder(
                request.skuCode(),
                request.price(),
                request.quantity()
        );
        Order saved = repository.save(order);
        log.info("Order created successfully: {}", saved);
        return saved;
    }
}
