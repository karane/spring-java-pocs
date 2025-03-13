package org.karane.controler;

import org.karane.model.Item;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class Controller {
    private Map<Integer, String> data = new HashMap<>();

    @GetMapping("/items")
    public Map<Integer, String> getAllItems() {
        return data;
    }

    @GetMapping("/items/{id}")
    public ResponseEntity<String> getItem(@PathVariable int id) {
        if (!data.containsKey(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item not found");
        }
        return ResponseEntity.ok(data.get(id));
    }

    @PostMapping("/items")
    public ResponseEntity<String> createItem(@Valid @RequestBody Item item) {
        data.put(item.getId(), item.getValue());
        return ResponseEntity.status(HttpStatus.CREATED).body("Item created");
    }

    @PutMapping("/items/{id}")
    public ResponseEntity<String> updateItem(@PathVariable int id, @RequestParam String value) {
        if (data.containsKey(id)) {
            data.put(id, value);
            return ResponseEntity.ok("Item updated");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item not found");
    }

    @DeleteMapping("/items/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable int id) {
        if (data.remove(id) != null) {
            return ResponseEntity.ok("Item deleted");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item not found");
    }
}