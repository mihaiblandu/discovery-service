package com.example.discoveryservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {

    @GetMapping("/home")
    public ResponseEntity<String> entityResponse()
    {
        return new ResponseEntity("Hello World !!!", HttpStatus.OK);
    }
}
