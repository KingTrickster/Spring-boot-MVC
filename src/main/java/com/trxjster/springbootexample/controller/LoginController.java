package com.trxjster.springbootexample.controller;

import com.trxjster.springbootexample.beans.Login;
import com.trxjster.springbootexample.beans.User;
import com.trxjster.springbootexample.exceptions.ApplicationException;
import com.trxjster.springbootexample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("login")
public class LoginController {

    private final UserRepository userRepository;

    @Autowired
    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("login") Login login){
        User user = userRepository.searchByName(login.getUsername());
        if(user==null){
            throw new ApplicationException("User not found");
        }
        return "forward:/userprofile";
    }

    @ExceptionHandler(ApplicationException.class)
    public String handleException(){
        System.out.println("In exception handler of login controller");
        return "error";
    }
}
