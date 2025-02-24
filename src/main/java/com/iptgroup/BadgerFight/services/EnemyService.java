package com.iptgroup.BadgerFight.services;

import com.iptgroup.BadgerFight.entity.EnemyEntity;
import com.iptgroup.BadgerFight.repository.EnemyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnemyService {

    @Autowired
    private EnemyRepository enemyRepository;

    // Получить всех врагов
    public List<EnemyEntity> getAllEnemies() {
        return enemyRepository.findAll();
    }

    // Найти врага по ID
    public Optional<EnemyEntity> getEnemyById(Long id) {
        return enemyRepository.findById(id);
    }

    public Optional<EnemyEntity> getEnemyByName(String name) {
        return Optional.ofNullable(enemyRepository.findByName(name));
    }

    // Добавить нового врага
    public EnemyEntity createEnemy(EnemyEntity enemyEntity) {
        return enemyRepository.save(enemyEntity);
    }

    // Удалить врага по ID
    public void deleteEnemy(Long id) {
        enemyRepository.deleteById(id);
    }
}

