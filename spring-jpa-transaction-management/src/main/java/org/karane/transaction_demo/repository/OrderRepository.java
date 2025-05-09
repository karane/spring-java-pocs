package org.karane.transaction_demo.repository;

import org.karane.transaction_demo.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {}
