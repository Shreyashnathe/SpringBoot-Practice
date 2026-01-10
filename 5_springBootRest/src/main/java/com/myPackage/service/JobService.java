package com.myPackage.service;

import com.myPackage.model.JobPost;
import com.myPackage.repository.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepo jobRepo;

    public JobRepo getJobRepo() {
        return jobRepo;
    }

    public void setJobRepo(JobRepo jobRepo) {
        this.jobRepo = jobRepo;
    }

    public void addJob(JobPost jobPost) {
        jobRepo.addJob(jobPost);
    }

    public List<JobPost> getAllJobs() {
        return jobRepo.getAllJobs();
    }

    public JobPost jobPostById(int id) {
        return jobRepo.jobPostById(id);
    }

    public JobPost updateJob(JobPost jobPost) {
        return jobRepo.updateJob(jobPost);
    }

    public JobPost jobDeleteById(int id) {
        return jobRepo.jobDeleteById(id);
    }
}
