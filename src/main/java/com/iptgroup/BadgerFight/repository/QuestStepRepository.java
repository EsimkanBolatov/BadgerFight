package com.iptgroup.BadgerFight.repository;

import com.iptgroup.BadgerFight.entity.QuestStepEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestStepRepository extends JpaRepository<QuestStepEntity, Long> {
}
