package com.iptgroup.BadgerFight.repository;

import com.iptgroup.BadgerFight.entity.PlayerQuestProgressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerQuestProgressRepository extends JpaRepository<PlayerQuestProgressEntity, Long> {
    Optional<PlayerQuestProgressEntity> findByPlayerIdAndQuestId(Long playerId, Long questId);
}

