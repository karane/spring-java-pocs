package org.karane.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Cacheable(value = "users", key = "#id")
    public String getUserById(Long id) {
        simulateSlowService();
        return "User-" + id;
    }

    @CachePut(value = "users", key = "#id")
    public String updateUser(Long id) {
        return "UpdatedUser-" + id;
    }

    @CacheEvict(value = "users", key = "#id")
    public void deleteUser(Long id) {
        System.out.println("Removed from cache: " + id);
    }

    private void simulateSlowService() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}
