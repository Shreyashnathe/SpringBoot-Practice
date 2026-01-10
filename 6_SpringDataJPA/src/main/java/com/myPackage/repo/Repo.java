package com.myPackage.repo;

import com.myPackage.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Repo extends JpaRepository<Student, Integer> {

    List<Student> findByName(String charlie);

    List<Student> findByDept(String computerScience);
}
