package org.karane.controler;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api")
public class HelloController {
    private Map<Integer, String> data = new HashMap<>();

    @GetMapping("/items")
    public Map<Integer, String> getAllItems() {
        return data;
    }

    @GetMapping("/items/{id}")
    public String getItem(@PathVariable int id) {
        return data.getOrDefault(id, "Item not found");
    }

    @PostMapping("/items")
    public String createItem(@RequestBody Map<String, Object> requestBody) {
        int id = (int) requestBody.get("id");
        String value = (String) requestBody.get("value");
        data.put(id, value);
        return "Item created";
    }

    @PutMapping("/items/{id}")
    public String updateItem(@PathVariable int id, @RequestParam String value) {
        if (data.containsKey(id)) {
            data.put(id, value);
            return "Item updated";
        }
        return "Item not found";
    }

    @DeleteMapping("/items/{id}")
    public String deleteItem(@PathVariable int id) {
        if (data.remove(id) != null) {
            return "Item deleted";
        }
        return "Item not found";
    }
}