package com.example.microservice3.service;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "Microservice3", url = "${Microservice3.url}")
public interface Client2 {
    @GetMapping("/hello")
    String getMessageFromA();
}
