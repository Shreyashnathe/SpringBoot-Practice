package com.myPackage.repository;

import com.myPackage.model.Laptop;
import org.springframework.stereotype.Repository;

@Repository
public class LaptopRepo {

    public void save(Laptop lap) {
        System.out.println("Laptop saved in Database...");
    }
}
