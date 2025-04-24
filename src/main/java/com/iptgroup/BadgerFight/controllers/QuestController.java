package com.iptgroup.BadgerFight.controllers;

import com.iptgroup.BadgerFight.entity.QuestEntity;
import com.iptgroup.BadgerFight.repository.QuestRepository;
import com.iptgroup.BadgerFight.services.QuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user/quests")
public class QuestController {

    private final QuestService questService;
    private final QuestRepository questRepository;

    @Autowired
    public QuestController(QuestService questService, QuestRepository questRepository) {
        this.questService = questService;
        this.questRepository = questRepository;
    }

    @GetMapping("/test")
    public String test() {
        return "QuestController is working!";
    }

    @GetMapping
    public List<QuestEntity> getAllQuests() {
        return  questRepository .findAll();
    }

    // Начать квест
    @PostMapping("/start")
    public String startQuest(@RequestBody Long playerId, @RequestBody Long questId) {
        //Логика начала квеста
        System.out.println("Start quest called with playerId=" + playerId + ", questId=" + questId);
        return questService.startQuest(playerId, questId);
    }

    // Обновить прогресс квеста
    @PostMapping("/progress")
    public String updateProgress(@RequestBody Long playerId, @RequestBody Long questId, @RequestBody String answer) {
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
    public ResponseEntity<String> checkAnswer(@PathVariable Long stepId, @RequestBody String answer) {
        return ResponseEntity.ok(questService.checkAnswer(stepId, answer));
    }
}

