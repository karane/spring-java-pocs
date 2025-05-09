package org.karane.transaction_demo.service;

import org.karane.transaction_demo.entity.User;
import org.karane.transaction_demo.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.context.ApplicationEventPublisher;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final ApplicationEventPublisher publisher;

    public UserService(UserRepository userRepository, ApplicationEventPublisher publisher) {
        this.userRepository = userRepository;
        this.publisher = publisher;
    }

    @org.springframework.transaction.annotation.Transactional(
        rollbackFor = {Exception.class},
        propagation = Propagation.REQUIRED,
        isolation = Isolation.REPEATABLE_READ
    )
    public void createUsersWithRollback() throws Exception {
        userRepository.save(new User("David"));
        publisher.publishEvent("AFTER_USER_SAVED");

        throw new Exception("Checked exception – triggers rollback due to rollbackFor");
    }

    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public long countUsers() {
        return userRepository.count();
    }
}
