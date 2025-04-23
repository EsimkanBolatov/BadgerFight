package com.iptgroup.BadgerFight.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RewardResultEventDTO {

    private Long userId;
    private boolean success;
    private String details;

}
