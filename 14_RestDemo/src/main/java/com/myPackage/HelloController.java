package com.myPackage;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String hello(){
        return "Hello World";
    }

    @GetMapping("/about")
    public String About(){
        return "This is a Spring Boot application.";
    }
}
