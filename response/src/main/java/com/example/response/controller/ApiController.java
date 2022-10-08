package com.example.response.controller;

import com.example.response.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController {

    //TEXT
    @GetMapping("/text")
    public String text(@RequestParam String account){
        return account;
    }

    //JSON
    //req -> objec mapper -> object -> method -> object -> object mapper -> json -> response
    @PostMapping("/json")
    public User json(@RequestBody User user){
        System.out.println(user);
        return user;
    }

    //ResponseEntity
    @PutMapping("/put")
    public ResponseEntity<User> put(@RequestBody User user){

        //생성되면 201 내려줌
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}
