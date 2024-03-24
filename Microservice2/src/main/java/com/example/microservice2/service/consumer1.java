package com.example.microservice2.service;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
@FeignClient(name = "serviceA", url = "${serviceA.url}")
public interface consumer1 {
    @GetMapping("/hello")
    String hello();
}
