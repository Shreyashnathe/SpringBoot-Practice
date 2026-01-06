package com.myPackage;

import com.myPackage.model.JobPost;
import com.myPackage.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping({"/", "/home"})
    public String home() {
        return "home";
    }

    @GetMapping({"/addjob", "/addJob"})
    public String addJob() {
        return "addjob";
    }

    @PostMapping("/handleForm")
    public String handleForm(JobPost jobPost) {
        jobService.addJob(jobPost);
        return "success";
    }

    @GetMapping({"/viewalljobs", "/viewall"})
    public String viewAllJobs(Model model) {
        List<JobPost> allJobs = jobService.viewAllJobs();
        model.addAttribute("jobPosts", allJobs);
        System.out.println(allJobs);
        return "viewalljobs";
    }
}
