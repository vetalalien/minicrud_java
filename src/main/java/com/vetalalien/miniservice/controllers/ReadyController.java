package com.vetalalien.miniservice.controllers;


import com.vetalalien.miniservice.entity.PersonEntity;
import com.vetalalien.miniservice.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class ReadyController {
    @Autowired
    private PersonService personService;

    public ResponseEntity internalServerError(String msg) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(msg);
    }

    @GetMapping("/ready")
    ResponseEntity<String> checkReadiness(){
        try {
            PersonEntity person = personService.findMyFirst();
            if (person == null) return ResponseEntity.ok("No person found, but DB engine is ready");
            else {
                return ResponseEntity.ok("Some person was found, DB engine is ready");
            }
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something is wrong" + e.getMessage());
        }
    }
}
