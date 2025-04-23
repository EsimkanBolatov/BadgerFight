package com.iptgroup.BadgerFight.entity;

import com.iptgroup.BadgerFight.entity.PlayerEntity;
import com.iptgroup.BadgerFight.entity.QuestEntity;
import jakarta.persistence.*;

@Entity
public class PlayerQuestProgressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private PlayerEntity player;

    @ManyToOne
    @JoinColumn(name = "quest_id")
    private QuestEntity quest;

    private int currentStep;
    private boolean completed;

    // Геттеры и сеттеры
    public PlayerEntity getPlayer() {
        return player;
    }

    public void setPlayer(PlayerEntity player) {
        this.player = player;
    }

    public QuestEntity getQuest() {
        return quest;
    }

    public void setQuest(QuestEntity quest) {
        this.quest = quest;
    }

    public int getCurrentStep() {
        return currentStep;
    }

    public void setCurrentStep(int currentStep) {
        this.currentStep = currentStep;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
}

