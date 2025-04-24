package com.iptgroup.BadgerFight.repository;

import com.iptgroup.BadgerFight.entity.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<PlayerEntity, Long> {
    PlayerEntity findByUsername(String username);

    @Override
    List<PlayerEntity> findAll();
}

