package com.MyPackage.config;

import com.MyPackage.Alien;
import com.MyPackage.Computer;
import com.MyPackage.Desktop;
import com.MyPackage.Laptop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan("com.MyPackage")
public class AppConfig {

//    @Bean
//    public Alien alien(@Autowired Computer com){
//        Alien al = new Alien();
//        al.setAge(25);
//        al.setCom(com);
//        return al;
//    }
//
////    @Bean(name = {"aaa", "com2", "desk"})
//    @Bean //by default the bean name is the method name which is desktop in this case
//    public Desktop desktop(){
//        return new Desktop();
//    }
//
//    @Bean
//    @Primary
//    public Laptop laptop(){
//        return new Laptop();
//    }
}
