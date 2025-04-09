package org.karane.service;

import org.karane.entity.Role;
import org.karane.entity.User;
import org.karane.repository.RoleRepository;
import org.karane.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    RoleService roleService;

    public UserService(UserRepository userRepository, RoleService roleService) {
        this.userRepository = userRepository;
        this.roleService = roleService;
    }

    public User createUser(User user) {
        if (roleService.findById(user.getRoleId()).isEmpty()) {
            throw new IllegalArgumentException("Role does not exist");
        }
        return userRepository.save(user);
    }

    public User updateUser(Long id, User user) {
        User existing = userRepository.findById(id).orElseThrow();
        existing.setName(user.getName());
        existing.setEmail(user.getEmail());
        existing.setRoleId(user.getRoleId());
        return userRepository.save(existing);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public List<User> getAllUsersPaged(int limit, int offset) {
        return userRepository.findAllPaged(limit, offset);
    }

    @Transactional
    public User createUserWithRole(String name, String email, String roleName) {
        Role role = roleRepository.findByName(roleName);
        if (role == null) {
            role = new Role();
            role.setName(roleName);
            roleRepository.save(role);
        }

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setRoleId(role.getId());

        userRepository.save(user);
        return user;
    }
}
