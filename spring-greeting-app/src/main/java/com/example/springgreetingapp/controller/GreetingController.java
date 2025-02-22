package com.example.springgreetingapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private final GreetingService greetingService;

    @Autowired
    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/simple")
    public ResponseEntity<Map<String, String>> getSimpleGreeting() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello, World!");
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<String> getGreeting() {
        return ResponseEntity.ok(greetingService.getGreetingMessage());
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
