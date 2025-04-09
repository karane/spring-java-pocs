package org.karane.controller;

import org.karane.entity.User;
import org.karane.entity.UserWithRoleRequest;
import org.karane.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id).orElseThrow();
    }

    @GetMapping
    public List<User> getAllUsersPaged(@RequestParam(defaultValue = "10") int limit,
                                       @RequestParam(defaultValue = "0") int offset) {
        return userService.getAllUsersPaged(limit, offset);
    }

    @PostMapping("/with-role")
    public ResponseEntity<User> createUserWithRole(@RequestBody UserWithRoleRequest request) {
        User user = userService.createUserWithRole(request.getName(), request.getEmail(), request.getRoleName());
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(user);
    }

}
