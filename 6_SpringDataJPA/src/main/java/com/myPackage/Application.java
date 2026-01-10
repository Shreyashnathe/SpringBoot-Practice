package com.myPackage;

import com.myPackage.model.Student;
import com.myPackage.repo.Repo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Optional;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Application.class, args);

        Repo repository = context.getBean(Repo.class);

//        Student s1 = context.getBean(Student.class);
//        Student s2 = context.getBean(Student.class);
//        Student s3 = context.getBean(Student.class);
//
//        s1.setRollno(101);
//        s1.setName("Alice");
//        s1.setDept("Computer Science");
//
//        s2.setRollno(102);
//        s2.setName("Bob");
//        s2.setDept("Mechanical Engineering");
//
//        s3.setRollno(103);
//        s3.setName("Charlie");
//        s3.setDept("Electrical Engineering");
//
//        repository.save(s1);
//        repository.save(s2);
//        repository.save(s3);



//        System.out.println(repository.findAll());
//
//        Optional<Student> s = repository.findById(102);
//        System.out.println(s);
//
//        System.out.println(repository.findByName("Charlie"));
//
//        System.out.println(repository.findByDept("Computer Science"));


//        repository.delete(s2);
    }

}
