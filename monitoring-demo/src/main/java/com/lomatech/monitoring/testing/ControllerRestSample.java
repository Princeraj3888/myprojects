package com.lomatech.monitoring.testing;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerRestSample {

    @GetMapping("/hello")
    public String sayHelloMethod(){
        System.out.println("hi this message is to test the logging in prometheus..");
        return "Hello";
    }
}
