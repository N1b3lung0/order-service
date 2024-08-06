package com.n1b3lung0.order.application.find;

import java.math.BigDecimal;
import java.util.UUID;

public record OrderResponse(
        UUID id,
        String orderNumber,
        String skuCode,
        BigDecimal price,
        Integer quantity
) {
}
