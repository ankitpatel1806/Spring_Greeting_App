package com.example.springgreetingapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @GetMapping
    public ResponseEntity<Map<String, String>> getGreeting() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello, World!");
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> postGreeting(@RequestBody Map<String, String> greeting) {
        return ResponseEntity.status(HttpStatus.CREATED).body(greeting);
    }

    @PutMapping
    public ResponseEntity<Map<String, String>> updateGreeting(@RequestBody Map<String, String> greeting) {
        return ResponseEntity.ok(greeting);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteGreeting() {
        return ResponseEntity.ok("Greeting deleted");
    }
}
