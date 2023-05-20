package com.trxjster.springbootexample.controller;

import com.trxjster.springbootexample.beans.Login;
import com.trxjster.springbootexample.beans.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String goHome(){
        System.out.println("in home controller");
        return "index";
    }

    @GetMapping("/goToSearch")
    public String goToSearch(){
        System.out.println("going to search page");
        return "search";
    }

    @GetMapping("/goToLogin")
    public String goToLogin(){
        System.out.println("going to login page");
        return "login";
    }

    @GetMapping("/goToRegistration")
    public String goToRegistration(){
        System.out.println("going to registration page");
        return "register";
    }

//    @ModelAttribute("newuser")
//    public User getDefaultUser(){
//        return new User();
//    }
//
//    @ModelAttribute("genderItems")
//    public List<String> getGenderList(){
//        return Arrays.asList(new String[]{"Male", "Female", "Other"});
//    }
//
//    @ModelAttribute("login")
//    public Login getDefaultLogin(){
//        return new Login();
//    }
}
