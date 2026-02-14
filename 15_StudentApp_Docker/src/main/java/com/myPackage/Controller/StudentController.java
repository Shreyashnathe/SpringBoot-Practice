package com.myPackage.Controller;

import com.myPackage.model.Student;
import com.myPackage.repo.StudentRepo;
import com.myPackage.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentRepo studentRepo;

    @GetMapping("/students")
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @PostMapping("/addStudent")
    public void addStudent(){
        Student student = new Student();
        student.setId(7);
        student.setName("John Doe");
        student.setDept("Computer Science");
        studentRepo.save(student);
    }
}
