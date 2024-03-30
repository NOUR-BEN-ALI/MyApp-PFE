package com.example.microservice2.service;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

// essential for creating declarative REST clients in Spring Cloud
@FeignClient(name = "service1", url = "${service1.url}")
public interface consumer1 {
    @GetMapping("/hello")
    String hello();
}
