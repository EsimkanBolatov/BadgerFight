package com.iptgroup.BadgerFight.services;

import com.iptgroup.BadgerFight.entity.EnemyEntity;
import com.iptgroup.BadgerFight.entity.MapLocationEntity;
import com.iptgroup.BadgerFight.entity.QuestEntity;
import com.iptgroup.BadgerFight.repository.MapLocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MapLocationService {

    private final MapLocationRepository locationRepository;

    //poluchit vse location
    public List<MapLocationEntity> getAllLocations(){
        return locationRepository.findAll();
    }

    //poluchit location po id
    public MapLocationEntity getLocationById(Long id){
        return locationRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Локация не нвйдена " + id));
    }

    //poluchit dostupnie perekhodi
    public List<MapLocationEntity> getConnections(Long locationId){
        MapLocationEntity location = getLocationById(locationId);
        return new ArrayList<>(location.getConnections()); //осы жермен абай бол потому что сет тын орнына лист жиберип отрм
    }

    //poluchit vraga po id v location
    public Optional<EnemyEntity> getEnemyInLocation(Long locationId) {
        return Optional.ofNullable(getLocationById(locationId).getEntity());
    }

    //poluchit quest v location
    public Optional<QuestEntity> getQuestInLocation(Long locationId) {
        return Optional.ofNullable(getLocationById(locationId).getQuest());
    }

}
