package com.example.microservice1.services;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
    public class KafkaProducerService{
        private KafkaTemplate<String, String> kafkaTemplate;
        public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate) {
            this.kafkaTemplate = kafkaTemplate;
        }
        public void sendMessage(String message) {
            kafkaTemplate.send("MyApplication", message);
        }
    }

