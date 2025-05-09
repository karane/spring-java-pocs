package org.karane.transaction_demo.controller;

import org.karane.transaction_demo.service.UserService;
import org.karane.transaction_demo.service.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demo")
public class Controller {
    private final UserService userService;
    private final OrderService orderService;

    public Controller(UserService userService, OrderService orderService) {
        this.userService = userService;
        this.orderService = orderService;
    }

    @PostMapping("/users/rollback")
    public String triggerRollback() {
        try {
            userService.createUsersWithRollback();
        } catch (Exception e) {
            return "Rollback triggered: " + e.getMessage();
        }
        return "Should not happen";
    }

    @PostMapping("/orders/requires-new")
    public String requiresNewTx() {
        try {
            orderService.createOrderWithNewTx("Book");
        } catch (Exception e) {
            return "Requires-new rollback: " + e.getMessage();
        }
        return "Should not happen";
    }

    @PostMapping("/orders/nested")
    public String nestedTx() {
        try {
            orderService.nestedTransaction("Phone");
        } catch (Exception e) {
            return "Nested rollback: " + e.getMessage();
        }
        return "Should not happen";
    }

    @PostMapping("/orders/programmatic")
    public String programmaticTx() {
        try {
            orderService.programmaticTransaction("Pen");
        } catch (Exception e) {
            return "Programmatic rollback: " + e.getMessage();
        }
        return "Should not happen";
    }

    @GetMapping("/stats")
    public String stats() {
        return "Users: " + userService.countUsers() +
               ", Orders: " + orderService.countOrders();
    }
}
