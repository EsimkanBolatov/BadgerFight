package com.iptgroup.BadgerFight.controllers;

import com.iptgroup.BadgerFight.entity.EnemyEntity;
import com.iptgroup.BadgerFight.services.EnemyService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@Tag(name = "enemy_methods(EnemyController)")
@RestController
@RequestMapping("/api/enemies")  // URL для запросов
public class EnemyController {

    @Autowired
    private EnemyService enemyService;

    // Получить список всех врагов
    @GetMapping
    public List<EnemyEntity> getAllEnemies() {
        return enemyService.getAllEnemies();
    }

    // Получить врага по ID
    @GetMapping("/{id}")
    public ResponseEntity<EnemyEntity> getEnemyById(@PathVariable Long id) {
        Optional<EnemyEntity> enemy = enemyService.getEnemyById(id);
        return enemy.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Добавить нового врага
    @PostMapping
    public EnemyEntity createEnemy(@RequestBody EnemyEntity enemyEntity) {
        return enemyService.createEnemy(enemyEntity);
    }

    // Удалить врага по ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEnemy(@PathVariable Long id) {
        enemyService.deleteEnemy(id);
        return ResponseEntity.noContent().build();
    }
}

