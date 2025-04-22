package org.karane.controller;

import jakarta.validation.Valid;
import org.karane.model.User;
import org.karane.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
  private final UserService service;

  public UserController(UserService service) {
    this.service = service;
  }

  @GetMapping
  public List<User> getAllUsers() {
    return service.getAllUsers();
  }

  @PostMapping
  public ResponseEntity<User> createUser(@RequestBody @Valid User user) {
    User created = service.createUser(user);
    return ResponseEntity.status(HttpStatus.CREATED).body(created);
  }

}
