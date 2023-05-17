package com.example.QuantumSort.controllers;

import com.example.QuantumSort.models.ApplicationUser;
import com.example.QuantumSort.repos.ApplicationUserRepository;
import com.example.QuantumSort.repos.ClientRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.servlet.view.RedirectView;
import jakarta.servlet.ServletException;

import java.security.Principal;

@Controller
public class AppUserController {

    @Autowired
    ApplicationUserRepository applicationUserRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private HttpServletRequest request;



    @GetMapping("/")
    public String homePage(Model m, Principal p){
        if (p != null){
            String username = p.getName();
            ApplicationUser user = applicationUserRepository.findByUserName(username);
            m.addAttribute("username", username);
        }
        return "index.html";
    }

    @GetMapping("/signUp")
    public String showSignUpForm(Model m){
        return "signUp.html";
    }

    @PostMapping("/signUp")
              public RedirectView createUser(String userName, String password, String firstName, String lastName, HttpServletRequest request) {
                  ApplicationUser newUser = new ApplicationUser();
                  newUser.setUserName(userName);
                   String encryptedPassword = passwordEncoder.encode(password);
        newUser.setPassword(encryptedPassword);
        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);
        //TODO: Add checks for isAgent based on user input
        applicationUserRepository.save(newUser);
                  authWithHttpServletRequest(userName, password, request);
                  return new RedirectView("/");
                 }

    public void authWithHttpServletRequest(String userName, String password, HttpServletRequest request) {
        try {
            request.login(userName, password);
        } catch (ServletException e) {
            System.out.println("Error while logging in!");
            e.printStackTrace();
        }
    }


    @GetMapping("/login")
    public String showLoginForm() {
        return "login.html";
    }
}
