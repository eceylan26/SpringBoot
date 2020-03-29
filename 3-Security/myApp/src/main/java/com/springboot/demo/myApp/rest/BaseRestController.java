package com.springboot.demo.myApp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class BaseRestController {

    // expose "/" that return "Hello World"
    @GetMapping("/")
    public String sayHello(){
        return "Hello World Time on Server is" + LocalDateTime.now();
    }
}
