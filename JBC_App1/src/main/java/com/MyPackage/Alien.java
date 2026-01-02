package com.MyPackage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Alien {
    private int age;

//    @Autowired // instead of using autowired and all the related properties on the top of complex type, it is suggestable to use on the setter method of the given complex type
//    @Qualifier("laptop") // while using qualifier, when we specify the name of the bean, then we have to use the name of the class with small characters, also we can change the name of the class(bean)
    private Computer com;

    public Alien(){
        System.out.println("Alien object created");
    }

    public Computer getCom() {
        return com;
    }

    @Autowired
    @Qualifier("laptop")
    public void setCom(Computer com) {
        this.com = com;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void code(){
        System.out.println("Coding...");
        com.compile();
    }
}
