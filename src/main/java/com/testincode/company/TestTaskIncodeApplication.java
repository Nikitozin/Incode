package com.testincode.company;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.testincode"})
public class TestTaskIncodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestTaskIncodeApplication.class, args);
    }

}
