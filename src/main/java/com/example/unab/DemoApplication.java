package com.example.unab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        System.out.println("Iniciar API UNAB 2.1");
        SpringApplication.run(DemoApplication.class, args);
        

    }

}
