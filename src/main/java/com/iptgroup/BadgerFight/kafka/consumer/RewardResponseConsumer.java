package com.iptgroup.BadgerFight.kafka.consumer;

import com.iptgroup.BadgerFight.dto.RewardResultEventDTO;
import org.springframework.kafka.annotation.KafkaListener;

public class RewardResponseConsumer {

    @KafkaListener(
            topics = "reward-responses",
            groupId = "fight-response-group",
            containerFactory = "jsonListenerContainerFactory"
    )
    public void onRewardResponse(RewardResultEventDTO event) {
        // Например, фиксируем в логах или запускаем внутреннюю логику:
        System.out.printf("Пользователь %d: успех=%s, %s%n",
                event.getUserId(), event.isSuccess(), event.getDetails());
        // тут можно обновить состояние игры, отправить нотификацию и т.п.
        System.out.println("Получен ответ от Reward: " + event);

    }

}
