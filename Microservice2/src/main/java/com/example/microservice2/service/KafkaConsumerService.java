package com.example.microservice2.service;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
@Service
public class KafkaConsumerService {
    @KafkaListener(topics = "MyApplication", groupId = "myapplication-M2")
    public void listenGroup1(String message) {
        System.out.println("Received Message: " + message);
    }
}
