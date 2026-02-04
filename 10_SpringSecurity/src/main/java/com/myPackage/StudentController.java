package com.myPackage;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    List<Student> studentList = List.of(
            new Student(1, "Alice", "Java"),
            new Student(2, "Bob", "Python"),
            new Student(3, "Charlie", "JavaScript")
    );

    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentList;
    }

    @PostMapping("/student")
    public Student addStudent(Student student) {
        studentList.add(student);
        return student;
    }
}
