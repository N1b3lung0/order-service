package com.n1b3lung0.order.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(force = true)
public final class Order {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private final UUID id;
    @Column(name = "order_number", nullable = false, unique = true)
    private final String orderNumber;
    @Column(name = "sku_code")
    private final String skuCode;
    @Column(name = "price")
    private final BigDecimal price;
    @Column(name = "quantity")
    private final Integer quantity;

    public static Order create(
            String skuCode,
            BigDecimal price,
            Integer quantity
    ) {
        return new Order(null, UUID.randomUUID().toString(), skuCode, price, quantity);
    }
}
