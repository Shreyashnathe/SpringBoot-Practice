package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Alien {

    @Autowired
    Laptop laptop;

    void code(){
        System.out.println("Coding by Alien...");
        laptop.compile();
    }
}
