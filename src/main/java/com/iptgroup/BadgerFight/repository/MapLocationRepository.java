package com.iptgroup.BadgerFight.repository;

import com.iptgroup.BadgerFight.entity.MapLocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MapLocationRepository extends JpaRepository<MapLocationEntity, Long> {

}
