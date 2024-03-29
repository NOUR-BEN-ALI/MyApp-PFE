package com.example.microservice3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class Microservice3Application {

    public static void main(String[] args) {
        SpringApplication.run(Microservice3Application.class, args);
    }

}
