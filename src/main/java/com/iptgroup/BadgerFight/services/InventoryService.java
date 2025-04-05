package com.iptgroup.BadgerFight.services;

import com.iptgroup.BadgerFight.entity.InventoryEntity;
import com.iptgroup.BadgerFight.entity.UserEntity;
import com.iptgroup.BadgerFight.repository.InventoryRepository;
import com.iptgroup.BadgerFight.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;
    private final UserRepository userRepository;

    public InventoryEntity createInventoryForUser(String username) {
        UserEntity user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (user.getInventory() != null) {
            throw new RuntimeException("User already has an inventory");
        }

        InventoryEntity inventory = new InventoryEntity();
        inventory.setUser(user);
        inventory.setGold(0);
        inventory.setItemsCount(0);

        return inventoryRepository.save(inventory);
    }
}

