package com.myPackage;

import com.myPackage.model.JobPost;
import com.myPackage.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobRestController {

    @Autowired
    private JobService jobService;

    @GetMapping("/jobPosts")
//    @ResponseBody  //when we use RestController this is optional
    public List<JobPost> getAllJobs(){
        return jobService.getAllJobs();
    }

    @GetMapping("/jobPost/{id}")
    public JobPost getJobById(@PathVariable int id){
        return jobService.jobPostById(id);
    }

    @PostMapping("/jobPost")
    public JobPost addJb(@RequestBody JobPost jobPost){
        jobService.addJob(jobPost);
        return jobPost;
    }

    @PutMapping("/jobPost")
    public JobPost updateJob(@RequestBody JobPost jobPost){
        jobService.updateJob(jobPost);
        return jobPost;
    }

    @DeleteMapping("/jobPost/{id}")
    public JobPost deleteJob(@PathVariable int id){
        return jobService.jobDeleteById(id);
    }
}
