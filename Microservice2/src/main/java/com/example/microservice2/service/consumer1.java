package com.example.microservice2.service;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

// essential for creating declarative REST clients in Spring Cloud
@FeignClient(name = "serviceA", url = "${serviceA.url}")
public interface consumer1 {
    @GetMapping("/hello")
    String hello();
}
