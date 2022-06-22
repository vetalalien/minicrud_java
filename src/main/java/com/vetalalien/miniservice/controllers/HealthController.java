package com.vetalalien.miniservice.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {
    @GetMapping("/health")
    ResponseEntity checkHealth(){
        return ResponseEntity.ok("All is OK");
    }
}
