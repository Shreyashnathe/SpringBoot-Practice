package com.myPackage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class JobController {

    @GetMapping({"/", "/home"})
    public String home() {
        return "home";
    }

    @GetMapping({"/addjob", "/addJob"})
    public String addJob() {
        return "addjob";
    }

    @GetMapping({"/viewalljobs", "/viewall"})
    public String viewAllJobs() {
        return "viewalljobs";
    }

    @PostMapping("/handleForm")
    public String handleForm() {
        return "success";
    }
}
