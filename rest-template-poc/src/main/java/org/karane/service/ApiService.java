package org.karane.service;

import org.karane.model.Post;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiService {
    private final RestTemplate restTemplate;
    private static final String API_URL = "https://jsonplaceholder.typicode.com/posts";

    public ApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // GET request to fetch a post
    public Post getPost(int id) {
        return restTemplate.getForObject(API_URL + "/" + id, Post.class);
    }

    // POST request to create a new post
    public Post createPost(Post post) {
        return restTemplate.postForObject(API_URL, post, Post.class);
    }

    // PUT request to update a post
    public void updatePost(int id, Post post) {
        restTemplate.put(API_URL + "/" + id, post);
    }

    // DELETE request to remove a post
    public void deletePost(int id) {
        restTemplate.delete(API_URL + "/" + id);
    }

    // Using exchange() for more control
    public ResponseEntity<String> getPostWithHeaders(int id) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Custom-Header", "Value");

        HttpEntity<String> entity = new HttpEntity<>(headers);
        return restTemplate.exchange(API_URL + "/" + id, HttpMethod.GET, entity, String.class);
    }
}
