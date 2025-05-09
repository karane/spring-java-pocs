package org.karane.transaction_demo.entity;


import jakarta.persistence.*;


@Entity
@Table(name = "app_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String product;

    public Order() {}
    public Order(String product) { this.product = product; }

    // Getters/Setters
}
