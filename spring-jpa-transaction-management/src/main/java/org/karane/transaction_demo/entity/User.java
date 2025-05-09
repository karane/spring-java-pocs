package org.karane.transaction_demo.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "app_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public User() {}
    public User(String name) { this.name = name; }

    // Getters/Setters
}
