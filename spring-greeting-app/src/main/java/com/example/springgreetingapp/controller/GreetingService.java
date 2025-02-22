package com.example.springgreetingapp.controller;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    public String getGreetingMessage() {
        return "Hello World";
    }
}
