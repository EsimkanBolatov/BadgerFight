package com.iptgroup.BadgerFight.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "quest_steps")
@Data // Lombok автоматически создаст геттеры, сеттеры, toString и equals/hashCode
public class QuestStepEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int stepNumber; // Номер этапа
    private String question; // Вопрос или задание
    private String correctAnswer; // Верный ответ

    @ManyToOne
    @JoinColumn(name = "quest_id", nullable = false)
    private QuestEntity quest;
}


