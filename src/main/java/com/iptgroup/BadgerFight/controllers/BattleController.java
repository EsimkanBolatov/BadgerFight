package com.iptgroup.BadgerFight.controllers;

import com.iptgroup.BadgerFight.models.PlayerModels;
import com.iptgroup.BadgerFight.services.BattleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
@Tag(name = "battle_methods(BattleController)")
@RestController
@RequestMapping("/api/battle")
public class BattleController {
    private final BattleService battleService;

    public BattleController(BattleService battleService) {
        this.battleService = battleService;
    }

    @PostMapping("/attack/{enemyName}")
    public String attackEnemy(@PathVariable String enemyName, @RequestBody PlayerModels playerModels) {
        return battleService.attackEnemy(enemyName);
    }
}

