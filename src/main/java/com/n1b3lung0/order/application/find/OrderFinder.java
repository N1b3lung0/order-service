package com.n1b3lung0.order.application.find;

import com.n1b3lung0.order.domain.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderFinder {

    private final OrderRepository repository;

    public List<OrderResponse> findAll() {
        return repository.findAll()
                .stream().map(order -> new OrderResponse(
                        order.getId(),
                        order.getOrderNumber(),
                        order.getSkuCode(),
                        order.getPrice(),
                        order.getQuantity()
                ))
                .toList();
    }
}
