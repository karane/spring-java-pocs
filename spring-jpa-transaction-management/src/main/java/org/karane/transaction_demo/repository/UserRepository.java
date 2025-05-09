package org.karane.transaction_demo.repository;

import org.karane.transaction_demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {}
