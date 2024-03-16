package com.example.microservice3.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumer {

    @KafkaListener(topics = "MyApplication", groupId = "myapplication-M3")
    public void listen(String message) {
        System.out.println("Received message: " + message);
    }

}