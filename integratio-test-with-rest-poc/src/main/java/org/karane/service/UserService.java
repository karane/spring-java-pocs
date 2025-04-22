package org.karane.service;

import org.karane.model.User;
import org.karane.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
  private final UserRepository repository;

  public UserService(UserRepository repository) {
    this.repository = repository;
  }

  public List<User> getAllUsers() {
    return repository.findAll();
  }

  public User createUser(User user) {
    return repository.save(user);
  }
}
