package com.iptgroup.BadgerFight.repository;

import com.iptgroup.BadgerFight.entity.QuestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestRepository extends JpaRepository<QuestEntity, Long> {
}

