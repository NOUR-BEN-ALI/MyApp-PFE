package com.example.microservice3.service;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "serviceB", url = "${serviceB.url}")
public interface consumer2 {
    @GetMapping("/hello")
    String getMessageFromA();
}
