package com.n1b3lung0.order.application.create;

import com.n1b3lung0.order.client.InventoryClient;
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
    private final InventoryClient inventoryClient;

    public Order placeOrder(OrderCreateRequest request) {
        var isProductInStock = inventoryClient.isInStock(request.skuCode(), request.quantity());

        if (isProductInStock) {

            Order order = request.toOrder(
                    request.skuCode(),
                    request.price(),
                    request.quantity()
            );
            Order saved = repository.save(order);
            log.info("Order created successfully: {}", saved);
            return saved;
        } else {
            throw new RuntimeException("Product with skuCode " + request.skuCode() + " is not in stock");
        }
    }
}
