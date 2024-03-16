package com.example.microservice3.controller;

import com.example.microservice3.service.Client2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Service3Controller {
    private Client2 client2;

    public Service3Controller(Client2 client2) {
        this.client2 = client2;
    }

    @GetMapping("call-service-2")
    public String getMessageFromB(){
        String messageFromB = client2.getMessageFromA();
        return "Service 3 calling Service 1: "+ messageFromB;
    }
}
