package com.example.QuantumSort.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/user")
public class AppUserController {

    @GetMapping("/signUp")
    public String showSignUpForm(){
        return "signUp";
    }

    @PostMapping("/signUp")
    public String registerUser() {
        return "listings";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }
}
