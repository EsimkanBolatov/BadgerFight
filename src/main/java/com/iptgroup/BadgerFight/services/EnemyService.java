package com.iptgroup.BadgerFight.services;

import com.iptgroup.BadgerFight.entity.EnemyEntity;
import com.iptgroup.BadgerFight.repository.EnemyRepository;
import jakarta.validation.Valid;
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

    // Получить врага по ID
    public Optional<EnemyEntity> getEnemyById(Long id) {
        return enemyRepository.findById(id);
    }

    // Создать нового врага
    public EnemyEntity createEnemy(EnemyEntity enemyEntity) {
        return enemyRepository.save(enemyEntity);
    }

    public Optional<EnemyEntity> getEnemyByName(String name) {
        return enemyRepository.findByName(name);
    }


    // Удалить врага
    public void deleteEnemy(Long id) {
        enemyRepository.deleteById(id);
    }

    // Обновить врага
    public EnemyEntity updateEnemy(Long id, EnemyEntity updatedEnemy) {
        return enemyRepository.findById(id)
                .map(existingEnemy -> {
                    existingEnemy.setName(updatedEnemy.getName());
                    existingEnemy.setAttack(updatedEnemy.getAttack());
                    existingEnemy.setHealth(updatedEnemy.getHealth());
                    return enemyRepository.save(existingEnemy);
                })
                .orElseThrow(() -> new RuntimeException("Враг с ID " + id + " не найден"));
    }
}
