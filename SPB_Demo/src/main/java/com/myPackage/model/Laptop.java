package com.myPackage.model;

import com.myPackage.service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Laptop implements Computer {

    public Laptop(){
        System.out.println("Laptop object created");
    }

    @Override
    public void compile(){
        System.out.println("Compiling code on Laptop...");
    }


}
