package com.learning.kafkademo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
    @RequestMapping("/api/v1")
public class KafkaPublishMessageController {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @GetMapping("/publishMessage")
    public String publishMessageToKafkaTopic(@RequestParam("message") String message){
        kafkaTemplate.send("demo-topic1", message);

        return "message sent successfully";
    }
}
