package com.n1b3lung0.order.domain;

import java.util.List;

public interface OrderRepository {
    List<Order> findAll();
    Order save(Order order);
}
