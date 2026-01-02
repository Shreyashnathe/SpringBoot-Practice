package com.myPackage.service;

import com.myPackage.model.Laptop;
import com.myPackage.repository.LaptopRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LaptopService {

    @Autowired
    private LaptopRepo repo;

    public void addLaptop(Laptop lap) {
        repo.save(lap);
    }

    public boolean isGood(Laptop lap){
        return true;
    }
}
