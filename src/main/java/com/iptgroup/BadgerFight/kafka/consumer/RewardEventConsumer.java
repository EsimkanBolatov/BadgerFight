package com.iptgroup.BadgerFight.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class RewardEventConsumer {

    @KafkaListener(topics = "reward-events", groupId = "reward-group")
    public void consume(String message) {
        System.out.println("Получено сообщение: " + message);

    }
}
