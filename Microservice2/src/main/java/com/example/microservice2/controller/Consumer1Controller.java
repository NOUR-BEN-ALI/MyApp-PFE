package com.example.microservice2.controller;

import com.example.microservice2.service.consumer1;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class Consumer1Controller {
    private consumer1 consumer1;
    public Consumer1Controller(consumer1 consumer1) {
        this.consumer1 = consumer1;
    }
    @GetMapping("/call-service-a")
    public String getMessageFromA() {
        String messageFromA = consumer1.hello();
        return "Service B calling Service A : " + messageFromA;
    }
}
