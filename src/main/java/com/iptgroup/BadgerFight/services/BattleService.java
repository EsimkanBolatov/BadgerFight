package com.iptgroup.BadgerFight.services;

import com.iptgroup.BadgerFight.entity.EnemyEntity;
import com.iptgroup.BadgerFight.repository.EnemyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BattleService {

    private static final Logger logger = LoggerFactory.getLogger(BattleService.class);

    @Autowired
    private EnemyService enemyService;

    @Autowired
    private EnemyRepository enemyRepository;

    public ResponseEntity<String> attackEnemy(String enemyName) {
        logger.info("Запрос атаки на врага: {}", enemyName);

        if (enemyName == null || enemyName.isEmpty()) {
            logger.error("Ошибка: Имя врага не может быть пустым!");
            return ResponseEntity.badRequest().body("Ошибка: Имя врага не может быть пустым!");
        }

        Optional<EnemyEntity> enemyOptional = enemyService.getEnemyByName(enemyName);

        if (enemyOptional.isEmpty()) {
            logger.error("Ошибка: Враг '{}' не найден в базе данных", enemyName);
            return ResponseEntity.badRequest().body("Ошибка: Враг '" + enemyName + "' не найден.");
        }

        EnemyEntity enemyEntity = enemyOptional.get();
        logger.info("Найден враг: {} (Здоровье: {}, Атака: {})", enemyEntity.getName(), enemyEntity.getHealth(), enemyEntity.getAttack());

        int damage = 10;
        enemyEntity.setHealth(enemyEntity.getHealth() - damage);

        // Сохраняем обновленные данные в базе
        enemyRepository.save(enemyEntity);
        logger.info("После атаки у '{}' осталось {} здоровья", enemyEntity.getName(), enemyEntity.getHealth());

        if (enemyEntity.getHealth() <= 0) {
            return ResponseEntity.ok("Вы победили " + enemyEntity.getName() + "!");
        } else {
            return ResponseEntity.ok(enemyEntity.getName() + " получил " + damage + " урона. Осталось " + enemyEntity.getHealth() + " здоровья.");
        }
    }
}


