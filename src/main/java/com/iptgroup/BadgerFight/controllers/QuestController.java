package com.iptgroup.BadgerFight.controllers;

import com.iptgroup.BadgerFight.entity.QuestEntity;
import com.iptgroup.BadgerFight.services.QuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user/quests")
public class QuestController {

    private final QuestService questService;

    @Autowired
    public QuestController(QuestService questService) {
        this.questService = questService;
    }

    @GetMapping("/test")
    public String test() {
        return "QuestController is working!";
    }

    // Начать квест
    @PostMapping("/start")
    public String startQuest(@RequestParam Long playerId, @RequestParam Long questId) {
        //Логика начала квеста
        System.out.println("Start quest called with playerId=" + playerId + ", questId=" + questId);
        return questService.startQuest(playerId, questId);
    }

    // Обновить прогресс квеста
    @PostMapping("/progress")
    public String updateProgress(@RequestParam Long playerId, @RequestParam Long questId, @RequestParam String answer) {
        return questService.updateQuestProgress(playerId, questId, answer);
    }

    @PostMapping
    public QuestEntity createQuest(@RequestBody QuestEntity quest) {
        return questService.createQuest(quest);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getQuest(@PathVariable Long id) {
        return questService.getQuestById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/checkAnswer/{stepId}")
    public ResponseEntity<String> checkAnswer(@PathVariable Long stepId, @RequestParam String answer) {
        return ResponseEntity.ok(questService.checkAnswer(stepId, answer));
    }
}

