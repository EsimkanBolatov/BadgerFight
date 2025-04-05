package com.iptgroup.BadgerFight.repository;

import com.iptgroup.BadgerFight.entity.EnemyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface EnemyRepository extends JpaRepository<EnemyEntity, Long> {
    Optional<EnemyEntity> findByName(String name);
}
