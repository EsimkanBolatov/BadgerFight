package com.iptgroup.BadgerFight.repository;

import com.iptgroup.BadgerFight.entity.EnemyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnemyRepository extends JpaRepository<EnemyEntity, Long> {
    EnemyEntity findByName(String name);  // Метод для поиска врага по имени
}
