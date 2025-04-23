package com.iptgroup.BadgerFight.kafka.producer;

import com.iptgroup.BadgerFight.dto.RewardRequestEventDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RewardRequestProducer {

    private final KafkaTemplate<String, RewardRequestEventDTO> kafkaTemplate;
    private final String topic = "reward-requests";

    public void send(RewardRequestEventDTO event) {
        kafkaTemplate.send(topic, event.getUserId().toString(), event);
    }

}
