package com.iptgroup.BadgerFight.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "players")
public class PlayerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;
    private int health;
    private int attack;

    //геттеры и сеттеры
    public Long getId() {return id; }
    public void setId(Long id) {this.id = id; }

    public String getName() {return name; }
    public void setName(String name) {this.name = name;}

    public  int getHealth() { return health; }
    public void setHealth(int health) { this.health = health; }

    public int getAttack() {return attack; }
    public void setAttack(int attack) {this.attack = attack; }

    //конструктор
    public PlayerEntity() {}
    public PlayerEntity(String name, int health, int attack){
        this.name = name;
        this.health = health;
        this.attack = attack;
    }


}
