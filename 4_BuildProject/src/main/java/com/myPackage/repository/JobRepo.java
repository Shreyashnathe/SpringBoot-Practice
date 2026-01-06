package com.myPackage.repository;

import com.myPackage.model.JobPost;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class JobRepo {

    public List<JobPost> list = new ArrayList<>();

    public void addJob(JobPost jobPost) {
        list.add(jobPost);
        System.out.println("Jod added Successfully");
//        System.out.println(list);
    }

    public List<JobPost> viewAllJobs() {
        return list;
    }
}
