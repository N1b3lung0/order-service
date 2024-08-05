package com.n1b3lung0.order.application.create;

import com.n1b3lung0.order.domain.Order;

import java.math.BigDecimal;

public record OrderCreateRequest(
        Long id,
        String orderNumber,
        String skuCode,
        BigDecimal price,
        Integer quantity
)
{
    public Order toOrder(String orderNumber, String skuCode, BigDecimal price, Integer quantity) {
        return Order
    }
}
