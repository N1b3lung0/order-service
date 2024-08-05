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

@Entity
@Table(name = "orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(force = true)
public final class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private final Long id;
    private final String orderNumber;
    private final String skuCode;
    private final BigDecimal price;
    private final Integer quantity;

    public static Order create(
            String orderNumber,
            String skuCode,
            BigDecimal price,
            Integer quantity
    ) {
        return new Order(null, orderNumber, skuCode, price, quantity);
    }
}
