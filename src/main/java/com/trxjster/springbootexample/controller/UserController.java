package com.trxjster.springbootexample.controller;

import com.trxjster.springbootexample.beans.User;
import com.trxjster.springbootexample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public List<User> getAll(){
        return (List<User>) userRepository.findAll();
    }
}
