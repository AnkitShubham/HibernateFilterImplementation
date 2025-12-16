package dev.project.hibernateFilterImplementation.controller;

import dev.project.hibernateFilterImplementation.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/test")
    public ResponseEntity<?> test() {
        return ResponseEntity.status(200).body("Backend is up and running");
    }

    @GetMapping("/getData")
    public ResponseEntity<?> getData() {
        return ResponseEntity.status(200).body(testService.findAll());
    }
}
