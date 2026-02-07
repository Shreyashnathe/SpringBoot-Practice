package com.myPackage.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/home")
    public String home(HttpServletRequest request){
        return "Welcome to Home Page " + request.getSession().getId();
    }

    @GetMapping("/about")
    public String About(){
        return "This is About Page";
    }
}
