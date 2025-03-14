package org.karane.controller;

import org.karane.model.Post;
import org.karane.service.ApiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController {
    private final ApiService apiService;

    public ApiController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping("/post/{id}")
    public Post getPost(@PathVariable int id) {
        return apiService.getPost(id);
    }

    @PostMapping("/post")
    public Post createPost(@RequestBody Post post) {
        return apiService.createPost(post);
    }

    @PutMapping("/post/{id}")
    public void updatePost(@PathVariable int id, @RequestBody Post post) {
        apiService.updatePost(id, post);
    }

    @DeleteMapping("/post/{id}")
    public void deletePost(@PathVariable int id) {
        apiService.deletePost(id);
    }

    @GetMapping("/post-with-headers/{id}")
    public ResponseEntity<String> getPostWithHeaders(@PathVariable int id) {
        return apiService.getPostWithHeaders(id);
    }
}
