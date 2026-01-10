package com.myPackage;

import com.myPackage.model.Student;
import com.myPackage.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);
        System.out.println("Application Started...");

        Student student = context.getBean(Student.class);
        student.setRollno(101);
        student.setName("John Doe");
        student.setDept("Computer Science");

        System.out.println("Student Details: " + student);

        StudentService service = context.getBean(StudentService.class);
        service.addStudent(student);
	}

}
