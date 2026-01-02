package com.myPackage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/home")
    public String home(){
        System.out.println("This is home controller");
        return "index.jsp";
    }

    @RequestMapping("/add")
    public String add(){
        System.out.println("in Add method");
        return "result.jsp";
    }
}
