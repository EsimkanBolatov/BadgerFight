package com.iptgroup.BadgerFight.services;

import com.iptgroup.BadgerFight.entity.EnemyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BattleService {

    @Autowired
    private EnemyService enemyService;  // Используем сервис для работы с врагами

    public String attackEnemy(String enemyName) {
        Optional<EnemyEntity> enemyOptional = enemyService.getEnemyByName(enemyName);

        if (enemyOptional.isPresent()) {
            EnemyEntity enemyEntity = enemyOptional.get();

            // Простая логика уменьшения жизни врага при атаке
            int damage = 10; // Фиксированный урон
            enemyEntity.setHealth(enemyEntity.getHealth() - damage);

            // Проверяем, побежден ли враг
            if (enemyEntity.getHealth() <= 0) {
                return "Вы победили " + enemyEntity.getName() + "!";
            } else {
                return enemyEntity.getName() + " получил " + damage + " урона. Осталось " + enemyEntity.getHealth() + " здоровья.";
            }
        } else {
            return "Враг с именем " + enemyName + " не найден.";
        }
    }
}


