package com.iptgroup.BadgerFight.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "players")
public class PlayerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int level;

    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL)
    private List<PlayerQuestProgressEntity> questProgress;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public List<PlayerQuestProgressEntity> getQuestProgress() {return  questProgress;}
    public void setQuestProgress(List<PlayerQuestProgressEntity> questProgress) {this.questProgress = questProgress;}

    // Геттеры и сеттеры
}

