package com.iptgroup.BadgerFight.controllers;

import com.iptgroup.BadgerFight.dto.RewardRequestEventDTO;
import com.iptgroup.BadgerFight.kafka.producer.RewardRequestProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class TestController {

    private final RewardRequestProducer producer;

    @PostMapping("/test/reward")
    public String sendReward() {
        RewardRequestEventDTO event = new RewardRequestEventDTO();
        event.setUserId(1L);
        event.setRewardType("GOLD");
        event.setAmount(100);
        producer.send(event);
        return "Reward request sent";
    }
}
