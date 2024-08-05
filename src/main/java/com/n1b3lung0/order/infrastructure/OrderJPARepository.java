package com.n1b3lung0.order.infrastructure;

import com.n1b3lung0.order.domain.Order;
import com.n1b3lung0.order.domain.OrderRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderJPARepository extends OrderRepository, JpaRepository<Order, Long> {
}
