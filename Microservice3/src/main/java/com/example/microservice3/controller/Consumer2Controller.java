package com.example.microservice3.controller;

import com.example.microservice3.service.consumer2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Consumer2Controller {
    private consumer2 consumer2;

    public Consumer2Controller(consumer2 consumer2) {
        this.consumer2 = consumer2;
    }
    @GetMapping("call-service-b")
    public String getMessageFromB(){
        String messageFromB = consumer2.getMessageFromA();
        return "Service C calling Service B: "+ messageFromB;
    }
}
