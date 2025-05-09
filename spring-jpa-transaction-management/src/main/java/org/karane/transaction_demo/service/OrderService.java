package org.karane.transaction_demo.service;

import org.karane.transaction_demo.entity.Order;
import org.karane.transaction_demo.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final TransactionTemplate transactionTemplate;

    public OrderService(OrderRepository orderRepository, PlatformTransactionManager txManager) {
        this.orderRepository = orderRepository;
        this.transactionTemplate = new TransactionTemplate(txManager);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void createOrderWithNewTx(String product) {
        orderRepository.save(new Order(product));
        throw new RuntimeException("Forces rollback of this REQUIRES_NEW only");
    }

    @Transactional(propagation = Propagation.NESTED)
    public void nestedTransaction(String product) {
        orderRepository.save(new Order(product));
        throw new RuntimeException("Nested rollback with savepoint (if supported)");
    }

    public void programmaticTransaction(String product) {
        transactionTemplate.executeWithoutResult(status -> {
            orderRepository.save(new Order(product));
            throw new RuntimeException("Rollback via programmatic transaction");
        });
    }

    public long countOrders() {
        return orderRepository.count();
    }
}
