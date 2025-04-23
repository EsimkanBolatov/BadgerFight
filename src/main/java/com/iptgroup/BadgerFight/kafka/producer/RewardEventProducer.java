package com.iptgroup.BadgerFight.kafka.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class RewardEventProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public RewardEventProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendRewardEvent(String message) {
        kafkaTemplate.send("reward-events", message);
    }
}
