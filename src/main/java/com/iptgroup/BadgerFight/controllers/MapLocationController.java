package com.iptgroup.BadgerFight.controllers;

import com.iptgroup.BadgerFight.entity.MapLocationEntity;
import com.iptgroup.BadgerFight.services.MapLocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/admin/map")
@RequiredArgsConstructor
public class MapLocationController {

    private final MapLocationService mapLocationService;

    // Все локации
    @GetMapping("/locations")
    public List<MapLocationEntity> getAllLocations() {
        return mapLocationService.getAllLocations();
    }

    // Инфо по конкретной локации
    @GetMapping("/locations/{id}")
    public MapLocationEntity getLocation(@PathVariable Long id) {
        return mapLocationService.getLocationById(id);
    }

    // Соседние локации
    @GetMapping("/locations/{id}/connections")
    public List<MapLocationEntity> getConnections(@PathVariable Long id) {
        return mapLocationService.getConnections(id);
    }

    // Враг в локации
    @GetMapping("/locations/{id}/enemy")
    public ResponseEntity<?> getEnemy(@PathVariable Long id) {
        return mapLocationService.getEnemyInLocation(id)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NO_CONTENT).body("Врага нет"));
    }

    // Квест в локации
    @GetMapping("/locations/{id}/quest")
    public ResponseEntity<?> getQuest(@PathVariable Long id) {
        return mapLocationService.getQuestInLocation(id)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NO_CONTENT).body("Квеста нет"));
    }
}
