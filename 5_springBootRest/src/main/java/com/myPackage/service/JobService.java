package com.myPackage.service;

import com.myPackage.model.JobPost;
import com.myPackage.repository.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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

    // Initial Job Data
    List<JobPost> list = new ArrayList<>(
            Arrays.asList(
                    new JobPost(1, "Java Developer", "Backend development using Spring Boot", 2, Arrays.asList("Java", "Spring Boot", "Hibernate", "MySQL")),
                    new JobPost(2, "Frontend Developer", "UI development using React", 1, Arrays.asList("HTML", "CSS", "JavaScript", "React")),
                    new JobPost(3, "Full Stack Developer", "End-to-end web application development", 3, Arrays.asList("Java", "Spring Boot", "React", "PostgreSQL")),
                    new JobPost(4, "DevOps Engineer", "CI/CD pipeline and cloud deployment", 2, Arrays.asList("Docker", "Kubernetes", "AWS", "Git")),
                    new JobPost(5, "Data Analyst", "Data analysis and visualization", 1, Arrays.asList("Python", "Pandas", "SQL", "Power BI"))
            )
    );

    // Load Initial Data
    public void loadData() {
        jobRepo.saveAll(list);
    }

    // Add Job
    public void addJob(JobPost jobPost) {
        jobRepo.save(jobPost);
    }

    // Get All Jobs
    public List<JobPost> getAllJobs() {
        return jobRepo.findAll();
    }

    // Get Job by Id
    public JobPost jobPostById(int id) {
        return jobRepo.findById(id).orElse(new JobPost());
    }

    // Update Job
    public JobPost updateJob(JobPost jobPost) {
        return jobRepo.save(jobPost);
    }

    // Delete Job by Id
    public JobPost jobDeleteById(int id) {
        Optional<JobPost> job = jobRepo.findById(id);
        jobRepo.deleteById(id);
        return job.orElse(null);
    }

    // Get Jobs by Keyword
    public List<JobPost> getJobByKeyword(String keyword) {
        return jobRepo.findByPostProfileContainingOrPostDescContaining(keyword, keyword);
    }
}
