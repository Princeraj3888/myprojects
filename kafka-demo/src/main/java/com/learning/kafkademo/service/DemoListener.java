package com.learning.kafkademo.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class DemoListener {

    @KafkaListener(topics = "demo-topic1", groupId = "demo-group")
    public String listenToDemoKafkaTopic(String receivedMessage){
        System.out.println("message received from kakfa: "+receivedMessage);
        return receivedMessage;
    }
}
