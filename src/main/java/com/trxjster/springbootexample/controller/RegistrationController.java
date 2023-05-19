package com.trxjster.springbootexample.controller;

import com.trxjster.springbootexample.beans.User;
import com.trxjster.springbootexample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    private final UserRepository userRepository;

    @Autowired
    public RegistrationController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/register-user")
    public String registerUser(@Valid @ModelAttribute("newuser")User user, BindingResult result, Model model){
        System.out.println("in registration controller");

        if (result.hasErrors()) { return "register"; }
        userRepository.save(user);
        model.addAttribute("dataSaved", "User registered successfully");
        return "login";
    }
}
