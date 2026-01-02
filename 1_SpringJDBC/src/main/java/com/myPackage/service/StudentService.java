package com.myPackage.service;

import com.myPackage.model.Student;
import com.myPackage.repository.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private LaptopRepository laptopRepository;

    public LaptopRepository getLaptopRepository() {
        return laptopRepository;
    }

    public void setLaptopRepository(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }


    public void addStudent(Student student) {
        laptopRepository.save(student);
    }
}
