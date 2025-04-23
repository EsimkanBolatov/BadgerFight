package com.iptgroup.BadgerFight.controllers;

import com.iptgroup.BadgerFight.services.BattleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user/battle")
public class BattleController {

    private final BattleService battleService;

    public BattleController(BattleService battleService) {
        this.battleService = battleService;
    }

    @PostMapping("/attack/{enemyName}")
    public ResponseEntity<String> attackEnemy(@PathVariable String enemyName) {
        return battleService.attackEnemy(enemyName);
    }
}

