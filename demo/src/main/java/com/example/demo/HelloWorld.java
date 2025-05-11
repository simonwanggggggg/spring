package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
    @GetMapping("/")
    public String index() {
        return "Index working!";
    }
    @GetMapping("/hello")
    public String hello() {
        System.out.println("👉 /hello 被呼叫了");
        return "HelloWorld!";
    }
}
