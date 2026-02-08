package com.myPackage.controller;

import com.myPackage.model.User;
import com.myPackage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

//    @PostMapping("/register")
//    public User saveUser(@RequestBody User user) {
//        return userService.saveUser(user);
//    }

    @PostMapping("/register")
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }
}
