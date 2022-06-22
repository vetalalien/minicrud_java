package com.vetalalien.miniservice.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainPageController {
    @GetMapping("/otus")
    ResponseEntity checkHealth(){
        return ResponseEntity.ok("Hello, otus world!");
    }
}