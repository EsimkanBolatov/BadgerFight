package com.iptgroup.BadgerFight.controllers;

import com.iptgroup.BadgerFight.entity.InventoryEntity;
import com.iptgroup.BadgerFight.repository.InventoryRepository;
import com.iptgroup.BadgerFight.services.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user/inventory")
@RequiredArgsConstructor
public class InventoryController {
    private final InventoryRepository inventoryRepository;
    private final InventoryService inventoryService;

    @PostMapping("/{username}")
    public ResponseEntity<InventoryEntity> addInventory(@PathVariable String username) {
        try{
            InventoryEntity inventory = inventoryService.createInventoryForUser(username);
            return ResponseEntity.status(HttpStatus.CREATED).body(inventory);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }


}
