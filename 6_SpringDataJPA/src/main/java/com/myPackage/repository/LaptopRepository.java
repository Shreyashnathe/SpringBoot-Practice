package com.myPackage.repository;

import com.myPackage.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LaptopRepository {

    private JdbcTemplate template;

    public JdbcTemplate getTemplate() {
        return template;
    }

    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public void save(Student student) {
        String sql = "INSERT INTO student VALUES (?, ?, ?)";

        template.update(sql, student.getRollno(), student.getName(), student.getDept());
        System.out.println("Student Saved Successfully");
    }
}
