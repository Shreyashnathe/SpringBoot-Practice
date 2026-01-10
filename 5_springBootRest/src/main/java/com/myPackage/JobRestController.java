package com.myPackage;

import com.myPackage.model.JobPost;
import com.myPackage.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobRestController {

    @Autowired
    private JobService jobService;

    // Load Initial Data
    @GetMapping("/load")
    public String loadData(){
        jobService.loadData();
        return "Data Loaded Successfully";
    }

    // Get All Jobs
    @GetMapping("/jobPosts")
//    @ResponseBody  //when we use RestController this is optional
    public List<JobPost> getAllJobs(){
        return jobService.getAllJobs();
    }

    // Get Job by Id
    @GetMapping("/jobPost/{id}")
    public JobPost getJobById(@PathVariable int id){
        return jobService.jobPostById(id);
    }

    // Add Job
    @PostMapping("/jobPost")
    public JobPost addJb(@RequestBody JobPost jobPost){
        jobService.addJob(jobPost);
        return jobPost;
    }

    // Update Job
    @PutMapping("/jobPost")
    public Optional<JobPost> updateJob(@RequestBody JobPost jobPost){
        jobService.updateJob(jobPost);
        return Optional.ofNullable(jobPost);
    }

    // Delete Job
    @DeleteMapping("/jobPost/{id}")
    public JobPost deleteJob(@PathVariable int id){
        return jobService.jobDeleteById(id);
    }

    // Get Jobs by Keyword
    @GetMapping("/jobPosts/keyword/{keyword}")
    public List<JobPost> getJobByKeyword(@PathVariable("keyword") String keyword){
        return jobService.getJobByKeyword(keyword);
    }
}
