package com.myPackage;

import com.myPackage.model.Alien;
import com.myPackage.model.Laptop;
import com.myPackage.service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpbDemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpbDemoApplication.class, args);
        System.out.println("Hello World");

//        Alien obj = context.getBean(Alien.class);
//        obj.code();

        LaptopService service = context.getBean(LaptopService.class);

        Laptop lap = context.getBean(Laptop.class);
        service.addLaptop(lap);
        System.out.println("Laptop is Good? : "+service.isGood(lap));
	}

}
