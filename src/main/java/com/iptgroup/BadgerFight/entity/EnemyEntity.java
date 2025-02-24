package com.iptgroup.BadgerFight.entity; // Указываем пакет

import jakarta.persistence.*;

@Entity  // Говорит, что это сущность для базы данных
@Table(name = "enemies")  // Таблица в PostgreSQL будет называться "enemies"
public class EnemyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Уникальный ID врага

    @Column(nullable = false, unique = true)
    private String name;  // Имя врага (уникальное)

    private int health;  // Здоровье
    private int attack;  // Атака

    // Геттеры и сеттеры
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getHealth() { return health; }
    public void setHealth(int health) { this.health = health; }

    public int getAttack() { return attack; }
    public void setAttack(int attack) { this.attack = attack; }

    // Конструкторы
    public EnemyEntity() {}  // Пустой конструктор (нужен JPA)

    public EnemyEntity(String name, int health, int attack) {  // Конструктор с параметрами
        this.name = name;
        this.health = health;
        this.attack = attack;
    }
}

