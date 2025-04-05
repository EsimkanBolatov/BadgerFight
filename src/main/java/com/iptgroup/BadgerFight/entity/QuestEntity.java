package com.iptgroup.BadgerFight.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "quests")
public class QuestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @OneToMany(mappedBy = "quest", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<QuestStepEntity> steps;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    // Геттеры и сеттеры
}

