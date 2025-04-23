package com.iptgroup.BadgerFight.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RewardRequestEventDTO {
    private Long userId;
    private String rewardType;
    private int amount;
}
