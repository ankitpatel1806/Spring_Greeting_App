package com.example.springgreetingapp.controller;

import com.example.springgreetingapp.model.Greeting;
import com.example.springgreetingapp.repository.GreetingRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GreetingService {
    private final GreetingRepository greetingRepository;
    public GreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    public String getGreetingMessage() {
        return "Hello World";
    }
    public String getGreetingMessage(String firstName, String lastName) {
        if (firstName != null && lastName != null) {
            return "Hello, " + firstName + " " + lastName + "!";
        } else if (firstName != null) {
            return "Hello, " + firstName + "!";
        } else if (lastName != null) {
            return "Hello, " + lastName + "!";
        } else {
            return "Hello World";
        }
    }
    public String getGreetingById(Long id) {
        return greetingRepository.findById(id)
                .map(Greeting::getMessage)
                .orElse("Greeting not found");
    }
    public void saveGreetingMessage(String message) {
        greetingRepository.save(new Greeting(message));
    }
    public List<String> getAllGreetings() {
        return greetingRepository.findAll().stream()
                .map(Greeting::getMessage)
                .toList();
    }
}