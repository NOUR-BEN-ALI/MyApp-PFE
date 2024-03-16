package com.example.microservice2.controller;

import com.example.microservice2.service.client1;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class Service2Controller {
    private client1 client1;
    public Service2Controller(client1 client1) {
        this.client1 = client1;
    }
    @GetMapping("/call-service-1")
    public String getMessageFromA() {
        String messageFrom1 = client1.hello();
        return "consumer 1 calling producer : " + messageFrom1;
    }
}
