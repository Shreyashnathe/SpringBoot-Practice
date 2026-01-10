package com.myPackage.repository;

import com.myPackage.model.JobPost;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class JobRepo {

    List<JobPost> list = new ArrayList<>(
            Arrays.asList(
                    new JobPost(1, "Java Developer", "Backend development using Spring Boot", 2,
                            Arrays.asList("Java", "Spring Boot", "Hibernate", "MySQL")),

                    new JobPost(2, "Frontend Developer", "UI development using React", 1,
                            Arrays.asList("HTML", "CSS", "JavaScript", "React")),

                    new JobPost(3, "Full Stack Developer", "End-to-end web application development", 3,
                            Arrays.asList("Java", "Spring Boot", "React", "PostgreSQL")),

                    new JobPost(4, "DevOps Engineer", "CI/CD pipeline and cloud deployment", 2,
                            Arrays.asList("Docker", "Kubernetes", "AWS", "Git")),

                    new JobPost(5, "Data Analyst", "Data analysis and visualization", 1,
                            Arrays.asList("Python", "Pandas", "SQL", "Power BI"))
            )
    );

    public void addJob(JobPost jobPost) {
        list.add(jobPost);
        System.out.println("Jod added Successfully");
//        System.out.println(list);
    }

    public List<JobPost> getAllJobs() {
        return list;
    }

    public JobPost jobPostById(int id) {
        for (JobPost jobPost : list) {
            if (jobPost.getPostId() == id) {
                return jobPost;
            }
        }
        return null;
    }

    public JobPost updateJob(JobPost jobPost) {
        for(JobPost jobPost1 : list){
            if(jobPost1.getPostId() == jobPost.getPostId()){
                jobPost1.setPostProfile(jobPost.getPostProfile());
                jobPost1.setPostDesc(jobPost.getPostDesc());
                jobPost1.setReqExperience(jobPost.getReqExperience());
                jobPost1.setPostTechStack(jobPost.getPostTechStack());
                System.out.println("Job updated successfully");
                return jobPost1;
            }
        }
        addJob(jobPost);
        return jobPost;

    }

    public JobPost jobDeleteById(int id) {
        for(JobPost jobPost : list){
            if(jobPost.getPostId() == id){
                list.remove(jobPost);
                System.out.println("Job deleted successfully");
                return jobPost;
            }
        }
        return null;
    }
}
