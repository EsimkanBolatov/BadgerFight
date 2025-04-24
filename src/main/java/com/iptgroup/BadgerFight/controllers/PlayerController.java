package com.iptgroup.BadgerFight.controllers;

import com.iptgroup.BadgerFight.entity.PlayerEntity;
import com.iptgroup.BadgerFight.repository.PlayerRepository;
import com.iptgroup.BadgerFight.services.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user/players")
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerService playerService;
    private final PlayerRepository playerRepository;

    @GetMapping
    public List<PlayerEntity> getAllPlayers() {
        return playerRepository.findAll();
    }

        // POST: Создание игрока для пользователя
    @PostMapping("/{username}")
    public ResponseEntity<PlayerEntity> createPlayerForUser(
            @PathVariable String username,
            @RequestBody String playerName) {
        try {
            PlayerEntity newPlayer = playerService.createPlayerForUser(username, playerName);
            return ResponseEntity.status(HttpStatus.CREATED).body(newPlayer);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    // PUT: Обновление данных игрока
    @PutMapping("/{id}")
    public ResponseEntity<PlayerEntity> updatePlayer(@PathVariable Long id, @RequestBody PlayerEntity playerDetails) {
        try {
            PlayerEntity updatedPlayer = playerService.updatePlayer(id, playerDetails);
            return ResponseEntity.ok(updatedPlayer);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}


